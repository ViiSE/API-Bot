package ru.fd.api.bot.producer.entity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Test;
import ru.fd.api.bot.configuration.APIBotConfiguration;
import ru.fd.api.bot.entity.*;

import static org.testng.Assert.assertTrue;

@ContextConfiguration(classes = { APIBotConfiguration.class })
public class ResponseProducerDefaultIntegrationTestNG extends AbstractTestNGSpringContextTests {

    @Autowired
    private ResponseProducer producer;

    @Test
    public void getEmptyResponseInstance() {
        Response response = producer.getEmptyResponseInstance();
        System.out.println("instance: " + response);
        assertTrue(response instanceof EmptyResponseImpl);
    }

    @Test
    public void getGetResponseInstance() {
        Response response = producer.getGetResponseWithUrlInstance("url");
        System.out.println("instance: " + response);
        assertTrue(response instanceof GetResponseWithUrlImpl);
    }

    @Test
    public void getPostResponseInstance() {
        Response response = producer.getPostResponseWithUrlInstance("url");
        System.out.println("instance: " + response);
        assertTrue(response instanceof PostResponseWithUrlImpl);
    }

    @Test
    public void getPutResponseInstance() {
        Response response = producer.getPutResponseWithUrlInstance("url");
        System.out.println("instance: " + response);
        assertTrue(response instanceof PutResponseWithUrlImpl);
    }

    @Test
    public void getDeleteResponseInstance() {
        Response response = producer.getDeleteResponseWithUrlInstance("url");
        System.out.println("instance: " + response);
        assertTrue(response instanceof DeleteResponseWithUrlImpl);
    }
}
