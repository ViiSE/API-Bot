package ru.fd.api.bot.producer;

import ru.fd.api.bot.BannerPath;
import ru.fd.api.bot.Greetings;

public interface GreetingsProducer {
    Greetings getGreetingsWithBannerInstance(BannerPath bannerPath);
    Greetings getGreetingsWithTimeoutInstance(Greetings greetings);
}
