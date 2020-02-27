package ru.fd.api.bot.producer.entity;

import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;
import ru.fd.api.bot.entity.Request;
import ru.fd.api.bot.entity.Settings;
import ru.fd.api.bot.entity.SettingsFromFileJsonImpl;
import ru.fd.api.bot.file.SettingsFile;

@Service("settingsProducerDefault")
public class SettingsProducerDefaultImpl implements SettingsProducer {

    private final ApplicationContext ctx;

    public SettingsProducerDefaultImpl(ApplicationContext ctx) {
        this.ctx = ctx;
    }

    @Override
    public Settings<Request> getSettingsFromFileJsonInstance(
            RequestProducer requestProducer,
            AuthProducer authProducer,
            ResponseProducer responseProducer,
            RequestBodyProducer requestBodyProducer,
            SettingsFile<String> settingsFile) {
        return (SettingsFromFileJsonImpl) ctx.getBean(
                "settingsFromFileJson",
                requestProducer,
                authProducer,
                responseProducer,
                requestBodyProducer,
                settingsFile) ;
    }
}
