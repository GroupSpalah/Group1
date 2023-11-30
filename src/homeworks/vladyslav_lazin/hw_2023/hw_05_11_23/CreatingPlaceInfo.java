package homeworks.vladyslav_lazin.hw_2023.hw_05_11_23;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class CreatingPlaceInfo {
    public static void main(String[] args) {

        Path path = Paths.get("./src/homeworks/vladyslav_lazin/hw_2023/hw_05_11_23/places");

        try {
            Files.list(path)
                    .forEach(element -> {
                        PlaceInfo placeInfo = new PlaceInfo(Os.ANDROID, Browser.CHROME);
                        Path pathToFile = element.resolve("place_info.dat");
                        try(FileOutputStream fileOutputStream = new FileOutputStream(pathToFile.toFile());
                            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream)) {
                            objectOutputStream.writeObject(placeInfo);
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                    });
        } catch (IOException e) {
            throw new RuntimeException(e);
        }



    }
}
