package ru.fd.api.bot.producer.entity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;
import ru.fd.api.bot.entity.Auth;
import ru.fd.api.bot.entity.AuthStringTokenImpl;

@Service("authProducerDefault")
public class AuthProducerDefaultImpl implements AuthProducer {

    @Autowired
    private ApplicationContext ctx;

    @Override
    public Auth<String> getAuthStringTokenInstance(String type, String token) {
        return (AuthStringTokenImpl) ctx.getBean("authStringToken", type, token);
    }
}
