package ru.fd.api.bot.service;

import ru.fd.api.bot.producer.creator.AuthCreatorProducer;
import ru.fd.api.bot.producer.creator.RequestCreatorProducer;
import ru.fd.api.bot.producer.creator.RequestsCreatorProducer;
import ru.fd.api.bot.producer.creator.SettingsCreatorProducer;

public interface CreatorProducerService {
    RequestCreatorProducer requestCreatorProducer();
    RequestsCreatorProducer requestsCreatorProducer();
    AuthCreatorProducer authCreatorProducer();
    SettingsCreatorProducer settingsCreatorProducer();
}
