package ru.fd.api.bot.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class TestUtils {

    public static String getTestResourcesPath() {
        return System.getProperty("user.dir") +
                File.separator + "src" +
                File.separator + "test" +
                File.separator + "resources" +
                File.separator;
    }

    public static String getTestResourcesFile(String filename) {
        return getTestResourcesPath() + filename;
    }

    public static String createTestResourcesFile(String filename) {
        try {
            File trf = new File(getTestResourcesFile(filename));
            if(trf.createNewFile())
                return trf.getAbsolutePath();
            else
                return null;
        } catch (IOException e) {
            return null;
        }
    }

    public static boolean deleteTestResourcesFile(String filename) {
        return new File(getTestResourcesFile(filename)).delete();
    }

    public static List<String> readResourcesFile(String filename) {
        List<String> content;
        try(BufferedReader br = new BufferedReader(new FileReader(getTestResourcesFile(filename)))) {
            content = br.lines().collect(Collectors.toList());
        } catch (IOException ex) {
            return new ArrayList<>();
        }
        return content;
    }

    public static List<String> readResourcesFile(File file) {
        return readResourcesFile(file.getName());
    }
}
