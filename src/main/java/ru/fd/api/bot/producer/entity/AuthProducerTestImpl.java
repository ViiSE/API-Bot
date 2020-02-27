package ru.fd.api.bot.producer.entity;

import ru.fd.api.bot.entity.Auth;
import ru.fd.api.bot.entity.AuthStringNoneImpl;
import ru.fd.api.bot.entity.AuthStringTokenImpl;

public class AuthProducerTestImpl implements AuthProducer {

    @Override
    public Auth<String> getAuthStringTokenInstance(String type, String token) {
        return new AuthStringTokenImpl(type, token);
    }

    @Override
    public Auth<String> getAuthStringNoneInstance() {
        return new AuthStringNoneImpl();
    }
}
