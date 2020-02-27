package ru.fd.api.bot.entity;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import ru.fd.api.bot.constant.Methods;

import static org.testng.Assert.assertEquals;

public class PutResponseWithUrlTestNG {

    private Response response;

    @BeforeClass
    @Parameters({"url"})
    public void setUpClass(String url) {
        response = new PutResponseWithUrlImpl(url);
    }

    @Test
    public void method() {
        System.out.println("Method: " + response.method());
        assertEquals(response.method(), Methods.PUT);
    }

    @Test
    @Parameters({"url"})
    public void url(String url) {
        System.out.println("url: " + response.url());
        assertEquals(response.url(), url);
    }

    @Test
    public void evaluateTime() {
        System.out.println("evaluateTime: " + response.evaluateTime());
        assertEquals(response.evaluateTime(), 0);
    }
}
