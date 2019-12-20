package ru.fd.api.bot.print;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

@Component("printerToFile")
@Scope("prototype")
public class PrinterToFileImpl implements Printer<File> {

    private final Printer<String> printer;
    private final String fullFilename;

    public PrinterToFileImpl(Printer<String> printer, String fullFilename) {
        this.printer = printer;
        this.fullFilename = fullFilename;
    }

    @Override
    public File print() {
        try {
            String result = printer.print();

            File file = new File(fullFilename);
            if(file.createNewFile())
                System.out.println("File " + fullFilename + " is created!");

            try (BufferedWriter bw = new BufferedWriter(new FileWriter(file, true))) {
                bw.write("TEST BEGIN");
                bw.newLine();
                bw.write(result);
                bw.write("TEST END");
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }

            return file;
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }
}
