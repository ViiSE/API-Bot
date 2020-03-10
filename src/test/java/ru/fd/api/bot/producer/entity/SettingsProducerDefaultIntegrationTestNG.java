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

package ru.fd.api.bot.producer.entity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Test;
import ru.fd.api.bot.configuration.APIBotConfiguration;
import ru.fd.api.bot.entity.Request;
import ru.fd.api.bot.entity.Settings;
import ru.fd.api.bot.entity.SettingsFromFileJsonImpl;
import ru.fd.api.bot.file.SettingsFileStringImpl;

import static org.testng.Assert.assertTrue;

@ContextConfiguration(classes = { APIBotConfiguration.class })
public class SettingsProducerDefaultIntegrationTestNG extends AbstractTestNGSpringContextTests {

    @Autowired
    private SettingsProducer producer;

    @Autowired
    private RequestProducer requestProducer;

    @Autowired
    private AuthProducer authProducer;

    @Autowired
    private ResponseProducer responseProducer;

    @Autowired
    private RequestBodyProducer requestBodyProducer;

    @Test
    public void getEmptyRequestInstance() {
        Settings<Request> settings = producer.getSettingsFromFileJsonInstance(
                requestProducer,
                authProducer,
                responseProducer,
                requestBodyProducer,
                new SettingsFileStringImpl("filename"));
        System.out.println("instance: " + settings);
        assertTrue(settings instanceof SettingsFromFileJsonImpl);
    }
}
