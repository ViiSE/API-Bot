package ru.fd.api.bot.producer.creator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;
import ru.fd.api.bot.creator.AuthCreator;
import ru.fd.api.bot.data.AuthPojo;
import ru.fd.api.bot.producer.entity.AuthProducer;

@Service("authCreatorProducerDefault")
public class AuthCreatorProducerDefaultImpl implements AuthCreatorProducer {

    @Autowired
    private ApplicationContext ctx;

    @Override
    public AuthCreator getAuthCreatorDefaultInstance(AuthPojo auth, AuthProducer authProducer) {
        return (AuthCreator) ctx.getBean("authCreatorDefault", auth, authProducer);
    }
}
