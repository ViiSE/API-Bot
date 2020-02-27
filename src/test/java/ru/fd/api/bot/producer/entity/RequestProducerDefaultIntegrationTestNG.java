package ru.fd.api.bot.producer.entity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Test;
import ru.fd.api.bot.configuration.APIBotConfiguration;
import ru.fd.api.bot.entity.*;

import static org.testng.Assert.assertTrue;

@ContextConfiguration(classes = { APIBotConfiguration.class })
public class RequestProducerDefaultIntegrationTestNG extends AbstractTestNGSpringContextTests {

    @Autowired
    private RequestProducer producer;

    @Autowired
    private ResponseProducer responseProducer;

    @Test
    public void getEmptyRequestInstance() {
        Request request = producer.getEmptyRequestInstance();
        System.out.println("instance: " + request);
        assertTrue(request instanceof EmptyRequestImpl);
    }

    @Test
    public void getGetRequestInstance() {
        Request request = producer.getGetRequestInstance("url", new AuthStringNoneImpl(), responseProducer);
        System.out.println("instance: " + request);
        assertTrue(request instanceof GetRequestImpl);
    }

    @Test
    public void getPostRequestInstance() {
        Request request = producer.getPostRequestInstance("url", new AuthStringNoneImpl(), null, responseProducer);
        System.out.println("instance: " + request);
        assertTrue(request instanceof PostRequestImpl);
    }

    @Test
    public void getPutRequestInstance() {
        Request request = producer.getPutRequestInstance("url", new AuthStringNoneImpl(), null, responseProducer);
        System.out.println("instance: " + request);
        assertTrue(request instanceof PutRequestImpl);
    }

    @Test
    public void getDeleteRequestInstance() {
        Request request = producer.getDeleteRequestInstance("url", new AuthStringNoneImpl(), null, responseProducer);
        System.out.println("instance: " + request);
        assertTrue(request instanceof DeleteRequestImpl);
    }
}
