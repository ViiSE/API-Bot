package ru.fd.api.bot.producer.entity;

import ru.fd.api.bot.data.RequestBodyPojo;
import ru.fd.api.bot.entity.Auth;
import ru.fd.api.bot.entity.Request;
import ru.fd.api.bot.entity.RequestBody;

public interface RequestProducer {
    Request getGetRequestInstance(String url, Auth<String> auth, ResponseProducer responseProducer);
    Request getPostRequestInstance(String url, Auth<String> auth, RequestBody<RequestBodyPojo> requestBody, ResponseProducer responseProducer);
    Request getPutRequestInstance(String url, Auth<String> auth, RequestBody<RequestBodyPojo> requestBody, ResponseProducer responseProducer);
    Request getDeleteRequestInstance(String url, Auth<String> auth, RequestBody<RequestBodyPojo> requestBody, ResponseProducer responseProducer);
    Request getEmptyRequestInstance();
    Request getRequestWithBenchInstance(Request request, ResponseProducer responseProducer);
}
