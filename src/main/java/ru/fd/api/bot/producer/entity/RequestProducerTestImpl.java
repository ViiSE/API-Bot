package ru.fd.api.bot.producer.entity;

import ru.fd.api.bot.data.RequestBodyPojo;
import ru.fd.api.bot.entity.*;

public class RequestProducerTestImpl implements RequestProducer {

    @Override
    public Request getGetRequestInstance(String url, Auth<String> auth, ResponseProducer responseProducer) {
        return new GetRequestImpl(url, auth, responseProducer);
    }

    @Override
    public Request getPostRequestInstance(String url, Auth<String> auth, RequestBody<RequestBodyPojo> requestBody, ResponseProducer responseProducer) {
        return new PostRequestImpl(url, auth, requestBody, responseProducer);
    }

    @Override
    public Request getPutRequestInstance(String url, Auth<String> auth, RequestBody<RequestBodyPojo> requestBody, ResponseProducer responseProducer) {
        return new PutRequestImpl(url, auth, requestBody, responseProducer);
    }

    @Override
    public Request getDeleteRequestInstance(String url, Auth<String> auth, RequestBody<RequestBodyPojo> requestBody, ResponseProducer responseProducer) {
        return new DeleteRequestImpl(url, auth, requestBody, responseProducer);
    }

    @Override
    public Request getEmptyRequestInstance() {
        return new EmptyRequestImpl(new ResponseProducerTestImpl());
    }

    @Override
    public Request getRequestWithBenchInstance(Request request, ResponseProducer responseProducer) {
        return new RequestWithBenchImpl(request, responseProducer);
    }
}
