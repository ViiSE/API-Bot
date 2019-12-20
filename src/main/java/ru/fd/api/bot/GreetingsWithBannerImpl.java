package ru.fd.api.bot;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

@Component("greetingsWithBanner")
public class GreetingsWithBannerImpl implements Greetings {

    private final BannerPath bannerPath;

    public GreetingsWithBannerImpl(BannerPath bannerPath) {
        this.bannerPath = bannerPath;
    }

    @Override
    public void hello() {
        Resource resource = new ClassPathResource(bannerPath.path());

        try(BufferedReader br = new BufferedReader(new InputStreamReader(resource.getInputStream()))) {
            br.lines().forEach(System.out::println);
        } catch(IOException ex) {
            System.out.println(ex.getMessage() + ": " + ex.getCause());
        }
    }
}
