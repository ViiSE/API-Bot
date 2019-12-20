package ru.fd.api.bot.service;

import ru.fd.api.bot.producer.entity.*;

public interface EntityProducerService {
    RequestProducer requestProducer();
    RequestsProducer requestsProducer();
    RequestResultProducer requestResultProducer();
    SettingsProducer settingsProducer();
    AuthProducer authProducer();
}
