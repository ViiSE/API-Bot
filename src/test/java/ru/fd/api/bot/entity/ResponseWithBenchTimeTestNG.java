package ru.fd.api.bot.entity;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import ru.fd.api.bot.constant.Methods;

import static org.testng.Assert.assertEquals;

public class ResponseWithBenchTimeTestNG {

    private Response response;

    @BeforeClass
    @Parameters({"url", "evalTime"})
    public void setUpClass(String url, long evalTime) {
        response = new ResponseWithBenchTimeImpl(
                new GetResponseWithUrlImpl(url),
                evalTime);
    }

    @Test
    public void method() {
        System.out.println("Method: " + response.method());
        assertEquals(response.method(), Methods.GET);
    }

    @Test
    @Parameters({"url"})
    public void url(String url) {
        System.out.println("url: " + response.url());
        assertEquals(response.url(), url);
    }

    @Test
    @Parameters({"evalTime"})
    public void evaluateTime(long evalTime) {
        System.out.println("evaluateTime: " + response.evaluateTime());
        assertEquals(response.evaluateTime(), evalTime);
    }
}
