package ru.fd.api.bot.print;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class PrinterStringTestNG {

    @Test
    @Parameters({"message"})
    public void print(String message) {
        Printer<String> printer = new PrinterStringImpl(message);
        String resMessage = printer.print();
        System.out.println("Message: " + resMessage);
        assertNotNull(resMessage, "Message is null!");
        assertFalse(resMessage.isEmpty(), "Message is empty!");
        assertEquals(resMessage, message);
    }
}
