package ru.fd.api.bot;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import ru.fd.api.bot.entity.Request;
import ru.fd.api.bot.entity.Response;
import ru.fd.api.bot.entity.ResponseFormat;
import ru.fd.api.bot.entity.Settings;
import ru.fd.api.bot.exception.RequestException;
import ru.fd.api.bot.print.Printer;
import ru.fd.api.bot.print.PrinterToFileImpl;

@Component("botDefault")
public class BotDefaultImpl implements Bot {

    private final Printer<String> printer;
    private final Printer<String> printerFile;
    private final ResponseFormat<String> responseFormat;

    public BotDefaultImpl(
            @Qualifier("printerToWindow") Printer<String> printer,
            @Qualifier("printerToFile") Printer<String> printerFile,
            ResponseFormat<String> responseFormat) {
        this.printer = printer;
        this.printerFile = printerFile;
        this.responseFormat = responseFormat;
    }

    @Override
    public void execute(Settings<Request> settings) {
        try {
            int amountRepeat = settings.repeat();
            for (int i = 0; i < amountRepeat; i++) {
                for (Request request : settings.requests()) {
                    Response response = request.execute();
                    String respFormat = responseFormat.format(response);
                    ((PrinterToFileImpl) printerFile).print(settings.fullFilename(), respFormat);
                    printer.print(respFormat);
                }
            }
        } catch(RequestException ex) {
            printer.print(ex.getMessage());
        }
    }
}
