package ru.fd.api.bot.producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;
import ru.fd.api.bot.BannerPath;
import ru.fd.api.bot.Greetings;

@Service("greetingsProducerDefault")
public class GreetingsProducerDefaultImpl implements GreetingsProducer {

    @Autowired
    private ApplicationContext ctx;

    @Override
    public Greetings getGreetingsWithBannerInstance(BannerPath bannerPath) {
        return (Greetings) ctx.getBean("greetingsWithBanner", bannerPath);
    }

    @Override
    public Greetings getGreetingsWithTimeoutInstance(Greetings greetings) {
        return (Greetings) ctx.getBean("greetingsWithTimeout", greetings);
    }
}
