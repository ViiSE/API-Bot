package ru.fd.api.bot.producer.entity;

import ru.fd.api.bot.entity.Auth;
import ru.fd.api.bot.entity.Request;
import ru.fd.api.bot.producer.print.PrinterProducer;
import ru.fd.api.bot.time.DateFormatter;

import java.util.Map;

public interface RequestProducer {
    Request<Map<String, Object>> getGetRequestDefaultInstance(String method, String url, Auth<String> auth, RequestResultProducer requestResultProducer);
    Request<Map<String, Object>> getBenchmarkRequestInstance(Request<Map<String, Object>> request);
    Request<Map<String, Object>> getPrintableRequestInstance(
            Request<Map<String, Object>> request,
            PrinterProducer printerProducer,
            DateFormatter dateFormatter,
            String fullFilename);
}
