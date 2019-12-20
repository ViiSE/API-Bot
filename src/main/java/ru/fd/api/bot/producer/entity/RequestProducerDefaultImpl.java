package ru.fd.api.bot.producer.entity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;
import ru.fd.api.bot.entity.*;
import ru.fd.api.bot.producer.print.PrinterProducer;
import ru.fd.api.bot.time.DateFormatter;

import java.util.Map;

@Service("requestProducerDefault")
public class RequestProducerDefaultImpl implements RequestProducer {

    @Autowired
    private ApplicationContext ctx;

    @Override
    public Request<Map<String, Object>> getGetRequestDefaultInstance(String method, String url, Auth<String> auth, RequestResultProducer requestResultProducer) {
        return (GetRequestDefaultImpl) ctx.getBean("getRequestDefault", method, url, auth, requestResultProducer);
    }

    @Override
    public Request<Map<String, Object>> getBenchmarkRequestInstance(Request<Map<String, Object>> request) {
        return (BenchmarkRequestImpl) ctx.getBean("benchmarkRequest", request);
    }

    @Override
    public Request<Map<String, Object>> getPrintableRequestInstance(Request<Map<String, Object>> request, PrinterProducer printerProducer, DateFormatter dateFormatter, String fullFilename) {
        return (PrintableRequestImpl) ctx.getBean("printableRequest", request, printerProducer, dateFormatter, fullFilename);
    }
}


