package ru.fd.api.bot.entity;

import org.testng.annotations.Test;
import ru.fd.api.bot.constant.Auths;

import static org.testng.Assert.assertEquals;

public class AuthStringNoneTestNG {

    @Test
    public void body() {
        Auth<String> auth = new AuthStringNoneImpl();
        String body = auth.body();
        System.out.println("Body: '" + body + "'");
        assertEquals(body, Auths.NONE);
    }
}
