package ru.fd.api.bot.producer.creator;

import ru.fd.api.bot.creator.SettingsCreator;
import ru.fd.api.bot.file.SettingsFile;
import ru.fd.api.bot.producer.entity.SettingsProducer;
import ru.fd.api.bot.service.CreatorService;
import ru.fd.api.bot.time.DateFormatter;

public interface SettingsCreatorProducer {
    SettingsCreator getSettingsCreatorFromFileJsonInstance(
            CreatorService creatorService,
            SettingsProducer settingsProducer,
            SettingsFile<String> settingsFile,
            DateFormatter dateFormatter);
}
