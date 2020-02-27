package ru.fd.api.bot.producer.entity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import ru.fd.api.bot.configuration.APIBotConfiguration;
import ru.fd.api.bot.data.RequestBodyPojo;
import ru.fd.api.bot.entity.RequestBody;
import ru.fd.api.bot.entity.RequestBodyWithListParamsImpl;

import java.util.ArrayList;

import static org.testng.Assert.assertTrue;

@ContextConfiguration(classes = { APIBotConfiguration.class })
public class RequestBodyProducerDefaultIntegrationTestNG extends AbstractTestNGSpringContextTests {

    @Autowired
    private RequestBodyProducer producer;

    @Test
    @Parameters({"type", "token"})
    public void getRequestBodyWithListParamsInstance() {
        RequestBody<RequestBodyPojo> reqBody = producer.getRequestBodyWithListParamsInstance(
                new ArrayList<>() {{ add(new RequestBodyPojo("name", "val")); }}
        );
        System.out.println("instance: " + reqBody);
        assertTrue(reqBody instanceof RequestBodyWithListParamsImpl);
    }
}
