package ru.fd.api.bot.entity;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import ru.fd.api.bot.exception.RequestException;
import ru.fd.api.bot.print.Printer;
import ru.fd.api.bot.producer.print.PrinterProducer;
import ru.fd.api.bot.time.DateFormatter;

import java.util.Map;

@Component("printableRequest")
@Scope("prototype")
public class PrintableRequestImpl implements Request<Map<String, Object>> {

    private final Request<Map<String, Object>> request;
    private final PrinterProducer printerProducer;
    private final DateFormatter dateFormatter;
    private final String fullFilename;

    public PrintableRequestImpl(
            Request<Map<String, Object>> request,
            PrinterProducer printerProducer,
            DateFormatter dateFormatter,
            String fullFilename) {
        this.request = request;
        this.printerProducer = printerProducer;
        this.dateFormatter = dateFormatter;
        this.fullFilename = fullFilename;
    }

    @Override
    public RequestResult<Map<String, Object>> execute() throws RequestException {
        RequestResult<Map<String, Object>> reqRes = request.execute();

        Printer<String> tcp = printerProducer.getPrinterDefaultInstance(reqRes, dateFormatter);
        printerProducer.getPrinterToWindowInstance(tcp);
        printerProducer.getPrinterToFileInstance(tcp, fullFilename).print();

        return reqRes;
    }
}
