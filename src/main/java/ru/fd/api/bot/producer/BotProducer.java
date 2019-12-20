package ru.fd.api.bot.producer;

import ru.fd.api.bot.Bot;
import ru.fd.api.bot.entity.Settings;
import ru.fd.api.bot.producer.print.PrinterProducer;
import ru.fd.api.bot.time.DateFormatter;

public interface BotProducer {
    Bot getBotDefaultInstance(Settings settings, PrinterProducer printerProducer, DateFormatter dateFormatter);
}
