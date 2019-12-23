package ru.fd.api.bot;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import ru.fd.api.bot.entity.Request;
import ru.fd.api.bot.entity.RequestResult;
import ru.fd.api.bot.entity.RequestResultMapDefaultImpl;
import ru.fd.api.bot.entity.Settings;
import ru.fd.api.bot.exception.RequestException;
import ru.fd.api.bot.producer.print.PrinterProducer;
import ru.fd.api.bot.time.DateFormatter;

import java.util.Map;

@Component("botDefault")
@Scope("prototype")
public class BotDefaultImpl implements Bot {

    private final Settings settings;
    private final PrinterProducer printerProducer;

    public BotDefaultImpl(Settings settings, PrinterProducer printerProducer) {
        this.settings = settings;
        this.printerProducer = printerProducer;
    }

    @Override
    public void execute() {
        try {
            int amountRepeat = settings.repeat();
            for (int i = 0; i < amountRepeat; i++) {
                for (Request request : settings.requests()) {
                    request.execute(); }
            }
        } catch(RequestException ex) {
            printerProducer.getPrinterToWindowInstance(printerProducer.getPrinterStringInstance(ex.getMessage())).print();
        }
    }
}
