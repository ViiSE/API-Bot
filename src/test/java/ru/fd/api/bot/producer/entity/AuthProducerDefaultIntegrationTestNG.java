package ru.fd.api.bot.producer.entity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import ru.fd.api.bot.configuration.APIBotConfiguration;
import ru.fd.api.bot.entity.Auth;
import ru.fd.api.bot.entity.AuthStringNoneImpl;
import ru.fd.api.bot.entity.AuthStringTokenImpl;

import static org.testng.Assert.assertTrue;


@ContextConfiguration(classes = { APIBotConfiguration.class })
public class AuthProducerDefaultIntegrationTestNG extends AbstractTestNGSpringContextTests {

    @Autowired
    private AuthProducer authProducer;

    @Test
    @Parameters({"type", "token"})
    public void getAuthStringTokenInstance(String type, String token) {
        Auth<String> auth = authProducer.getAuthStringTokenInstance(type, token);
        System.out.println("instance: " + auth);
        assertTrue(auth instanceof AuthStringTokenImpl);
    }

    @Test
    public void getAuthStringNoneInstance() {
        Auth<String> auth = authProducer.getAuthStringNoneInstance();
        System.out.println("instance: " + auth);
        assertTrue(auth instanceof AuthStringNoneImpl);
    }
}
