package ru.fd.api.bot;

import org.testng.annotations.Test;
import test.BannerPathFromTestResources;

public class GreetingsWithTimeoutTestNG {

    @Test
    public void hello() {
        BannerPath bannerPath = new BannerPathFromTestResources();
        Greetings greetingsBanner = new GreetingsWithBannerImpl(bannerPath);
        Greetings greetingsTimeout = new GreetingsWithTimeoutImpl(greetingsBanner);
        greetingsTimeout.hello();
    }
}
