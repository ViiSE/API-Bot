package ru.fd.api.bot.producer.creator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;
import ru.fd.api.bot.creator.SettingsCreator;
import ru.fd.api.bot.file.SettingsFile;
import ru.fd.api.bot.producer.entity.SettingsProducer;
import ru.fd.api.bot.service.CreatorService;
import ru.fd.api.bot.time.DateFormatter;

@Service("settingsCreatorProducerDefault")
public class SettingsCreatorProducerDefaultImpl implements SettingsCreatorProducer {

    @Autowired
    private ApplicationContext ctx;

    @Override
    public SettingsCreator getSettingsCreatorFromFileJsonInstance(
            CreatorService creatorService,
            SettingsProducer settingsProducer,
            SettingsFile<String> settingsFile,
            DateFormatter dateFormatter) {
        return (SettingsCreator) ctx.getBean(
                "settingsCreatorFromFileJson",
                creatorService,
                settingsProducer,
                settingsFile,
                dateFormatter);
    }
}
