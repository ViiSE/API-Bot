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

package ru.fd.api.bot;

import org.springframework.stereotype.Component;
import ru.fd.api.bot.entity.Request;
import ru.fd.api.bot.entity.Settings;
import ru.fd.api.bot.file.SettingsFile;
import ru.fd.api.bot.producer.entity.*;

@Component("applicationRunnerDefault")
public class ApplicationRunnerDefaultImpl implements ApplicationRunner<String> {

    private final Bot bot;
    private final RequestProducer requestProducer;
    private final AuthProducer authProducer;
    private final ResponseProducer responseProducer;
    private final RequestBodyProducer requestBodyProducer;
    private final SettingsProducer settingsProducer;

    public ApplicationRunnerDefaultImpl(
            Bot bot,
            RequestProducer requestProducer,
            AuthProducer authProducer,
            ResponseProducer responseProducer,
            RequestBodyProducer requestBodyProducer,
            SettingsProducer settingsProducer) {
        this.bot = bot;
        this.requestProducer = requestProducer;
        this.authProducer = authProducer;
        this.responseProducer = responseProducer;
        this.requestBodyProducer = requestBodyProducer;
        this.settingsProducer = settingsProducer;
    }

    @Override
    public void run(SettingsFile<String> settingsFile) {
        Settings<Request> settings = settingsProducer.getSettingsFromFileJsonInstance(
                requestProducer,
                authProducer,
                responseProducer,
                requestBodyProducer,
                settingsFile);

        bot.execute(settings);
    }
}
