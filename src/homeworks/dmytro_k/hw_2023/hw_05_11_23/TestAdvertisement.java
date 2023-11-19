package homeworks.dmytro_k.hw_2023.hw_05_11_23;

import java.nio.file.Path;
import java.nio.file.Paths;

public class TestAdvertisement {
    public static void main(String[] args) {

        Path path = Paths.get("src/homeworks/dmytro_k/hw_2023/hw_05_11_23/advertisement");

        AdvertisementService advertisementService = new AdvertisementService(path);

        PlaceInfo placeInfo = new PlaceInfo(Os.I_OS, Browser.SAFARI);

        advertisementService.placeAdvertising(placeInfo, path, "Hello");
    }
}
