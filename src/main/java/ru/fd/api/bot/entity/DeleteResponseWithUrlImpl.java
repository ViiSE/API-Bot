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
import ru.fd.api.bot.constant.Methods;

@Component("deleteResponseWithUrl")
@Scope("prototype")
public class DeleteResponseWithUrlImpl implements Response {

    private final String url;

    public DeleteResponseWithUrlImpl(String url) {
        this.url = url;
    }

    @Override
    public String method() {
        return Methods.DELETE;
    }

    @Override
    public String url() {
        return url;
    }

    @Override
    public long evaluateTime() {
        return 0;
    }
}
