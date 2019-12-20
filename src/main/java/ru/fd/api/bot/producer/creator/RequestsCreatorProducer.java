package ru.fd.api.bot.producer.creator;

import ru.fd.api.bot.creator.RequestsCreator;
import ru.fd.api.bot.data.SettingsPojo;
import ru.fd.api.bot.producer.entity.RequestsProducer;
import ru.fd.api.bot.producer.print.PrinterProducer;
import ru.fd.api.bot.service.CreatorService;
import ru.fd.api.bot.time.DateFormatter;

public interface RequestsCreatorProducer {
    RequestsCreator getRequestsCreatorDefaultInstance(
            CreatorService creatorService,
            RequestsProducer requestsProducer,
            PrinterProducer printerProducer,
            SettingsPojo settingsPojo,
            DateFormatter dateFormatter);
}
