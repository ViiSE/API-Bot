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

package ru.fd.api.bot.data;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import java.util.List;

@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class RequestPojo {

    private final String method;
    private final String url;
    @JsonInclude(JsonInclude.Include.NON_NULL) private final AuthPojo auth;
    @JsonInclude(JsonInclude.Include.NON_NULL) private final List<RequestBodyPojo> body;

    @JsonCreator
    public RequestPojo(
            @JsonProperty("method") String method,
            @JsonProperty("url") String url,
            @JsonProperty("auth") AuthPojo auth,
            @JsonProperty("body") List<RequestBodyPojo> body) {
        this.method = method;
        this.url = url;
        this.auth = auth;
        this.body = body;
    }

    public String getMethod() {
        return method;
    }

    public String getUrl() {
        return url;
    }

    public AuthPojo getAuth() {
        return auth;
    }

    public List<RequestBodyPojo> getBody() {
        return body;
    }
}
