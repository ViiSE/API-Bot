package ru.fd.api.bot.producer.entity;

import ru.fd.api.bot.data.RequestBodyPojo;
import ru.fd.api.bot.entity.RequestBody;

import java.util.List;

public interface RequestBodyProducer {
    RequestBody<RequestBodyPojo> getRequestBodyWithListParamsInstance(List<RequestBodyPojo> params);
}
