package ru.fd.api.bot.print;

import org.springframework.stereotype.Component;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

@Component("printerToFile")
public class PrinterToFileImpl implements Printer<String> {

    private String fullFilename;

    @Override
    public void print(String data) {
        try {
            File file = new File(fullFilename);
            if(file.createNewFile())
                System.out.println("File " + fullFilename + " is created!");

            try (BufferedWriter bw = new BufferedWriter(new FileWriter(file, true))) {
                bw.write("TEST BEGIN");
                bw.newLine();
                bw.write(data);
                bw.write("TEST END");
                bw.newLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }

    public void print(String fullFilename, String data) {
        this.fullFilename = fullFilename;
        print(data);
    }
}
