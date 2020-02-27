package ru.fd.api.bot.entity;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import ru.fd.api.bot.constant.Methods;

import static org.testng.Assert.assertEquals;

public class EmptyResponseWithUrlTestNG {

    private Response response;

    @BeforeClass
    public void setUpClass() {
        response = new EmptyResponseImpl();
    }

    @Test
    public void method() {
        System.out.println("Method: " + response.method());
        assertEquals(response.method(), Methods.NONE);
    }

    @Test
    public void url() {
        System.out.println("url: " + response.url());
        assertEquals(response.url(), "empty");
    }

    @Test
    public void evaluateTime() {
        System.out.println("evaluateTime: " + response.evaluateTime());
        assertEquals(response.evaluateTime(), 0);
    }
}
