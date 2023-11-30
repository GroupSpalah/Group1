package homeworks.vladyslav_lazin.hw_2023.hw_05_11_23;

import java.io.*;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.IntStream;

public class AdvertisementService {
    private static final String PLACE_DIR_NAME = "Place_";
    private static final String SCREEN_FILE_NAME = "screen_";
    private static final String PLACE_INFO_FILE_NAME = "place_info.dat";
    private static final String SCREEN_FILE_EXT = ".txt";

    private static final List<PlaceInfo> PLACE_INFOS = new ArrayList<>(
            List.of(
                    new PlaceInfo(Os.GNU_LINUX, Browser.FIREFOX),
                    new PlaceInfo(Os.OS_X, Browser.SAFARI),
                    new PlaceInfo(Os.ANDROID, Browser.CHROME),
                    new PlaceInfo(Os.IOS, Browser.SAFARI),
                    new PlaceInfo(Os.MS_WINDOWS, Browser.EDGE)
            ));

    public AdvertisementService(Path path) {
        createDefaultPlaces(path);
    }

    private void createDefaultPlaces(Path path) {
        IntStream.rangeClosed(1, 5)
                .forEach(index -> {
                    Path pathToPlace = path.resolve(PLACE_DIR_NAME + index);
                    try {
                        if (!Files.exists(pathToPlace)) {
                            Files.createDirectory(pathToPlace);
                        }
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                });
        createDefaultScreens(path);
    }

    private void createDefaultScreens(Path path) {
        IntStream.rangeClosed(1, 5)
                .forEach(dirIndex -> {
                    Path pathToPlace = path.resolve(PLACE_DIR_NAME + dirIndex);
                    createScreens(pathToPlace);
                });
        addPlaceInfoFiles(path);
    }

    private void createScreens(Path pathToPlace) {
        IntStream.rangeClosed(1, 5)
                .forEach(fileIndex -> {
                    Path pathToFile = pathToPlace.resolve(SCREEN_FILE_NAME + fileIndex + SCREEN_FILE_EXT);
                    try {
                        if (!Files.exists(pathToFile)) {
                            Files.createFile(pathToFile);
                        }
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                });
    }

    private void addPlaceInfoFiles(Path pathToPlaces) {
        try {
            Files.list(pathToPlaces)
                    .forEach(element -> {
                        String absolutePath = element.toFile().getAbsolutePath();
                        int i = absolutePath.charAt(absolutePath.length() - 1) - '0';
                        Path pathToFile = element.resolve(PLACE_INFO_FILE_NAME);
                        if (!Files.exists(pathToFile)) {
                            createPlaceInfoFile(pathToFile, PLACE_INFOS.get(i - 1));
                        }
                    });
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void createPlaceInfoFile(Path pathToPlaceInfoFile, PlaceInfo placeInfo) {
        try (FileOutputStream fileOutputStream = new FileOutputStream(pathToPlaceInfoFile.toFile());
             ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream)) {
            objectOutputStream.writeObject(placeInfo);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void postAdvertisimentOnPlace(Path path, Os os, Browser browser, String adContent) {
        try {
            Files.list(path)
                    .forEach(currentPath -> {
                        PlaceInfo placeInfo = null;
                        Path pathToInfoFile = currentPath.resolve(PLACE_INFO_FILE_NAME);
                        placeInfo = retrievePlaceInfo(pathToInfoFile);
                        if (placeInfo.getOs() == os && placeInfo.getBrowser() == browser) {
                            fillScreens(currentPath, adContent);
                        }
                    });
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    private void fillScreens(Path path, String adContent) {
        try {
            Files.list(path)
                    .filter(file -> file.toString().endsWith(SCREEN_FILE_EXT))
                    .forEach(currentPath -> {
                        try {
                            Files.deleteIfExists(currentPath);
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                        try {
                            Files.writeString(currentPath, adContent, StandardOpenOption.CREATE);
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                    });
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    private PlaceInfo retrievePlaceInfo(Path pathToInfoFile) {
        PlaceInfo placeInfo = null;
        try (FileInputStream fileInputStream = new FileInputStream(pathToInfoFile.toFile());
             ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream)) {
            placeInfo = (PlaceInfo) objectInputStream.readObject();
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return placeInfo;
    }
    public void replaceAdvertisimentAtPlace(Path path, String placeName, String newAdContent) {
        Path pathToPlace = path.resolve(placeName);
        fillScreens(pathToPlace, newAdContent);
    }
    public void createNewPlace(Path path, Os os, Browser browser) {
        try {
            long newPlacesCount = Files.list(path).count() + 1;
            Path pathToPlace = path.resolve(PLACE_DIR_NAME + newPlacesCount);
            Files.createDirectory(pathToPlace);
            createScreens(pathToPlace);
            Path pathToInfoFile = pathToPlace.resolve(PLACE_INFO_FILE_NAME);
            createPlaceInfoFile(pathToInfoFile, new PlaceInfo(os, browser));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public void deletePlace(String placeName, Path path) {
        Path pathToDirToBeDeleteted = path.resolve(placeName);
        try {
            Files.walk(pathToDirToBeDeleteted)
                    .sorted(Comparator.reverseOrder())
                    .map(Path::toFile)
                    .forEach(File::delete);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public void changePlaceConfiguration(Path pathToPlaces, String placeName, Os newOs, Browser newBrowser) {
        Path pathToPlace = pathToPlaces.resolve(placeName);
        Path pathToInfoFile = pathToPlace.resolve(PLACE_INFO_FILE_NAME);
        try {
            Files.deleteIfExists(pathToInfoFile);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        createPlaceInfoFile(pathToInfoFile, new PlaceInfo(newOs, newBrowser));

    }

    public void addScreenToPlace(Path pathToPlaces, String placeName) {
        Path pathToPlace = pathToPlaces.resolve(placeName);
        long newScreenNumber = 0;
        try {
            newScreenNumber = Files.list(pathToPlace).count();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Path pathToNewScreen = pathToPlace.resolve(SCREEN_FILE_NAME + newScreenNumber + SCREEN_FILE_EXT);
        try {
            Files.createFile(pathToNewScreen);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
