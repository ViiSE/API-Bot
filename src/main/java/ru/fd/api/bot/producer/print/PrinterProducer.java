package ru.fd.api.bot.producer.print;

import ru.fd.api.bot.entity.RequestResult;
import ru.fd.api.bot.print.Printer;
import ru.fd.api.bot.time.DateFormatter;

import java.io.File;
import java.util.Map;

public interface PrinterProducer {
    Printer<String> getPrinterDefaultInstance(RequestResult<Map<String, Object>> requestResult, DateFormatter dateFormatter);
    Printer<Void> getPrinterToWindowInstance(Printer<String> printer);
    Printer<File> getPrinterToFileInstance(Printer<String> printer, String fullFilename);
    Printer<String> getPrinterStringInstance(String message);
}
