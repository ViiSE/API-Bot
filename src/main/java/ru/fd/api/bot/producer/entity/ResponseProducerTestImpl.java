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

import ru.fd.api.bot.entity.*;

public class ResponseProducerTestImpl implements ResponseProducer {

    @Override
    public Response getGetResponseWithUrlInstance(String url) {
        return new GetResponseWithUrlImpl(url);
    }

    @Override
    public Response getPostResponseWithUrlInstance(String url) {
        return new PostResponseWithUrlImpl(url);
    }

    @Override
    public Response getPutResponseWithUrlInstance(String url) {
        return new PutResponseWithUrlImpl(url);
    }

    @Override
    public Response getDeleteResponseWithUrlInstance(String url) {
        return new DeleteResponseWithUrlImpl(url);
    }

    @Override
    public Response getResponseWithBenchTimeInstance(Response response, long evaluateTime) {
        return new ResponseWithBenchTimeImpl(response, evaluateTime);
    }

    @Override
    public Response getEmptyResponseInstance() {
        return new EmptyResponseImpl();
    }
}
