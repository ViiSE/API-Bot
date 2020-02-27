package ru.fd.api.bot.producer.entity;

import ru.fd.api.bot.data.RequestBodyPojo;
import ru.fd.api.bot.entity.RequestBody;
import ru.fd.api.bot.entity.RequestBodyWithListParamsImpl;

import java.util.List;

public class RequestBodyProducerTestImpl implements RequestBodyProducer {

    @Override
    public RequestBody<RequestBodyPojo> getRequestBodyWithListParamsInstance(List<RequestBodyPojo> params) {
        return new RequestBodyWithListParamsImpl(params);
    }
}
