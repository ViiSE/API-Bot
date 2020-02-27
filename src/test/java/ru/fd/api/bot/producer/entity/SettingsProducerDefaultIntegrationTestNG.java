package ru.fd.api.bot.producer.entity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Test;
import ru.fd.api.bot.configuration.APIBotConfiguration;
import ru.fd.api.bot.entity.Request;
import ru.fd.api.bot.entity.Settings;
import ru.fd.api.bot.entity.SettingsFromFileJsonImpl;
import ru.fd.api.bot.file.SettingsFileStringImpl;

import static org.testng.Assert.assertTrue;

@ContextConfiguration(classes = { APIBotConfiguration.class })
public class SettingsProducerDefaultIntegrationTestNG extends AbstractTestNGSpringContextTests {

    @Autowired
    private SettingsProducer producer;

    @Autowired
    private RequestProducer requestProducer;

    @Autowired
    private AuthProducer authProducer;

    @Autowired
    private ResponseProducer responseProducer;

    @Autowired
    private RequestBodyProducer requestBodyProducer;

    @Test
    public void getEmptyRequestInstance() {
        Settings<Request> settings = producer.getSettingsFromFileJsonInstance(
                requestProducer,
                authProducer,
                responseProducer,
                requestBodyProducer,
                new SettingsFileStringImpl("filename"));
        System.out.println("instance: " + settings);
        assertTrue(settings instanceof SettingsFromFileJsonImpl);
    }
}
