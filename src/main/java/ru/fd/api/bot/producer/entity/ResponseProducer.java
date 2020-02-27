package ru.fd.api.bot.producer.entity;

import ru.fd.api.bot.entity.Response;

public interface ResponseProducer {
    Response getGetResponseWithUrlInstance(String url);
    Response getPostResponseWithUrlInstance(String url);
    Response getPutResponseWithUrlInstance(String url);
    Response getDeleteResponseWithUrlInstance(String url);
    Response getResponseWithBenchTimeInstance(Response response, long evaluateTime);
    Response getEmptyResponseInstance();
}
