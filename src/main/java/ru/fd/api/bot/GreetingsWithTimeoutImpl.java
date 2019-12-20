package ru.fd.api.bot;

import org.springframework.stereotype.Component;

@Component("greetingsWithTimeout")
public class GreetingsWithTimeoutImpl implements Greetings {

    private final Greetings greetings;

    public GreetingsWithTimeoutImpl(Greetings greetings) {
        this.greetings = greetings;
    }

    @Override
    public void hello() {
        greetings.hello();
        try { Thread.sleep(2000); } catch (InterruptedException ignored) {}
        System.out.println("+---------------+");
        System.out.println("| ! S T A R T ! |");
        System.out.println("+---------------+");
        try { Thread.sleep(1000); } catch (InterruptedException ignored) {}
    }
}
