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

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import ru.fd.api.bot.data.RequestBodyPojo;

import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.assertEquals;

public class RequestBodyWithListParamsTestNG {

    private List<RequestBodyPojo> requestBodyPojos;
    private RequestBody<RequestBodyPojo> requestBody;

    @BeforeClass
    public void setUpClass() {
        requestBodyPojos = new ArrayList<>() {{
            add(new RequestBodyPojo("name1", "value1"));
            add(new RequestBodyPojo("name2", "value2"));
            add(new RequestBodyPojo("name3", "value3"));
        }};
        requestBody = new RequestBodyWithListParamsImpl(requestBodyPojos);
    }

    @Test
    public void requestBodyParams() {
        List<RequestBodyPojo> requestBodyPojoList = requestBody.requestBodyParams();
        requestBodyPojoList.forEach(requestBodyPojo -> {
            System.out.println("--------------------------------------");
            System.out.println("\tname: " + requestBodyPojo.getName());
            System.out.println("\tvalue: " + requestBodyPojo.getValue());
        });

        assertEquals(requestBodyPojos, requestBodyPojoList);
    }
}
