package ru.fd.api.bot.producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;
import ru.fd.api.bot.BotExecutor;
import ru.fd.api.bot.entity.Settings;

@Service("botExecutorProducerDefaultImpl")
public class BotExecutorProducerDefaultImpl implements BotExecutorProducer {

    @Autowired
    private ApplicationContext ctx;

    @Override
    public BotExecutor getBotExecutorDefaultInstance(Settings settings) {
        return (BotExecutor) ctx.getBean("botExecutorDefault", settings);
    }
}
