package ru.fd.api.bot.service;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import ru.fd.api.bot.producer.creator.AuthCreatorProducer;
import ru.fd.api.bot.producer.creator.RequestCreatorProducer;
import ru.fd.api.bot.producer.creator.RequestsCreatorProducer;
import ru.fd.api.bot.producer.creator.SettingsCreatorProducer;

@Service("creatorProducerServiceDefault")
@Scope("prototype")
public class CreatorProducerServiceDefaultImpl implements CreatorProducerService {

    private final RequestCreatorProducer requestCreatorProducer;
    private final RequestsCreatorProducer requestsCreatorProducer;
    private final AuthCreatorProducer authCreatorProducer;
    private final SettingsCreatorProducer settingsCreatorProducer;

    public CreatorProducerServiceDefaultImpl(
            RequestCreatorProducer requestCreatorProducer,
            RequestsCreatorProducer requestsCreatorProducer,
            AuthCreatorProducer authCreatorProducer,
            SettingsCreatorProducer settingsCreatorProducer) {
        this.requestCreatorProducer = requestCreatorProducer;
        this.requestsCreatorProducer = requestsCreatorProducer;
        this.authCreatorProducer = authCreatorProducer;
        this.settingsCreatorProducer = settingsCreatorProducer;
    }

    @Override
    public RequestCreatorProducer requestCreatorProducer() {
        return requestCreatorProducer;
    }

    @Override
    public RequestsCreatorProducer requestsCreatorProducer() {
        return requestsCreatorProducer;
    }

    @Override
    public AuthCreatorProducer authCreatorProducer() {
        return authCreatorProducer;
    }

    @Override
    public SettingsCreatorProducer settingsCreatorProducer() {
        return settingsCreatorProducer;
    }
}
