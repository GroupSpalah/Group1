package homeworks.sergii_khvostov.hw_2023.hw_05_11_23;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class AdvertisementServiceCheck {
    public static void main(String[] args) throws IOException {
        Path path = Paths.get(".");
        AdvertisementService as = new AdvertisementService(path);

       // String content1 = "My content";
        //String content2 = "My advertisement_2";
        //as.placeAdvertisement(Os.WINDOWS, Browser.CHROME, content1);
        //as.placeAdvertisement(Os.WINDOWS, Browser.CHROME, content2);

        //as.replaceAdvertisement("Place_1", 1, content2);
        //as.createNewPlace(Os.LINUX, Browser.CHROME);
        //as.deletePlace("Place_1");
        //as.addNewScreen("Place_1");
        //as.changePlaceConfiguration("Place_1", new PlaceInfo(Os.UNIX, Browser.SAFARI));
    }
}

