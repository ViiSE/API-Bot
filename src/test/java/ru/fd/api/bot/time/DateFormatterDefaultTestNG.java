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

package ru.fd.api.bot.time;

import org.testng.annotations.Test;

import java.util.Date;

import static org.testng.Assert.*;

public class DateFormatterDefaultTestNG {

    private static final String regex = "^(0?[0-9]|[0-5][0-9])m (0?[0-9]|[0-5][0-9])s (00?[0-9]|0?[0-9][0-9]|[0-9][0-9][0-9])ms$";

    @Test
    public void format() {
        Date date = new Date();

        DateFormatter dateFormatter = new DateFormatterDefaultImpl();
        String formattedDate = dateFormatter.format(date);
        System.out.println("Formatted: " + formattedDate);
        assertNotNull(formattedDate, "Formatted date is null!");
        assertFalse(formattedDate.isEmpty(), "Formatted date is null!");
        assertTrue(formattedDate.matches(regex));
    }
}
