package ru.fd.api.bot.producer.creator;

import ru.fd.api.bot.creator.RequestCreator;
import ru.fd.api.bot.data.AuthPojo;
import ru.fd.api.bot.data.RequestPojo;
import ru.fd.api.bot.producer.entity.RequestProducer;
import ru.fd.api.bot.producer.entity.RequestResultProducer;
import ru.fd.api.bot.producer.print.PrinterProducer;
import ru.fd.api.bot.service.CreatorService;
import ru.fd.api.bot.time.DateFormatter;

import java.util.Map;

public interface RequestCreatorProducer {
    RequestCreator<Map<String, Object>> getGetRequestCreatorDefaultInstance(
            CreatorService creatorService,
            RequestProducer requestProducer,
            RequestResultProducer requestResultProducer,
            RequestPojo request,
            AuthPojo auth,
            String hostname);
    RequestCreator<Map<String, Object>> getRequestCreatorWithAuthInstance(
            CreatorService creatorService,
            RequestProducer requestProducer,
            RequestResultProducer requestResultProducer,
            RequestPojo request,
            String hostname);
    RequestCreator<Map<String, Object>> getBenchmarkRequestCreatorInstance(
            RequestProducer requestProducer,
            RequestCreator<Map<String, Object>> requestCreator);
    RequestCreator<Map<String, Object>> getPrintableRequestCreatorInstance(
            RequestProducer requestProducer,
            RequestCreator<Map<String, Object>> requestCreator,
            PrinterProducer printerProducer,
            DateFormatter dateFormatter,
            String fullFilename);

}
