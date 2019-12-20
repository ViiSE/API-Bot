package ru.fd.api.bot.producer.entity;

import ru.fd.api.bot.entity.Request;
import ru.fd.api.bot.entity.Requests;

import java.util.List;

public interface RequestsProducer {
    Requests getRequestsDefaultInstance(List<Request> requests);
}
