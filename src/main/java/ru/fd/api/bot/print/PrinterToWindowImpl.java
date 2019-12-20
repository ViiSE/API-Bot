package ru.fd.api.bot.print;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("printerToWindow")
@Scope("prototype")
public class PrinterToWindowImpl implements Printer<Void> {

    private final Printer<String> printer;

    public PrinterToWindowImpl(Printer<String> printer) {
        this.printer = printer;
    }

    @Override
    public Void print() {
        String result = printer.print();
        System.out.println(result);

        return null;
    }
}
