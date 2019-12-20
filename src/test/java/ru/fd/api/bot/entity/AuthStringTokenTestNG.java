package ru.fd.api.bot.entity;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertNotNull;

public class AuthStringTokenTestNG {

    @Test
    @Parameters({"type", "token"})
    public void body(String type, String token) {
        Auth<String> auth = new AuthStringTokenImpl(type, token);
        String body = auth.body();
        System.out.println("Body: " + body);
        assertNotNull(body, "Body is not null!");
        assertFalse(body.isEmpty(), "Body is empty!");
    }
}
