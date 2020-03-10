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
public class SettingsPojo {

    private final String filename;
    private final String hostname;
    private final int repeat;
    @JsonInclude(JsonInclude.Include.NON_NULL) private final AuthPojo auth;
    private final List<RequestPojo> requests;

    @JsonCreator
    public SettingsPojo(
            @JsonProperty("filename") String filename,
            @JsonProperty("hostname") String hostname,
            @JsonProperty("repeat") int repeat,
            @JsonProperty("auth") AuthPojo auth,
            @JsonProperty("requests") List<RequestPojo> requests) {
        this.filename = filename;
        this.hostname = hostname;
        this.repeat = repeat;
        this.auth = auth;
        this.requests = requests;
    }

    public String getFilename() {
        return filename;
    }

    public String getHostname() {
        return hostname;
    }

    public int getRepeat() {
        return repeat;
    }

    public AuthPojo getAuth() {
        return auth;
    }

    public List<RequestPojo> getRequests() {
        return requests;
    }
}
