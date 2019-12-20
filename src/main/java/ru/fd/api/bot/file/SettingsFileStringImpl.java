package ru.fd.api.bot.file;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

@Component("settingsFileString")
@Scope("prototype")
public class SettingsFileStringImpl implements SettingsFile<String> {

    private final String fullFilename;

    public SettingsFileStringImpl(String fullFilename) {
        this.fullFilename = fullFilename;
    }

    @Override
    public String content() {
        File settingsFile = new File(fullFilename);
        try(BufferedReader br = new BufferedReader(new FileReader(settingsFile))) {
            StringBuilder jsonB = new StringBuilder();
            br.lines().forEach(jsonB::append);

            return jsonB.toString();
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }
}
