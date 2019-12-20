package ru.fd.api.bot.file;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import ru.fd.api.bot.util.TestUtils;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertNotNull;

public class SettingsFileStringTestNG {

    @Test
    @Parameters({"filename"})
    public void content(String filename) {
        SettingsFile<String> settingsFile = new SettingsFileStringImpl(TestUtils.getTestResourcesFile(filename));
        String content = settingsFile.content();
        System.out.println("Content: " + content);
        assertNotNull(content, "Content is null!");
        assertFalse(content.isEmpty(), "Content is empty");
    }
}
