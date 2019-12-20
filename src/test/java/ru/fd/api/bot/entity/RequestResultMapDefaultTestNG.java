package ru.fd.api.bot.entity;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import ru.fd.api.bot.constant.Methods;
import ru.fd.api.bot.constant.RequestResults;
import test.print.TestResponse;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import static org.testng.Assert.assertNotNull;

public class RequestResultMapDefaultTestNG {

    private RequestResult<Map<String, Object>> requestResult;

    @BeforeClass
    @Parameters({"url", "method"})
    public void setUpClass(String url, String method) {
        requestResult = new RequestResultMapDefaultImpl(new HashMap<>() {{
            put(RequestResults.TIME, new Date());
            put(RequestResults.RESPONSE, new TestResponse(method, url)); }});
    }

    @Test
    public void data() {
        assertNotNull(requestResult.data(), "Data is null!");
    }

    @Test
    public void findObjectByKey() {
        Date date = (Date) requestResult.findObjectByKey(RequestResults.TIME);
        TestResponse response = (TestResponse) requestResult.findObjectByKey(RequestResults.RESPONSE);

        System.out.println("Date: " + date);
        System.out.println("Response: ");
        System.out.println("\tMethod:" + response.method());
        System.out.println("\tUrl:" + response.url());
        assertNotNull(date, "Date is null!");
        assertNotNull(response, "Response is null!");
    }
}
