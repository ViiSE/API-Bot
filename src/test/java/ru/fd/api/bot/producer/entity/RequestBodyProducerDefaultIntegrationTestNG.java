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
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import ru.fd.api.bot.configuration.APIBotConfiguration;
import ru.fd.api.bot.data.RequestBodyPojo;
import ru.fd.api.bot.entity.RequestBody;
import ru.fd.api.bot.entity.RequestBodyWithListParamsImpl;

import java.util.ArrayList;

import static org.testng.Assert.assertTrue;

@ContextConfiguration(classes = { APIBotConfiguration.class })
public class RequestBodyProducerDefaultIntegrationTestNG extends AbstractTestNGSpringContextTests {

    @Autowired
    private RequestBodyProducer producer;

    @Test
    @Parameters({"type", "token"})
    public void getRequestBodyWithListParamsInstance() {
        RequestBody<RequestBodyPojo> reqBody = producer.getRequestBodyWithListParamsInstance(
                new ArrayList<>() {{ add(new RequestBodyPojo("name", "val")); }}
        );
        System.out.println("instance: " + reqBody);
        assertTrue(reqBody instanceof RequestBodyWithListParamsImpl);
    }
}
