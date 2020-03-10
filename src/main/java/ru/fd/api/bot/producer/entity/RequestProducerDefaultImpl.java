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

import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;
import ru.fd.api.bot.data.RequestBodyPojo;
import ru.fd.api.bot.entity.Auth;
import ru.fd.api.bot.entity.Request;
import ru.fd.api.bot.entity.RequestBody;

@Service("requestProducerDefault")
public class RequestProducerDefaultImpl implements RequestProducer {

    private final ApplicationContext ctx;

    public RequestProducerDefaultImpl(ApplicationContext ctx) {
        this.ctx = ctx;
    }

    @Override
    public Request getGetRequestInstance(String url, Auth<String> auth, ResponseProducer responseProducer) {
        return (Request) ctx.getBean("getRequest", url, auth, responseProducer);
    }

    @Override
    public Request getPostRequestInstance(String url, Auth<String> auth, RequestBody<RequestBodyPojo> requestBody, ResponseProducer responseProducer) {
        return (Request) ctx.getBean("postRequest", url, auth, requestBody, responseProducer);
    }

    @Override
    public Request getPutRequestInstance(String url, Auth<String> auth, RequestBody<RequestBodyPojo> requestBody, ResponseProducer responseProducer) {
        return (Request) ctx.getBean("putRequest", url, auth, requestBody, responseProducer);
    }

    @Override
    public Request getDeleteRequestInstance(String url, Auth<String> auth, RequestBody<RequestBodyPojo> requestBody, ResponseProducer responseProducer) {
        return (Request) ctx.getBean("deleteRequest", url, auth, requestBody, responseProducer);
    }

    @Override
    public Request getEmptyRequestInstance() {
        return ctx.getBean("emptyRequest", Request.class);
    }

    @Override
    public Request getRequestWithBenchInstance(Request request, ResponseProducer responseProducer) {
        return (Request) ctx.getBean("requestWithBench", request, responseProducer);
    }
}
