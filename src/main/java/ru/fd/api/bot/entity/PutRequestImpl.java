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

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import okhttp3.OkHttpClient;
import okhttp3.ResponseBody;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import ru.fd.api.bot.constant.Auths;
import ru.fd.api.bot.data.MediaTypes;
import ru.fd.api.bot.data.RequestBodyPojo;
import ru.fd.api.bot.exception.RequestException;
import ru.fd.api.bot.producer.entity.ResponseProducer;

import java.io.IOException;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

@Component("putRequest")
@Scope("prototype")
public class PutRequestImpl implements Request {

    private final String url;
    private final Auth<String> auth;
    private final RequestBody<RequestBodyPojo> requestBody;
    private final ResponseProducer responseProducer;

    public PutRequestImpl(
            String url,
            Auth<String> auth,
            RequestBody<RequestBodyPojo> requestBody,
            ResponseProducer responseProducer) {
        this.url = url;
        this.auth = auth;
        this.requestBody = requestBody;
        this.responseProducer = responseProducer;
    }

    @Override
    public Response execute() throws RequestException {
        ResponseBody body = null;
        try {
            OkHttpClient client = new OkHttpClient.Builder()
                    .connectTimeout(60, TimeUnit.MINUTES)
                    .readTimeout(60, TimeUnit.MINUTES)
                    .writeTimeout(60, TimeUnit.MINUTES)
                    .build();

            okhttp3.Request.Builder builder = new okhttp3.Request.Builder().url(url);

            if (!auth.body().contains(Auths.NONE))
                builder.addHeader("Authorization", auth.body());

            ObjectMapper mapper = new ObjectMapper();
            ObjectNode node = mapper.createObjectNode();
            requestBody.requestBodyParams().forEach(params -> node.put(params.getName(), params.getValue()));

            okhttp3.RequestBody rBody = okhttp3.RequestBody.create(node.toString(), MediaTypes.JSON);
            okhttp3.Request request = builder.put(rBody).build();

            okhttp3.Response response = client.newCall(request).execute();
            body = response.body();

            Objects.requireNonNull(response.body()).close();

            return responseProducer.getPutResponseWithUrlInstance(url);
        } catch (IOException ex) {
            throw new RequestException(ex);
        } finally {
            if(body != null)
                body.close();
        }
    }
}
