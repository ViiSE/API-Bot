package ru.fd.api.bot.print;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import ru.fd.api.bot.util.TestUtils;

import java.io.File;
import java.util.List;

import static org.testng.Assert.*;

public class PrinterToFileTestNG {

    private Printer<File> printer;

    @BeforeClass
    @Parameters({"message", "filename"})
    public void setUp(String message, String testFilename) {
        printer = new PrinterToFileImpl(
                new PrinterStringImpl(message),
                TestUtils.getTestResourcesFile(testFilename));
    }

    @Test
    public void print() {
        File file = printer.print();
        List<String> content = TestUtils.readResourcesFile(file);
        System.out.println("File content: ");
        for(String line: content) {
            System.out.println(line);
        }
    }

    @AfterClass
    @Parameters({"filename"})
    public void teardownClass(String testFilename) {
        if(TestUtils.deleteTestResourcesFile(testFilename))
            System.out.println(String.format("File '%s' is deleted", TestUtils.getTestResourcesFile(testFilename)));
        else
            System.out.println(String.format("Cannot deleted '%s' file", TestUtils.getTestResourcesFile(testFilename)));
    }
}
