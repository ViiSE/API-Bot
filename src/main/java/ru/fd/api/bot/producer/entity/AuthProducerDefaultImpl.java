package ru.fd.api.bot.producer.entity;

import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;
import ru.fd.api.bot.entity.Auth;
import ru.fd.api.bot.entity.AuthStringNoneImpl;
import ru.fd.api.bot.entity.AuthStringTokenImpl;

@Service("authProducerDefault")
public class AuthProducerDefaultImpl implements AuthProducer {

    private final ApplicationContext ctx;

    public AuthProducerDefaultImpl(ApplicationContext ctx) {
        this.ctx = ctx;
    }

    @Override
    public Auth<String> getAuthStringTokenInstance(String type, String token) {
        return (AuthStringTokenImpl) ctx.getBean("authStringToken", type, token);
    }

    @Override
    public Auth<String> getAuthStringNoneInstance() {
        return ctx.getBean("authStringNone", AuthStringNoneImpl.class);
    }
}
