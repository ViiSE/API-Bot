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
import ru.fd.api.bot.data.RequestBodyPojo;

import java.util.List;

@Component("requestBodyWithListParams")
@Scope("prototype")
public class RequestBodyWithListParamsImpl implements RequestBody<RequestBodyPojo> {

    private final List<RequestBodyPojo> params;

    public RequestBodyWithListParamsImpl(List<RequestBodyPojo> params) {
        this.params = params;
    }

    @Override
    public List<RequestBodyPojo> requestBodyParams() {
        return params;
    }
}
