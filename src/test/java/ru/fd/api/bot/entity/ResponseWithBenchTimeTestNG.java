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
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import ru.fd.api.bot.constant.Methods;

import static org.testng.Assert.assertEquals;

public class ResponseWithBenchTimeTestNG {

    private Response response;

    @BeforeClass
    @Parameters({"url", "evalTime"})
    public void setUpClass(String url, long evalTime) {
        response = new ResponseWithBenchTimeImpl(
                new GetResponseWithUrlImpl(url),
                evalTime);
    }

    @Test
    public void method() {
        System.out.println("Method: " + response.method());
        assertEquals(response.method(), Methods.GET);
    }

    @Test
    @Parameters({"url"})
    public void url(String url) {
        System.out.println("url: " + response.url());
        assertEquals(response.url(), url);
    }

    @Test
    @Parameters({"evalTime"})
    public void evaluateTime(long evalTime) {
        System.out.println("evaluateTime: " + response.evaluateTime());
        assertEquals(response.evaluateTime(), evalTime);
    }
}
