package ru.fd.api.bot.print;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("printerString")
@Scope("prototype")
public class PrinterStringImpl implements Printer<String> {

    private final String message;

    public PrinterStringImpl(String message) {
        this.message = message;
    }

    @Override
    public String print() {
        return message;
    }
}
