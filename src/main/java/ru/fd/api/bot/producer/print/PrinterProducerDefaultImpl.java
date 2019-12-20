package ru.fd.api.bot.producer.print;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;
import ru.fd.api.bot.entity.RequestResult;
import ru.fd.api.bot.print.*;
import ru.fd.api.bot.time.DateFormatter;

import java.io.File;
import java.util.Map;

@Service("printerProducerDefault")
public class PrinterProducerDefaultImpl implements PrinterProducer {

    @Autowired
    private ApplicationContext ctx;

    @Override
    public Printer<String> getPrinterDefaultInstance(RequestResult<Map<String, Object>> requestResult, DateFormatter dateFormatter) {
        return (PrinterDefaultImpl) ctx.getBean("printerDefault", requestResult, dateFormatter);
    }

    @Override
    public Printer<Void> getPrinterToWindowInstance(Printer<String> printer) {
        return (PrinterToWindowImpl) ctx.getBean("printerToWindow", printer);
    }

    @Override
    public Printer<File> getPrinterToFileInstance(Printer<String> printer, String fullFilename) {
        return (PrinterToFileImpl) ctx.getBean("printerToFile", printer, fullFilename);
    }

    @Override
    public Printer<String> getPrinterStringInstance(String message) {
        return (PrinterStringImpl) ctx.getBean("printerString", message);
    }
}
