package ru.fd.api.bot.entity;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import ru.fd.api.bot.constant.Methods;
import ru.fd.api.bot.time.DateFormatterDefaultImpl;

import static org.testng.Assert.assertEquals;

public class ResponseFormatPrettyTestNG {

    private ResponseFormat<String> format;

    @BeforeClass
    public void setUpClass() {
        format = new ResponseFormatPrettyImpl(new DateFormatterDefaultImpl());
    }

    @Test
    @Parameters({"url"})
    public void format(String url) {
        long start = System.currentTimeMillis();
        long stop = System.currentTimeMillis() + 100000L;
        String formattedString = format.format(new ResponseWithBenchTimeImpl(
                new GetResponseWithUrlImpl(url),
                (stop - start)));

        System.out.println("Formatted string: ");
        System.out.println(formattedString);
    }
}
