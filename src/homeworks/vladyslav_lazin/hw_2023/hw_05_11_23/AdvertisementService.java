package homeworks.vladyslav_lazin.hw_2023.hw_05_11_23;

import java.io.*;
import java.nio.file.*;
import java.util.List;
import java.util.stream.IntStream;

public class AdvertisementService {
    private static final List<PlaceInfo> PLACE_INFOS = List.of(
            new PlaceInfo(Os.GNU_LINUX, Browser.FIREFOX),
            new PlaceInfo(Os.OS_X, Browser.SAFARI),
            new PlaceInfo(Os.ANDROID, Browser.CHROME),
            new PlaceInfo(Os.IOS, Browser.SAFARI),
            new PlaceInfo(Os.MS_WINDOWS, Browser.EDGE)
    );

    public AdvertisementService(Path path) {
        createDefaultPlaces(path);
        createDefaultScreens(path);
        createPlaceInfoFiles(path);
    }

    private boolean isFileStructureNotExisists(Path path) {
        boolean result = false;
        String absolutePath = path.toFile().getAbsolutePath();
        Path placesPathObject = FileSystems.getDefault().getPath(absolutePath);
        try {
            result = Files.list(placesPathObject).findAny().isEmpty();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return result;
    }

    private void createDefaultPlaces(Path path) {
        String absolutePath = path.toFile().getAbsolutePath();
        if (isFileStructureNotExisists(path)) {
            IntStream.rangeClosed(1, 5)
                    .forEach(index -> {
                        Path pathToPlace = Paths.get(absolutePath, "Place_" + index);
                        try {
                            Files.createDirectory(pathToPlace);
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                    });
        }
    }

    private void createDefaultScreens(Path path) {
        String absolutePath = path.toFile().getAbsolutePath();
        IntStream.rangeClosed(1, 5)
                .forEach(dirIndex -> {
                    Path pathToPlace = Paths.get(absolutePath, "Place_" + dirIndex);
                    if (isFileStructureNotExisists(pathToPlace)) {
                        IntStream.rangeClosed(1, 5)
                                .forEach(fileIndex -> {
                                    Path pathToFile = Paths.get(absolutePath, "Place_" + dirIndex + "/" + "screen_" + fileIndex + ".txt");
                                    try {
                                        Files.createFile(pathToFile);
                                    } catch (IOException e) {
                                        throw new RuntimeException(e);
                                    }
                                });
                    }
                });
    }

    private void createPlaceInfoFiles(Path path) {
        IntStream.rangeClosed(1, 5)
                .forEach(dirIndex -> {
                    String absolutePath = path.toFile().getAbsolutePath();
                    Path pathToPlace = Paths.get(absolutePath, "Place_" + dirIndex + "/" + "place_info.dat");
                    try (FileOutputStream fileOutputStream = new FileOutputStream(pathToPlace.toFile());
                         ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream)) {
                        objectOutputStream.writeObject(PLACE_INFOS.get(dirIndex - 1));
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                });
    }

    public void postAdvertisimentOnPlace(Os os, Browser browser, String adContent, Path path) {
        IntStream.rangeClosed(1, 5)
                .forEach(dirIndex -> {
                    PlaceInfo placeInfo = null;
                    String absolutePath = path.toFile().getAbsolutePath();
                    Path pathToPlace = Paths.get(absolutePath, "Place_" + dirIndex + "/" + "place_info.dat");
                    if (Files.exists(pathToPlace)) {
                        try (FileInputStream fileInputStream = new FileInputStream(pathToPlace.toFile());
                             ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream)) {
                            placeInfo = (PlaceInfo) objectInputStream.readObject();
                            if (placeInfo.getOs() == os && placeInfo.getBrowser() == browser) {
                                IntStream.rangeClosed(1, 5)
                                        .forEach(fileIndex -> {
                                            Path pathToFile = Paths.get(absolutePath, "Place_" + dirIndex + "/" + "screen_" + fileIndex + ".txt");
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
                    }
                });
    }

    public void replaceAdvertisimentAtPlace(Os os, Browser browser, String adContent) {

    }
}
