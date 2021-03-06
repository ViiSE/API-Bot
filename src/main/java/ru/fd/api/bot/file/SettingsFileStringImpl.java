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

package ru.fd.api.bot.file;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

@Component("settingsFileString")
@Scope("prototype")
public class SettingsFileStringImpl implements SettingsFile<String> {

    private final String fullFilename;

    public SettingsFileStringImpl(String fullFilename) {
        this.fullFilename = fullFilename;
    }

    @Override
    public String content() {
        File settingsFile = new File(fullFilename);
        try(BufferedReader br = new BufferedReader(new FileReader(settingsFile))) {
            StringBuilder jsonB = new StringBuilder();
            br.lines().forEach(jsonB::append);

            return jsonB.toString();
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }
}
