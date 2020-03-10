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

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

@Component("greetingsWithBanner")
public class GreetingsWithBannerImpl implements Greetings {

    private final BannerPath bannerPath;

    public GreetingsWithBannerImpl(BannerPath bannerPath) {
        this.bannerPath = bannerPath;
    }

    @Override
    public void hello() {
        Resource resource = new ClassPathResource(bannerPath.path());

        try(BufferedReader br = new BufferedReader(new InputStreamReader(resource.getInputStream()))) {
            br.lines().forEach(System.out::println);
        } catch(IOException ex) {
            System.out.println(ex.getMessage() + ": " + ex.getCause());
        }
    }
}
