package ru.fd.api.bot.producer.entity;

import ru.fd.api.bot.entity.Auth;

public interface AuthProducer {
    Auth<String> getAuthStringTokenInstance(String type, String token);
    Auth<String> getAuthStringNoneInstance();
}
