package homeworks.sergii_khvostov.hw_2023.hw_05_11_23;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class AdvertisementServiceTest {
    public static void main(String[] args) throws IOException {
        Path path = Paths.get(".");
        new AdvertisementService(path);

        AdvertisementService as = new AdvertisementService(path);
        String content1 = "My advertisement_1";
        String content2 = "My advertisement_2";
        as.placeAnAdvertisementOnly(Os.WINDOWS, Browser.CHROME, content1);
        as.placeAnAdvertisementOnly(Os.WINDOWS, Browser.CHROME, content2);
        as.placeAnAdvertisementOnly(Os.LINUX, Browser.SAFARI, content2);
    }
}

