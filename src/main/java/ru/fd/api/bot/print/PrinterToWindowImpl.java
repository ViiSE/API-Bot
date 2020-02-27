package ru.fd.api.bot.print;

import org.springframework.stereotype.Component;

@Component("printerToWindow")
public class PrinterToWindowImpl implements Printer<String> {

    @Override
    public void print(String message) {
        System.out.println(message);
    }
}
