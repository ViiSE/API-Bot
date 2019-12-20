package ru.fd.api.bot.producer.entity;

import ru.fd.api.bot.entity.RequestResult;

import java.util.Map;

public interface RequestResultProducer {
    RequestResult<Map<String, Object>> getRequestResultMapDefaultInstance(Map<String, Object> dataMap);
}
