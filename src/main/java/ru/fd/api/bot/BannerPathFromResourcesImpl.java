package ru.fd.api.bot;

import org.springframework.stereotype.Component;

@Component("BannerPathFromResource")
public class BannerPathFromResourcesImpl implements BannerPath {

    @Override
    public String path() {
        return "banner.txt";
    }
}
