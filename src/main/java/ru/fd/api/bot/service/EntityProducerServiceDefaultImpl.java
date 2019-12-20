package ru.fd.api.bot.service;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import ru.fd.api.bot.producer.entity.*;

@Service("entityProducerServiceDefault")
@Scope("prototype")
public class EntityProducerServiceDefaultImpl implements EntityProducerService {

    private final RequestProducer requestProducer;
    private final RequestsProducer requestsProducer;
    private final RequestResultProducer requestResultProducer;
    private final SettingsProducer settingsProducer;
    private final AuthProducer authProducer;

    public EntityProducerServiceDefaultImpl(
            RequestProducer requestProducer,
            RequestsProducer requestsProducer,
            RequestResultProducer requestResultProducer,
            SettingsProducer settingsProducer,
            AuthProducer authProducer) {
        this.requestProducer = requestProducer;
        this.requestsProducer = requestsProducer;
        this.requestResultProducer = requestResultProducer;
        this.settingsProducer = settingsProducer;
        this.authProducer = authProducer;
    }

    @Override
    public RequestProducer requestProducer() {
        return requestProducer;
    }

    @Override
    public RequestsProducer requestsProducer() {
        return requestsProducer;
    }

    @Override
    public RequestResultProducer requestResultProducer() {
        return requestResultProducer;
    }

    @Override
    public SettingsProducer settingsProducer() {
        return settingsProducer;
    }

    @Override
    public AuthProducer authProducer() {
        return authProducer;
    }
}
