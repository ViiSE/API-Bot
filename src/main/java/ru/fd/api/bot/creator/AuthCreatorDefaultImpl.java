package ru.fd.api.bot.creator;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import ru.fd.api.bot.data.AuthPojo;
import ru.fd.api.bot.entity.Auth;
import ru.fd.api.bot.producer.entity.AuthProducer;

@Service("authCreatorDefault")
@Scope("prototype")
public class AuthCreatorDefaultImpl implements AuthCreator {

    private final AuthPojo auth;
    private final AuthProducer authProducer;

    public AuthCreatorDefaultImpl(AuthPojo auth, AuthProducer authProducer) {
        this.auth = auth;
        this.authProducer = authProducer;
    }

    @Override
    public Auth<String> create() {
        return authProducer.getAuthStringTokenInstance(auth.getType(), auth.getToken());
    }
}
