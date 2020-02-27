package ru.fd.api.bot.print;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import ru.fd.api.bot.util.TestUtils;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import static org.testng.Assert.assertEquals;

public class PrinterToFileTestNG {

    private String filename;

    @BeforeClass
    public void setUpClass() {
        filename = TestUtils.getTestResourcesFile("test");
    }

    @Test
    public void print() throws IOException {
        PrinterToFileImpl printer = new PrinterToFileImpl();
        printer.print(filename, "hi\n");

        List<String> lines = Files.readAllLines(Paths.get(filename), StandardCharsets.UTF_8);
        lines.forEach(System.out::println);
        String begin = lines.get(0);
        String content = lines.get(1);
        String end = lines.get(2);

        assertEquals("TEST BEGIN", begin);
        assertEquals("hi", content);
        assertEquals("TEST END", end);
    }

    @AfterClass
    public void teardownClass() throws IOException {
        Files.delete(Paths.get(filename));
        System.out.println("File " + filename + " was deleted successfully!");
    }
}
