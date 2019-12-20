package ru.fd.api.bot.service;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import ru.fd.api.bot.producer.print.PrinterProducer;

@Service("printerProducerServiceDefault")
@Scope("prototype")
public class PrinterProducerServiceDefaultImpl implements PrinterProducerService {

    private final PrinterProducer printerProducer;

    public PrinterProducerServiceDefaultImpl(PrinterProducer printerProducer) {
        this.printerProducer = printerProducer;
    }

    @Override
    public PrinterProducer printerProducer() {
        return printerProducer;
    }
}
