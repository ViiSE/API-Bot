package ru.fd.api.bot.producer.entity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;
import ru.fd.api.bot.entity.Requests;
import ru.fd.api.bot.entity.Settings;

@Service("settingsProducerDefault")
public class SettingsProducerDefaultImpl implements SettingsProducer {

    @Autowired
    private ApplicationContext ctx;

    @Override
    public Settings getSettingsDefaultInstance(Requests requests, int repeat, String fullFilename) {
        return (Settings) ctx.getBean("settingsDefault", requests, repeat, fullFilename);
    }
}
