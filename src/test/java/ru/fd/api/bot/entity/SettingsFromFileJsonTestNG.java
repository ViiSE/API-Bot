/*
 *     Copyright (C) 2020 ViiSE
 *
 *     This program is free software: you can redistribute it and/or modify
 *     it under the terms of the GNU General Public License as published by
 *     the Free Software Foundation, either version 3 of the License, or
 *     (at your option) any later version.
 *
 *     This program is distributed in the hope that it will be useful,
 *     but WITHOUT ANY WARRANTY; without even the implied warranty of
 *     MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *     GNU General Public License for more details.
 *
 *     You should have received a copy of the GNU General Public License
 *     along with this program.  If not, see <https://www.gnu.org/licenses/>.
 */

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
