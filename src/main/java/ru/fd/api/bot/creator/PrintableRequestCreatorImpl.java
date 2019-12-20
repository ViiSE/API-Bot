package ru.fd.api.bot.creator;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import ru.fd.api.bot.entity.Request;
import ru.fd.api.bot.producer.entity.RequestProducer;
import ru.fd.api.bot.producer.print.PrinterProducer;
import ru.fd.api.bot.time.DateFormatter;

import java.util.Map;

@Service("printableRequestCreator")
@Scope("prototype")
public class PrintableRequestCreatorImpl implements RequestCreator<Map<String, Object>> {

    private final RequestProducer requestProducer;
    private final RequestCreator<Map<String, Object>> requestCreator;
    private final PrinterProducer printerProducer;
    private final DateFormatter dateFormatter;
    private final String fullFilename;

    public PrintableRequestCreatorImpl(
            RequestProducer requestProducer,
            RequestCreator<Map<String, Object>> requestCreator,
            PrinterProducer printerProducer,
            DateFormatter dateFormatter,
            String fullFilename) {
        this.requestProducer = requestProducer;
        this.requestCreator = requestCreator;
        this.printerProducer = printerProducer;
        this.dateFormatter = dateFormatter;
        this.fullFilename = fullFilename;
    }

    @Override
    public Request<Map<String, Object>> create() {
        return requestProducer.getPrintableRequestInstance(
                requestCreator.create(),
                printerProducer,
                dateFormatter,
                fullFilename);
    }
}
