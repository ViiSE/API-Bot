package ru.fd.api.bot.print;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import ru.fd.api.bot.constant.Methods;
import ru.fd.api.bot.constant.RequestResults;
import ru.fd.api.bot.entity.RequestResult;
import ru.fd.api.bot.entity.RequestResultMapDefaultImpl;
import test.print.PrinterTestImpl;
import test.print.TestResponse;
import ru.fd.api.bot.time.DateFormatter;
import ru.fd.api.bot.time.DateFormatterDefaultImpl;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import static org.testng.Assert.*;

public class PrinterDefaultTestNG {

    @Test
    @Parameters({"method", "url"})
    public void print(String method, String url) {
        Date todayNow = new Date();
        RequestResult<Map<String, Object>> requestResult = new RequestResultMapDefaultImpl(
                new HashMap<>() {{
                    put(RequestResults.TIME, todayNow);
                    put(RequestResults.RESPONSE, new TestResponse(method, url));
                }});
        DateFormatter dateFormatter = new DateFormatterDefaultImpl();
        Printer<String> printer = new PrinterTestImpl(requestResult, dateFormatter);
        String message = printer.print();
        System.out.println("Message: ");
        System.out.println(message);
        assertNotNull(message, "Message is null!");
        assertFalse(message.isEmpty(), "Message is empty!");
        assertEquals(message, method + "\n\t" + url + " - "  + dateFormatter.format(todayNow) + "\n");
    }
}
