package ru.fd.api.bot.data;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.testng.annotations.DataProvider;
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

    @Test(dataProvider = "jsonDp")
    public void deserialize(String json, String cause) throws JsonProcessingException {
        System.out.println(cause);

        AuthPojo authPojo = new ObjectMapper().readValue(json, AuthPojo.class);

        System.out.println("type: " + authPojo.getType());
        System.out.println("token: " + authPojo.getToken());
    }

    @DataProvider(name = "jsonDp")
    public Object[][] createDP() {
        return new Object[][] {
                {
                        "{ " +
                            "\"type\": \"Bearer\", " +
                            "\"token\": \"'Token here'\"" +
                        "}",
                        "[with token]"
                },
                {
                        "{ " +
                            "\"type\": \"Bearer\"" +
                        "}",
                        "[without token]"
                }
        };
    }
}
