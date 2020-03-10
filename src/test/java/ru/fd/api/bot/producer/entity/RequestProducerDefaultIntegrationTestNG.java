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
public class RequestProducerDefaultIntegrationTestNG extends AbstractTestNGSpringContextTests {

    @Autowired
    private RequestProducer producer;

    @Autowired
    private ResponseProducer responseProducer;

    @Test
    public void getEmptyRequestInstance() {
        Request request = producer.getEmptyRequestInstance();
        System.out.println("instance: " + request);
        assertTrue(request instanceof EmptyRequestImpl);
    }

    @Test
    public void getGetRequestInstance() {
        Request request = producer.getGetRequestInstance("url", new AuthStringNoneImpl(), responseProducer);
        System.out.println("instance: " + request);
        assertTrue(request instanceof GetRequestImpl);
    }

    @Test
    public void getPostRequestInstance() {
        Request request = producer.getPostRequestInstance("url", new AuthStringNoneImpl(), null, responseProducer);
        System.out.println("instance: " + request);
        assertTrue(request instanceof PostRequestImpl);
    }

    @Test
    public void getPutRequestInstance() {
        Request request = producer.getPutRequestInstance("url", new AuthStringNoneImpl(), null, responseProducer);
        System.out.println("instance: " + request);
        assertTrue(request instanceof PutRequestImpl);
    }

    @Test
    public void getDeleteRequestInstance() {
        Request request = producer.getDeleteRequestInstance("url", new AuthStringNoneImpl(), null, responseProducer);
        System.out.println("instance: " + request);
        assertTrue(request instanceof DeleteRequestImpl);
    }
}
