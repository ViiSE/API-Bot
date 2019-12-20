package ru.fd.api.bot.data;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertNotNull;

public class SettingsPojoTestNG {

    private AuthPojo authPojo;
    private RequestPojo reqPojo;

    @BeforeClass
    @Parameters({"type", "token", "method", "url"})
    private void setUpClass(String type, String token, String method, String url) {
        authPojo = new AuthPojo(type, token);
        reqPojo = new RequestPojo(method, url, authPojo);
    }

    @Test
    @Parameters({"filename", "hostname", "repeat"})
    public void serialize(String filename, String hostname, int repeat) throws JsonProcessingException {
        assertNotNull(filename, "Filename is null!");
        assertNotNull(hostname, "Hostname is null!");

        assertFalse(filename.isEmpty(), "Filename is empty!");
        assertFalse(hostname.isEmpty(), "Hostname is empty!");
        assertFalse(repeat <= 0, "repeat is less or equals 0!");

        SettingsPojo setPojo = new SettingsPojo(filename, hostname, repeat, authPojo, Collections.singletonList(reqPojo));

        System.out.println(
                new ObjectMapper()
                        .writerWithDefaultPrettyPrinter()
                        .writeValueAsString(setPojo));
    }

    @Test
    @Parameters({"jsonSet"})
    public void deserialize(String json) throws JsonProcessingException {
        SettingsPojo setPojo = new ObjectMapper().readValue(json, SettingsPojo.class);

        assertNotNull(setPojo.getFilename(), "Filename is null!");
        assertNotNull(setPojo.getHostname(), "Hostname is null!");
        assertNotNull(setPojo.getRequests(), "Requests is null!");

        assertFalse(setPojo.getFilename().isEmpty(), "Filename is empty!");
        assertFalse(setPojo.getHostname().isEmpty(), "Hostname is empty!");
        assertFalse(setPojo.getRequests().isEmpty(), "Requests is empty!");

        assertFalse(setPojo.getRepeat() <= 0, "repeat is less or equals 0!");

        System.out.println("filename: " + setPojo.getFilename());
        System.out.println("hostname: " + setPojo.getHostname());
        System.out.println("repeat: " + setPojo.getRepeat());
        System.out.println("auth: " + setPojo.getAuth());
        System.out.println("requests: " + setPojo.getRequests());
    }

    @Test
    @Parameters({"jsonSetWithoutAuth"})
    public void deserialize_without_auth(String json) throws JsonProcessingException {
        SettingsPojo setPojo = new ObjectMapper().readValue(json, SettingsPojo.class);

        assertNotNull(setPojo.getFilename(), "Filename is null!");
        assertNotNull(setPojo.getHostname(), "Hostname is null!");
        assertNotNull(setPojo.getRequests(), "Requests is null!");

        assertFalse(setPojo.getFilename().isEmpty(), "Filename is empty!");
        assertFalse(setPojo.getHostname().isEmpty(), "Hostname is empty!");
        assertFalse(setPojo.getRequests().isEmpty(), "Requests is empty!");

        assertFalse(setPojo.getRepeat() <= 0, "repeat is less or equals 0!");

        System.out.println("filename: " + setPojo.getFilename());
        System.out.println("hostname: " + setPojo.getHostname());
        System.out.println("repeat: " + setPojo.getRepeat());
        System.out.println("auth: " + setPojo.getAuth());
        System.out.println("requests: " + setPojo.getRequests());
    }
}
