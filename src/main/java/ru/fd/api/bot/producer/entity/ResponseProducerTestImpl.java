package ru.fd.api.bot.producer.entity;

import ru.fd.api.bot.entity.*;

public class ResponseProducerTestImpl implements ResponseProducer {

    @Override
    public Response getGetResponseWithUrlInstance(String url) {
        return new GetResponseWithUrlImpl(url);
    }

    @Override
    public Response getPostResponseWithUrlInstance(String url) {
        return new PostResponseWithUrlImpl(url);
    }

    @Override
    public Response getPutResponseWithUrlInstance(String url) {
        return new PutResponseWithUrlImpl(url);
    }

    @Override
    public Response getDeleteResponseWithUrlInstance(String url) {
        return new DeleteResponseWithUrlImpl(url);
    }

    @Override
    public Response getResponseWithBenchTimeInstance(Response response, long evaluateTime) {
        return new ResponseWithBenchTimeImpl(response, evaluateTime);
    }

    @Override
    public Response getEmptyResponseInstance() {
        return new EmptyResponseImpl();
    }
}
