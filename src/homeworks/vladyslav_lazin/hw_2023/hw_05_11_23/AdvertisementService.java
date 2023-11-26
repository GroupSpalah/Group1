package homeworks.vladyslav_lazin.hw_2023.hw_05_11_23;

import java.io.*;
import java.nio.file.*;
import java.util.Comparator;
import java.util.List;
import java.util.stream.IntStream;

public class AdvertisementService {
    private static final String PLACE_DIR_NAME = "Place_";
    private static final String SCREEN_FILE_NAME = "screen_";
    private static final String PLACE_INFO_FILE_NAME = "place_info.dat";
    private static final String SCREEN_FILE_EXT = ".txt";



    private static final List<PlaceInfo> PLACE_INFOS = List.of(
            new PlaceInfo(Os.GNU_LINUX, Browser.FIREFOX),
            new PlaceInfo(Os.OS_X, Browser.SAFARI),
            new PlaceInfo(Os.ANDROID, Browser.CHROME),
            new PlaceInfo(Os.IOS, Browser.SAFARI),
            new PlaceInfo(Os.MS_WINDOWS, Browser.EDGE)
    );

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
        IntStream.rangeClosed(1, 5)
                .forEach(dirIndex -> {
//                    String absolutePath = pathToPlaces.toFile().getAbsolutePath();
                    Path pathToPlaceInfoFile = pathToPlaces.resolve(PLACE_DIR_NAME + dirIndex);
//                            Paths.get(absolutePath, PLACE_DIR_NAME,
//                            String.valueOf(dirIndex), PLACE_INFO_FILE_NAME);
                    createPlaceInfoFile(pathToPlaceInfoFile.resolve(PLACE_INFO_FILE_NAME), PLACE_INFOS.get(dirIndex - 1));
                });
    }
    private void createPlaceInfoFile(Path pathToPlaceInfoFile, PlaceInfo placeInfo) {
        try (FileOutputStream fileOutputStream = new FileOutputStream(pathToPlaceInfoFile.toFile());
             ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream)) {
            if (!Files.exists(pathToPlaceInfoFile)) {
                objectOutputStream.writeObject(placeInfo);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public void postAdvertisimentOnPlace(Path pathToPlaces, Os os, Browser browser, String adContent) {
        try {
            Files.newDirectoryStream(pathToPlaces)
                    .forEach(path -> {
                        Path pathToPlaceInfoFile = path.resolve(PLACE_INFO_FILE_NAME);
                        try(FileInputStream fileInputStream = new FileInputStream(pathToPlaceInfoFile.toFile());
                            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream))  {
                            PlaceInfo placeInfo = (PlaceInfo) objectInputStream.readObject();
                            if (placeInfo.getOs() == os && placeInfo.getBrowser() == browser) {
                                Files.list(path)
                                        .filter(pathToCurrentPlace -> pathToCurrentPlace.toString().endsWith(SCREEN_FILE_EXT))
                                        .forEach(pathToCurrentPlace -> {
                                            try {
                                                Files.writeString(pathToCurrentPlace, adContent, StandardOpenOption.APPEND);
                                            } catch (IOException e) {
                                                throw new RuntimeException(e);
                                            }
                                        });
                            }
                        } catch (IOException e) {
                            throw new RuntimeException();
                        } catch (ClassNotFoundException e) {
                            throw new RuntimeException(e);
                        }
                    });
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void replaceAdvertisimentAtPlace(Path path, String placeName, String newAdContent) {
        String absolutePath = path.toFile().getAbsolutePath();
        Path pathToPlace = Paths.get(absolutePath, placeName);
        IntStream.rangeClosed(1, 5)
                .forEach(fileIndex -> {
                    Path pathToFile = Paths.get(pathToPlace.toFile().getAbsolutePath(), "screen_" + fileIndex + ".txt");
                    try {
                        Files.writeString(pathToFile, newAdContent, StandardOpenOption.WRITE);
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                });
    }

    public void createNewPlace(Path path, Os os, Browser browser) {
        try {
            long filesCount = Files.list(path).count();
            String absolutePath = path.toFile().getAbsolutePath();
            long placeNumber = filesCount + 1;
            Path pathToPlace = Paths.get(absolutePath, "Place_" + placeNumber);
            Files.createDirectory(pathToPlace);
            createScreens(pathToPlace);
            Path pathToInfoFile = Paths.get(absolutePath, "Place_" + placeNumber + "/place_info.dat");
            createPlaceInfoFile(pathToInfoFile, new PlaceInfo(os, browser));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public void deletePlace(String placeName, Path path) {
        String absolutePath = path.toFile().getAbsolutePath();
        Path pathToDirToBeDeleteted = Paths.get(absolutePath, "/" + placeName);
        try {
            Files.walk(pathToDirToBeDeleteted)
                    .sorted(Comparator.reverseOrder())
                    .map(Path::toFile)
                    .forEach(File::delete);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void changePlaceConfiguration() {

    }

    public void addScreenToPlace() {

    }
}
