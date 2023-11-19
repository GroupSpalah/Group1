package homeworks.vladyslav_lazin.hw_2023.hw_05_11_23;

import java.nio.file.Path;
import java.nio.file.Paths;

public class AdvertisementTest {
    public static void main(String[] args) {
        Path path = Paths.get("./src/homeworks/vladyslav_lazin/hw_2023/hw_05_11_23/places");
        AdvertisementService advertisementService = new AdvertisementService(path);
//        advertisementService.postAdvertisimentOnPlace(path, Os.ANDROID, Browser.CHROME,
//                "Lorem ipsum dolor sit amet, consectetur adipiscing elit, " +
//                "sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. " +
//                "Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi " +
//                "ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in " +
//                "voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint " +
//                "occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim " +
//                "id est laborum.");
        advertisementService.createNewPlace(path, Os.IOS, Browser.SAFARI);
        advertisementService.deletePlace("Place_7", path);
    }
}
