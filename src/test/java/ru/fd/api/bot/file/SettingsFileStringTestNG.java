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

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import ru.fd.api.bot.util.TestUtils;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertNotNull;

public class SettingsFileStringTestNG {

    @Test
    @Parameters({"filename"})
    public void content(String filename) {
        SettingsFile<String> settingsFile = new SettingsFileStringImpl(TestUtils.getTestResourcesFile(filename));
        String content = settingsFile.content();
        System.out.println("Content: " + content);
        assertNotNull(content, "Content is null!");
        assertFalse(content.isEmpty(), "Content is empty");
    }
}
