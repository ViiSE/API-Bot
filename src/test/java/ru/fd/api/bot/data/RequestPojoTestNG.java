package ru.fd.api.bot.data;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class RequestPojoTestNG {

    private AuthPojo authPojo;

    @BeforeClass
    @Parameters({"type", "token"})
    private void setUpClass(String type, String token) {
        authPojo = new AuthPojo(type, token);
    }

    @Test
    @Parameters({"method", "url"})
    public void serialize(String method, String url) throws JsonProcessingException {
        RequestPojo reqPojo = new RequestPojo(method, url, authPojo);

        System.out.println(
                new ObjectMapper()
                        .writerWithDefaultPrettyPrinter()
                        .writeValueAsString(reqPojo));
    }

    @Test
    @Parameters({"jsonReq"})
    public void deserialize(String json) throws JsonProcessingException {
        RequestPojo reqPojo = new ObjectMapper().readValue(json, RequestPojo.class);

        System.out.println("method: " + reqPojo.getMethod());
        System.out.println("url: " + reqPojo.getUrl());
        System.out.println("auth: " + reqPojo.getAuth());
    }

    @Test
    @Parameters({"jsonReqWithoutAuth"})
    public void deserialize_without_auth(String json) throws JsonProcessingException {
        RequestPojo reqPojo = new ObjectMapper().readValue(json, RequestPojo.class);

        System.out.println("method: " + reqPojo.getMethod());
        System.out.println("url: " + reqPojo.getUrl());
        System.out.println("auth: " + reqPojo.getAuth());
    }
}
