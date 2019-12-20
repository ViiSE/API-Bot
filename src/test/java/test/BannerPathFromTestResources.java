package test;

import ru.fd.api.bot.BannerPath;
import ru.fd.api.bot.util.TestUtils;

public class BannerPathFromTestResources implements BannerPath {
    @Override
    public String path() {
        return TestUtils.getTestResourcesFile("banner.txt");
    }
}
