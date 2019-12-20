package ru.fd.api.bot.producer;

import ru.fd.api.bot.BotExecutor;
import ru.fd.api.bot.entity.Settings;

public interface BotExecutorProducer {
    BotExecutor getBotExecutorDefaultInstance(Settings settings);
}
