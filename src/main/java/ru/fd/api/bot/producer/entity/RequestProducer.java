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

import ru.fd.api.bot.data.RequestBodyPojo;
import ru.fd.api.bot.entity.Auth;
import ru.fd.api.bot.entity.Request;
import ru.fd.api.bot.entity.RequestBody;

public interface RequestProducer {
    Request getGetRequestInstance(String url, Auth<String> auth, ResponseProducer responseProducer);
    Request getPostRequestInstance(String url, Auth<String> auth, RequestBody<RequestBodyPojo> requestBody, ResponseProducer responseProducer);
    Request getPutRequestInstance(String url, Auth<String> auth, RequestBody<RequestBodyPojo> requestBody, ResponseProducer responseProducer);
    Request getDeleteRequestInstance(String url, Auth<String> auth, RequestBody<RequestBodyPojo> requestBody, ResponseProducer responseProducer);
    Request getEmptyRequestInstance();
    Request getRequestWithBenchInstance(Request request, ResponseProducer responseProducer);
}
