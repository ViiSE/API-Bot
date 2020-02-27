package ru.fd.api.bot;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("greetingsWithTimeout")
public class GreetingsWithTimeoutImpl implements Greetings {

    private final Greetings greetings;

    public GreetingsWithTimeoutImpl(@Qualifier("greetingsWithBanner") Greetings greetings) {
        this.greetings = greetings;
    }

    @Override
    public void hello() {
        greetings.hello();
        try { Thread.sleep(2000); } catch (InterruptedException ignored) {}
        System.out.println("Get ready!");
        try { Thread.sleep(1000); } catch (InterruptedException ignored) {}
    }
}
