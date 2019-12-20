package ru.fd.api.bot.time;

import org.testng.annotations.Test;

import java.util.Date;

import static org.testng.Assert.*;

public class DateFormatterDefaultTestNG {

    private static final String regex = "^(0?[0-9]|[0-5][0-9])m (0?[0-9]|[0-5][0-9])s (00?[0-9]|0?[0-9][0-9]|[0-9][0-9][0-9])ms$";

    @Test
    public void format() {
        Date date = new Date();

        DateFormatter dateFormatter = new DateFormatterDefaultImpl();
        String formattedDate = dateFormatter.format(date);
        System.out.println("Formatted: " + formattedDate);
        assertNotNull(formattedDate, "Formatted date is null!");
        assertFalse(formattedDate.isEmpty(), "Formatted date is null!");
        assertTrue(formattedDate.matches(regex));
    }
}
