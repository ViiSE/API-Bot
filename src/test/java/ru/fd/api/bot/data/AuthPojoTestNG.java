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

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class AuthPojoTestNG {

    @Test
    @Parameters({"type", "token"})
    public void serialize(String type, String token) throws JsonProcessingException {
        AuthPojo authPojo = new AuthPojo(type, token);

        System.out.println(
                new ObjectMapper()
                        .writerWithDefaultPrettyPrinter()
                        .writeValueAsString(authPojo));
    }

    @Test(dataProvider = "jsonDp")
    public void deserialize(String json, String cause) throws JsonProcessingException {
        System.out.println(cause);

        AuthPojo authPojo = new ObjectMapper().readValue(json, AuthPojo.class);

        System.out.println("type: " + authPojo.getType());
        System.out.println("token: " + authPojo.getToken());
    }

    @DataProvider(name = "jsonDp")
    public Object[][] createDP() {
        return new Object[][] {
                {
                        "{ " +
                            "\"type\": \"Bearer\", " +
                            "\"token\": \"'Token here'\"" +
                        "}",
                        "[with token]"
                },
                {
                        "{ " +
                            "\"type\": \"Bearer\"" +
                        "}",
                        "[without token]"
                }
        };
    }
}
