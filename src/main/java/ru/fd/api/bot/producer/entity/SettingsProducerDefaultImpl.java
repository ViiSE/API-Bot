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

import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;
import ru.fd.api.bot.entity.Request;
import ru.fd.api.bot.entity.Settings;
import ru.fd.api.bot.entity.SettingsFromFileJsonImpl;
import ru.fd.api.bot.file.SettingsFile;

@Service("settingsProducerDefault")
public class SettingsProducerDefaultImpl implements SettingsProducer {

    private final ApplicationContext ctx;

    public SettingsProducerDefaultImpl(ApplicationContext ctx) {
        this.ctx = ctx;
    }

    @Override
    public Settings<Request> getSettingsFromFileJsonInstance(
            RequestProducer requestProducer,
            AuthProducer authProducer,
            ResponseProducer responseProducer,
            RequestBodyProducer requestBodyProducer,
            SettingsFile<String> settingsFile) {
        return (SettingsFromFileJsonImpl) ctx.getBean(
                "settingsFromFileJson",
                requestProducer,
                authProducer,
                responseProducer,
                requestBodyProducer,
                settingsFile) ;
    }
}
