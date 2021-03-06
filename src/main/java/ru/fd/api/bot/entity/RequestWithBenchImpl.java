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

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import ru.fd.api.bot.exception.RequestException;
import ru.fd.api.bot.producer.entity.ResponseProducer;

@Component("requestWithBench")
@Scope("prototype")
public class RequestWithBenchImpl implements Request {

    private final Request request;
    private final ResponseProducer responseProducer;

    public RequestWithBenchImpl(Request request, ResponseProducer responseProducer) {
        this.request = request;
        this.responseProducer = responseProducer;
    }

    @Override
    public Response execute() throws RequestException {
        long timeStart = System.currentTimeMillis();
        Response response = request.execute();
        long timeEnd = System.currentTimeMillis();

        return responseProducer.getResponseWithBenchTimeInstance(response, (timeEnd - timeStart));
    }
}
