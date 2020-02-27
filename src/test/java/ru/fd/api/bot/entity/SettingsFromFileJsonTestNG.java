package ru.fd.api.bot.entity;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import ru.fd.api.bot.file.SettingsFileStringImpl;
import ru.fd.api.bot.producer.entity.AuthProducerTestImpl;
import ru.fd.api.bot.producer.entity.RequestBodyProducerTestImpl;
import ru.fd.api.bot.producer.entity.RequestProducerTestImpl;
import ru.fd.api.bot.producer.entity.ResponseProducerTestImpl;
import ru.fd.api.bot.util.TestUtils;

import java.util.List;

public class SettingsFromFileJsonTestNG {

    private Settings<Request> settings;

    @BeforeClass
    public void setUpClass() {
        settings = new SettingsFromFileJsonImpl(
                new RequestProducerTestImpl(),
                new AuthProducerTestImpl(),
                new ResponseProducerTestImpl(),
                new RequestBodyProducerTestImpl(),
                new SettingsFileStringImpl(TestUtils.getTestResourcesFile("settings.json")));
    }

    @Test
    public void requests() {
        List<Request> requests = settings.requests();
        System.out.println("Requests:");
        System.out.println("------------------------------------");
        requests.forEach(System.out::println);
    }

    @Test
    public void repeat() {
        int repeat = settings.repeat();
        System.out.println("Repeat:");
        System.out.println("------------------------------------");
        System.out.println(repeat);
    }

    @Test
    public void fullFilename() {
        String fullFilename = settings.fullFilename();
        System.out.println("Full filename:");
        System.out.println("------------------------------------");
        System.out.println(fullFilename);
    }
}
