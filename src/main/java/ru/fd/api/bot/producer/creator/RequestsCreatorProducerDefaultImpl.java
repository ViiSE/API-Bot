package ru.fd.api.bot.producer.creator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;
import ru.fd.api.bot.creator.RequestsCreator;
import ru.fd.api.bot.data.SettingsPojo;
import ru.fd.api.bot.producer.entity.RequestsProducer;
import ru.fd.api.bot.producer.print.PrinterProducer;
import ru.fd.api.bot.service.CreatorService;
import ru.fd.api.bot.time.DateFormatter;

@Service("requestsCreatorProducerDefault")
public class RequestsCreatorProducerDefaultImpl implements RequestsCreatorProducer {

    @Autowired
    private ApplicationContext ctx;

    @Override
    public RequestsCreator getRequestsCreatorDefaultInstance(
            CreatorService creatorService,
            RequestsProducer requestsProducer,
            PrinterProducer printerProducer,
            SettingsPojo settingsPojo,
            DateFormatter dateFormatter) {
        return (RequestsCreator) ctx.getBean(
                "requestsCreatorDefault",
                creatorService,
                requestsProducer,
                printerProducer,
                settingsPojo,
                dateFormatter);
    }
}
