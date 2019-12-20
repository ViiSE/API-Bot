package ru.fd.api.bot.entity;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.ArrayList;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertNotNull;

public class SettingsDefaultTestNG {

    private Settings settings;

    @BeforeClass
    @Parameters({"filename", "repeat"})
    public void setUpClass(String fullFilename, int repeat) {
        Requests requests = new RequestsDefaultImpl(new ArrayList<>());
        settings = new SettingsDefaultImpl(requests, repeat, fullFilename);
    }

    @Test
    public void requests() {
        Requests requests = settings.requests();
        System.out.println("Requests: " + requests);
        assertNotNull(requests, "Requests is null!");
    }

    @Test
    public void repeat() {
        int repeat = settings.repeat();
        System.out.println("Repeat: " + repeat);
        assertFalse(repeat <= 0, "Repeat is less or equals than 0!");
    }

    @Test
    public void fullFilename() {
        String fullFilename = settings.fullFilename();
        System.out.println("fullFilename: " + fullFilename);
        assertNotNull(fullFilename, "Filename is null!");
        assertFalse(fullFilename.isEmpty(), "Filename is empty!");
    }
}
