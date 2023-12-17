package homeworks.dmytro_k.hw_2023.hw_05_11_23;

import java.nio.file.Path;
import java.nio.file.Paths;

public class TestAdvertisement {
    public static void main(String[] args) {

        Path path = Path.of("src/homeworks/dmytro_k/hw_2023/hw_05_11_23/advertisement");

        AdvertisementService advertisementService = new AdvertisementService(path);

        PlaceInfo placeInfo = new PlaceInfo(Os.LINUX, Browser.SAFARI);
        PlaceInfo placeInfo2 = new PlaceInfo(Os.WINDOWS, Browser.OPERA);

        //advertisementService.placeAdvertising(placeInfo, path, "Hello");
        advertisementService.placeAdvertising(path, Os.ANDROID, Browser.OPERA, "123");
        //advertisementService.placeAdvertising(placeInfo2, path, "Hello");
//
        //advertisementService.createNewPlace(Os.ANDROID, Browser.OPERA);
        //advertisementService.createNewPlace(path, Os.MAC_OS, Browser.GOOGLE_CHROME);
        //advertisementService.createNewPlace(path, Os.WINDOWS, Browser.OPERA);
        //advertisementService.deletePlace(Path.of(path + "/place_6"));
        //advertisementService.changePlaceConfiguration("place_1", Os.LINUX, Browser.GOOGLE_CHROME);
        //advertisementService.createScreen("place_1");
        //advertisementService.changeScreen("place_1", "Screen_2.txt", "bye");
    }
}
