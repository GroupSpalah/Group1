package homeworks.vladyslav_lazin.hw_2023.hw_05_11_23;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class LearnNewDirectoryStream {
    public static void main(String[] args) throws IOException {
        Path pathToDir = Paths.get("./src/homeworks/vladyslav_lazin/hw_2023/hw_05_11_23/");
        Path pathToFile = Paths.get("./src/homeworks/vladyslav_lazin/hw_2023/hw_05_11_23/places/Place_3/place_info.dat");
        PlaceInfo readPlaceInfo = null;
        try(FileInputStream inputStream = new FileInputStream(pathToFile.toFile());
            ObjectInputStream objectInputStream = new ObjectInputStream(inputStream)) {
            readPlaceInfo = (PlaceInfo) objectInputStream.readObject();
            System.out.println(readPlaceInfo);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
