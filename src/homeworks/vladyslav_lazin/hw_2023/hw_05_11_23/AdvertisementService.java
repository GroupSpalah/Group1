package homeworks.vladyslav_lazin.hw_2023.hw_05_11_23;

import java.io.*;
import java.nio.file.*;
import java.util.Comparator;
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
        addPlaceInfoFiles(path);
    }

    private boolean isFileStructureNotExisists(Path path) {
        boolean result = false;
//        String absolutePath = path.toFile().getAbsolutePath();
//        Path placesPathObject = FileSystems.getDefault().getPath(absolutePath);
        try {
            result = Files.list(path).count() < 5;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return result;
    }

    private void createScreens(Path pathToPlace) {
        IntStream.rangeClosed(1, 5)
                .forEach(fileIndex -> {
                    String absolutePath = pathToPlace.toFile().getAbsolutePath();
                    Path pathToFile = Paths.get(absolutePath, "screen_" + fileIndex + ".txt");
                    try {
                        Files.createFile(pathToFile);
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                });
    }

    private void createPlaceInfoFile(Path pathToInfoFile, PlaceInfo placeInfo) {
        try (FileOutputStream fileOutputStream = new FileOutputStream(pathToInfoFile.toFile());
             ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream)) {
            objectOutputStream.writeObject(placeInfo);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
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
                    Path pathToPlace = Paths.get(absolutePath, "Place_" + dirIndex + "/");
                    if (isFileStructureNotExisists(pathToPlace)) {
                        createScreens(pathToPlace);
                    }
                });
    }

    private void addPlaceInfoFiles(Path path) {
        IntStream.rangeClosed(1, 5)
                .forEach(dirIndex -> {
                    String absolutePath = path.toFile().getAbsolutePath();
                    Path pathToInfoFile = Paths.get(absolutePath, "Place_" + dirIndex + "/place_info.dat");
                    createPlaceInfoFile(pathToInfoFile, PLACE_INFOS.get(dirIndex - 1));
                });
    }

    public void postAdvertisimentOnPlace(Path path, Os os, Browser browser, String adContent) {
        int placesCount = 0;
        try {
            placesCount = (int) Files.list(path).count();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        IntStream.rangeClosed(1, placesCount)
                .forEach(dirIndex -> {
                    PlaceInfo placeInfo = null;
                    String absolutePath = path.toFile().getAbsolutePath();
                    Path pathToPlaceInfoFile = Paths.get(absolutePath, "Place_" + dirIndex + "/" + "place_info.dat");
                    if (Files.exists(pathToPlaceInfoFile)) {
                        try (FileInputStream fileInputStream = new FileInputStream(pathToPlaceInfoFile.toFile());
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

    public void replaceAdvertisimentAtPlace(Path path, String placeName, String newAdContent) {
        String absolutePath = path.toFile().getAbsolutePath();
        Path pathToPlace = Paths.get(absolutePath, placeName);
        if (!isFileStructureNotExisists(pathToPlace)) {
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
        int placesCount;
        try {
            placesCount = (int) Files.list(path).count();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        IntStream.rangeClosed(1, placesCount)
                .forEach(dirIndex -> {

                });
    }

    public void changePlaceConfiguration() {

    }

    public void addScreenToPlace() {

    }
}
