package ru.fd.api.bot.producer.entity;

import ru.fd.api.bot.entity.Requests;
import ru.fd.api.bot.entity.Settings;

public interface SettingsProducer {
    Settings getSettingsDefaultInstance(Requests requests, int repeat, String fullFilename);
}
