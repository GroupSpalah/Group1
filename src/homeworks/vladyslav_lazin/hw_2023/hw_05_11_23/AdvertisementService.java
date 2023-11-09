package homeworks.vladyslav_lazin.hw_2023.hw_05_11_23;

import java.io.*;
import java.nio.file.*;
import java.util.List;
import java.util.stream.IntStream;

public class AdvertisementService {
    private final String ABSOLUTE_PATH = "./src/homeworks/vladyslav_lazin/hw_2023/hw_05_11_23/places";
    private static final List<PlaceInfo> PLACE_INFOS = List.of(
            new PlaceInfo(Os.GNU_LINUX, Browser.FIREFOX),
            new PlaceInfo(Os.OS_X, Browser.SAFARI),
            new PlaceInfo(Os.ANDROID, Browser.CHROME),
            new PlaceInfo(Os.IOS, Browser.SAFARI),
            new PlaceInfo(Os.MS_WINDOWS, Browser.EDGE)
    );

    public AdvertisementService() {
        createDefaultPlaces();
        createDefaultScreens();
        createPlaceInfoFiles();
    }
    private boolean isFileStructureExisists() {
        boolean result;
        Path placesPathObject = FileSystems.getDefault().getPath(ABSOLUTE_PATH);
        try {
            result = Files.list(placesPathObject).findAny().isPresent();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return result;
    }
    private void createDefaultPlaces() {
        if (!isFileStructureExisists()) {
            IntStream.rangeClosed(1, 5)
                    .forEach(index -> {
                        Path pathToPlace = Paths.get(ABSOLUTE_PATH, "Place_" + index);
                        try {
                            Files.createDirectory(pathToPlace);
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                    });
        }
    }private void createDefaultScreens() {
        if (!isFileStructureExisists()) {
            IntStream.rangeClosed(1, 5)
                    .forEach(dirIndex -> {
                        IntStream.rangeClosed(1, 5)
                                .forEach(fileIndex -> {
                                    Path pathToFile = Paths.get(ABSOLUTE_PATH, "Place_" + dirIndex + "/" + "screen_" + fileIndex + ".txt");
                                    try {
                                        Files.createFile(pathToFile);
                                    } catch (IOException e) {
                                        throw new RuntimeException(e);
                                    }
                                });
                    });
        }
    }
    private void createPlaceInfoFiles() {
        if (!isFileStructureExisists()) {
            IntStream.rangeClosed(1, 5)
                    .forEach(dirIndex -> {
                        Path pathToPlace = Paths.get(ABSOLUTE_PATH, "Place_" + dirIndex + "/" + "place_info.dat");
                        try (FileOutputStream fileOutputStream = new FileOutputStream(pathToPlace.toFile());
                             ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream)) {
                            objectOutputStream.writeObject(PLACE_INFOS.get(dirIndex - 1));
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                    });
        }
    }
    public void postAdvertisimentOnPlace(Os os, Browser browser, String adContent) {
        IntStream.rangeClosed(1, 5)
                .forEach(dirIndex -> {
                    PlaceInfo placeInfo = null;
                    Path pathToPlace = Paths.get(ABSOLUTE_PATH, "Place_" + dirIndex + "/" + "place_info.dat");
                    try(FileInputStream fileInputStream = new FileInputStream(pathToPlace.toFile());
                            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream)) {
                        placeInfo = (PlaceInfo) objectInputStream.readObject();
                        if (placeInfo.getOs() == os && placeInfo.getBrowser() == browser) {
                            IntStream.rangeClosed(1, 5)
                                    .forEach(fileIndex -> {
                                        Path pathToFile = Paths.get(ABSOLUTE_PATH, "Place_" + dirIndex + "/" + "screen_" + fileIndex + ".txt");
                                        try {
                                            Files.writeString(pathToFile, adContent, StandardOpenOption.APPEND);
                                        } catch (IOException e) {
                                            throw new RuntimeException(e);
                                        }
                                    });
                        }
                    } catch (IOException | ClassNotFoundException e) {
                        throw new RuntimeException(e);
                    }
                });
    }
    public void replaceAdvertisimentAtPlace(Os os, Browser browser, String adContent) {

    }
}
