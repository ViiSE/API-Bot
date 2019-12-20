package ru.fd.api.bot.data;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class AuthPojoTestNG {

    @Test
    @Parameters({"type", "token"})
    public void serialize(String type, String token) throws JsonProcessingException {
        AuthPojo authPojo = new AuthPojo(type, token);

        System.out.println(
                new ObjectMapper()
                        .writerWithDefaultPrettyPrinter()
                        .writeValueAsString(authPojo));
    }

    @Test
    @Parameters({"jsonAuth"})
    public void deserialize(String json) throws JsonProcessingException {
        AuthPojo authPojo = new ObjectMapper().readValue(json, AuthPojo.class);

        System.out.println("type: " + authPojo.getType());
        System.out.println("token: " + authPojo.getToken());
    }

    @Test
    @Parameters({"jsonAuthWithoutToken"})
    public void deserialize_without_token(String json) throws JsonProcessingException {
        AuthPojo authPojo = new ObjectMapper().readValue(json, AuthPojo.class);

        System.out.println("type: " + authPojo.getType());
        System.out.println("token: " + authPojo.getToken());
    }
}
