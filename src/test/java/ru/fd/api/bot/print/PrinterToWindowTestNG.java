package ru.fd.api.bot.print;

import org.testng.annotations.Test;

public class PrinterToWindowTestNG {

    @Test
    public void print() {
        Printer<String> printer = new PrinterToWindowImpl();
        printer.print("print");
    }
}
