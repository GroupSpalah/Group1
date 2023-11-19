package homeworks.dmytro_k.hw_2023.hw_05_11_23;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;
import java.util.stream.IntStream;

public class AdvertisementService {
    private static final List<PlaceInfo> PLACE_INFOS = List.of(
            new PlaceInfo(Os.I_OS, Browser.SAFARI),
            new PlaceInfo(Os.LINUX, Browser.FIREFOX),
            new PlaceInfo(Os.WINDOWS, Browser.MICROSOFT_EDGE),
            new PlaceInfo(Os.MAC_OS, Browser.OPERA),
            new PlaceInfo(Os.ANDROID, Browser.GOOGLE_CHROME)
    );

    public AdvertisementService(Path path) {
        createDefaultPlaces(path);
    }

    private void createDefaultPlaces(Path path) {
        IntStream.rangeClosed(1, 5)
                .forEach(index -> {
                    String absolutePath = path.toFile().getAbsolutePath();
                    Path pathToPlace = Paths.get(absolutePath, "Place_" + index);

                    try {
                        Files.createDirectory(pathToPlace);
                        createDefaultScreens(pathToPlace);
                        createDefaultPlatformInfo(pathToPlace, index - 1);

                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                });
    }

    private void createDefaultScreens(Path path) {
        IntStream.rangeClosed(1, 5)
                .forEach(index -> {
                    String absolutePath = path.toFile().getAbsolutePath();
                    Path pathToPlace = Paths.get(absolutePath, "Screen_" + index + ".txt");

                    try {
                        Files.createFile(pathToPlace);
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                });
    }

    private void createDefaultPlatformInfo(Path path, int index) {
        String platformPath = path.toFile().getAbsolutePath();
        Path pathToPlatform = Paths.get(platformPath, "Info.inf");

        try {
            FileOutputStream fileOutputStream = new FileOutputStream(pathToPlatform.toFile());
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(PLACE_INFOS.get(index));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public PlaceInfo readInfoFile(Path path) {
        String platformPath = path.toFile().getAbsolutePath();
        Path pathToPlatform = Paths.get(platformPath, "Info.inf");
        try {
            FileInputStream fileInputStream = new FileInputStream(pathToPlatform.toFile());
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            return (PlaceInfo) objectInputStream.readObject();
        } catch (ClassNotFoundException | IOException e) {
            throw new RuntimeException(e);
        }
    }

    //1) Размещать рекламу рекламодателя только на устройствах с определенным браузером и ОСью.
    public void placeAdvertising(PlaceInfo placeInfo, Path path, String advertising) {
        Os os = placeInfo.getOs();
        Browser browser = placeInfo.getBrowser();

        IntStream.rangeClosed(1, 5)
                .forEach(index -> {
                    String absolutePath = path.toFile().getAbsolutePath();
                    Path pathToPlace = Paths.get(absolutePath, "Place_" + index);

                    PlaceInfo placeInfoDefault = readInfoFile(pathToPlace);
                    if (placeInfoDefault.getBrowser().equals(browser)
                            && placeInfoDefault.getOs().equals(os)) {//reedAllDirectory(add)
                        Path pathToFile = Paths.get(String.valueOf(pathToPlace), "Screen_1.txt");
                        writeAdvertising(pathToFile, advertising);
                    }
                });
    }

    private void writeAdvertising(Path path, String advertising) {
        try {
            Files.writeString(path, advertising, StandardOpenOption.WRITE);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
