package ru.fd.api.bot.producer.creator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;
import ru.fd.api.bot.creator.*;
import ru.fd.api.bot.data.AuthPojo;
import ru.fd.api.bot.data.RequestPojo;
import ru.fd.api.bot.producer.entity.RequestProducer;
import ru.fd.api.bot.producer.entity.RequestResultProducer;
import ru.fd.api.bot.producer.print.PrinterProducer;
import ru.fd.api.bot.service.CreatorService;
import ru.fd.api.bot.time.DateFormatter;

import java.util.Map;

@Service("requestCreatorProducerDefault")
public class RequestCreatorProducerDefaultImpl implements RequestCreatorProducer {

    @Autowired
    private ApplicationContext ctx;

    @Override
    public RequestCreator<Map<String, Object>> getGetRequestCreatorDefaultInstance(
            CreatorService creatorService,
            RequestProducer requestProducer,
            RequestResultProducer requestResultProducer,
            RequestPojo request,
            AuthPojo auth,
            String hostname) {
        return (GetRequestCreatorDefaultImpl) ctx.getBean(
                "getRequestCreatorDefault",
                creatorService,
                requestProducer,
                requestResultProducer,
                request,
                auth,
                hostname);
    }

    @Override
    public RequestCreator<Map<String, Object>> getRequestCreatorWithAuthInstance(
            CreatorService creatorService,
            RequestProducer requestProducer,
            RequestResultProducer requestResultProducer,
            RequestPojo request,
            String hostname) {
        return (RequestCreatorWithAuthImpl) ctx.getBean(
                "requestCreatorWithAuth",
                creatorService,
                requestProducer,
                requestResultProducer,
                request,
                hostname);
    }

    @Override
    public RequestCreator<Map<String, Object>> getBenchmarkRequestCreatorInstance(
            RequestProducer requestProducer,
            RequestCreator<Map<String, Object>> requestCreator) {
        return (BenchmarkRequestCreatorImpl) ctx.getBean(
                "benchmarkRequestCreator",
                requestProducer,
                requestCreator);
    }

    @Override
    public RequestCreator<Map<String, Object>> getPrintableRequestCreatorInstance(
            RequestProducer requestProducer,
            RequestCreator<Map<String, Object>> requestCreator,
            PrinterProducer printerProducer,
            DateFormatter dateFormatter,
            String fullFilename) {
        return (PrintableRequestCreatorImpl) ctx.getBean(
                "printableRequestCreator",
                requestProducer,
                requestCreator,
                printerProducer,
                dateFormatter,
                fullFilename);
    }
}
