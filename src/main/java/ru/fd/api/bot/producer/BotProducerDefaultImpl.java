package ru.fd.api.bot.producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;
import ru.fd.api.bot.Bot;
import ru.fd.api.bot.entity.Settings;
import ru.fd.api.bot.producer.print.PrinterProducer;
import ru.fd.api.bot.time.DateFormatter;

@Service("botProducerDefault")
public class BotProducerDefaultImpl implements BotProducer {

    @Autowired
    private ApplicationContext ctx;

    @Override
    public Bot getBotDefaultInstance(Settings settings, PrinterProducer printerProducer, DateFormatter dateFormatter) {
        return (Bot) ctx.getBean("botDefault", settings, printerProducer, dateFormatter);
    }
}
