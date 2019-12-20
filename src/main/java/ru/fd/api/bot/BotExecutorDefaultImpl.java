package ru.fd.api.bot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import ru.fd.api.bot.entity.Settings;
import ru.fd.api.bot.producer.BotProducer;
import ru.fd.api.bot.producer.print.PrinterProducer;
import ru.fd.api.bot.time.DateFormatter;

@Component("botExecutorDefault")
@Scope("prototype")
public class BotExecutorDefaultImpl implements BotExecutor {

    @Autowired private BotProducer botProducer;
    @Autowired private PrinterProducer printerProducer;
    @Autowired private DateFormatter dateFormatter;

    private final Settings settings;

    public BotExecutorDefaultImpl(Settings settings) {
        this.settings = settings;
    }

    @Override
    public void startBot() {
        botProducer.getBotDefaultInstance(
                settings,
                printerProducer,
                dateFormatter).execute();
    }
}
