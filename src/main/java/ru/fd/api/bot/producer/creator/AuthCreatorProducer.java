package ru.fd.api.bot.producer.creator;

import ru.fd.api.bot.creator.AuthCreator;
import ru.fd.api.bot.data.AuthPojo;
import ru.fd.api.bot.producer.entity.AuthProducer;

public interface AuthCreatorProducer {
    AuthCreator getAuthCreatorDefaultInstance(AuthPojo auth, AuthProducer authProducer);
}
