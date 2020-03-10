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
import ru.fd.api.bot.entity.*;

import static org.testng.Assert.assertTrue;

@ContextConfiguration(classes = { APIBotConfiguration.class })
public class ResponseProducerDefaultIntegrationTestNG extends AbstractTestNGSpringContextTests {

    @Autowired
    private ResponseProducer producer;

    @Test
    public void getEmptyResponseInstance() {
        Response response = producer.getEmptyResponseInstance();
        System.out.println("instance: " + response);
        assertTrue(response instanceof EmptyResponseImpl);
    }

    @Test
    public void getGetResponseInstance() {
        Response response = producer.getGetResponseWithUrlInstance("url");
        System.out.println("instance: " + response);
        assertTrue(response instanceof GetResponseWithUrlImpl);
    }

    @Test
    public void getPostResponseInstance() {
        Response response = producer.getPostResponseWithUrlInstance("url");
        System.out.println("instance: " + response);
        assertTrue(response instanceof PostResponseWithUrlImpl);
    }

    @Test
    public void getPutResponseInstance() {
        Response response = producer.getPutResponseWithUrlInstance("url");
        System.out.println("instance: " + response);
        assertTrue(response instanceof PutResponseWithUrlImpl);
    }

    @Test
    public void getDeleteResponseInstance() {
        Response response = producer.getDeleteResponseWithUrlInstance("url");
        System.out.println("instance: " + response);
        assertTrue(response instanceof DeleteResponseWithUrlImpl);
    }
}
