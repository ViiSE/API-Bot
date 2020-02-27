package ru.fd.api.bot.producer.entity;

import ru.fd.api.bot.entity.Request;
import ru.fd.api.bot.entity.Settings;
import ru.fd.api.bot.file.SettingsFile;

public interface SettingsProducer {
    Settings<Request> getSettingsFromFileJsonInstance(
            RequestProducer requestProducer,
            AuthProducer authProducer,
            ResponseProducer responseProducer,
            RequestBodyProducer requestBodyProducer,
            SettingsFile<String> settingsFile);
}
