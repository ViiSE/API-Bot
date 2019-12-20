package ru.fd.api.bot;

import org.testng.annotations.Test;
import test.BannerPathFromTestResources;

public class GreetingsWithBannerTestNG {

    @Test
    public void hello() {
        BannerPath bannerPath = new BannerPathFromTestResources();
        Greetings greetings = new GreetingsWithBannerImpl(bannerPath);
        greetings.hello();
    }
}
