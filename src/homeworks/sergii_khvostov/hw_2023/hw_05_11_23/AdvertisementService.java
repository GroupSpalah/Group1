package homeworks.sergii_khvostov.hw_2023.hw_05_11_23;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class AdvertisementService {
    private static List<PlaceInfo> PLACES_INFO = new ArrayList<>(List.of(
            new PlaceInfo(Os.WINDOWS, Browser.CHROME),
            new PlaceInfo(Os.MAC, Browser.FIREFOX),
            new PlaceInfo(Os.LINUX, Browser.SAFARI),
            new PlaceInfo(Os.UNIX, Browser.EDGE),
            new PlaceInfo(Os.SOLARIS, Browser.OPERA)
    ));
    public static final String DIRECTORY = "Advertisement";
    public static final String INFO_FILE = "data.info";
    public static final String EXTENSION_TXT = ".txt";
    public static final String SCREEN_ = "Screen_";
    public static final String PLACE_ = "Place_";

    public AdvertisementService(Path path) {
        createDefaultPlaces(path);
    }
    public AdvertisementService() {}

    private void createDefaultPlaces(Path path) {
        Path advertisementPath = path.resolve(DIRECTORY);

        try {
            if (!Files.exists(advertisementPath)) {
                Files.createDirectories(advertisementPath);

                PLACES_INFO
                        .forEach(placeInfo -> {
                            int placeIndex = PLACES_INFO.indexOf(placeInfo) + 1;
                            Path pathToPlace = advertisementPath.resolve(PLACE_ + placeIndex);

                            try {
                                Files.createDirectory(pathToPlace);
                                savePlaceInfo(pathToPlace, placeInfo);
                                createScreens(pathToPlace);
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        });
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void createScreens(Path placePath) {
        IntStream.rangeClosed(1, 5)
                .forEach(screenIndex -> {
                    String screenName = SCREEN_ + screenIndex + EXTENSION_TXT;
                    Path pathToScreen = placePath.resolve(screenName);

                    try {
                        Files.createFile(pathToScreen);
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                });
    }

    private void savePlaceInfo(Path path, PlaceInfo placeInfo) {
        Path infoFilePath = path.resolve(INFO_FILE);
        writeInFile(placeInfo, infoFilePath);
    }

    public void placeAdvertisement(Os os, Browser browser, String advertisementContent) {
        try {
            Path directoryPath = Paths.get(DIRECTORY);
            try (DirectoryStream<Path> directoryStream = Files.newDirectoryStream(directoryPath)) {
                for (Path placePath : directoryStream) {
                    try (ObjectInputStream ois = new ObjectInputStream(
                            new FileInputStream(placePath.resolve(INFO_FILE).toFile()))) {

                        PlaceInfo placeInfo = (PlaceInfo) ois.readObject();

                        if (placeInfo.getOs().equals(os) && placeInfo.getBrowser().equals(browser)) {
                            for (int screenIndex = 1; ; screenIndex++) {
                                Path advertisementPath = placePath.resolve(SCREEN_ +
                                        screenIndex + EXTENSION_TXT);

                                String fileContent = Files.exists(advertisementPath)
                                        ? Files.readString(advertisementPath)
                                        : "";

                                if (fileContent.isEmpty()) {
                                    Files.writeString(advertisementPath, advertisementContent);
                                    System.out.println("Advertising successfully placed on "
                                            + placePath.getFileName() + " at screen " + screenIndex);
                                    return;
                                } else {
                                    System.out.println("Screen " + screenIndex + " at "
                                            + placePath.getFileName() + " is already occupied.");
                                }
                            }
                        }
                    } catch (IOException | ClassNotFoundException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void replaceAdvertisement(String placeName, int screenNumber, String newContent) {
        Path advertisementDirectory = Paths.get(DIRECTORY);
        String screenFileName = SCREEN_ + screenNumber + EXTENSION_TXT;

        try (DirectoryStream<Path> directoryStream = Files.newDirectoryStream(advertisementDirectory)) {
            for (Path placePath : directoryStream) {
                String currentPlaceName = placePath.getFileName().toString();
                if (currentPlaceName.equals(placeName)) {
                    Path screenPath = placePath.resolve(screenFileName);

                    try {
                        Files.writeString(screenPath, newContent);
                        System.out.println("Advertisement successfully replaced at " +
                                placeName + " on screen " + screenNumber);
                    } catch (IOException e) {
                        System.out.println("Failed to replace advertisement at " + placeName +
                                " on screen " + screenNumber);
                    }
                    return;
                }
            }
            System.out.println("Place " + placeName + " not found.");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void createNewPlace(Os os, Browser browser) {
        PlaceInfo newPlaceInfo = new PlaceInfo(os, browser);
        PLACES_INFO.add(newPlaceInfo);

        Path advertisementDirectory = Paths.get(DIRECTORY);
        String newPlaceName = PLACE_ + PLACES_INFO.size();
        Path newPlacePath = advertisementDirectory.resolve(newPlaceName);

        try {
            Files.createDirectory(newPlacePath);
            createScreens(newPlacePath);

            savePlaceInfo(newPlacePath, newPlaceInfo);
            System.out.println("New place " + newPlaceName + " with 5 screens created.");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void deletePlace(String placeName) {
        Path placePath = Paths.get(DIRECTORY, placeName);
        try {
            Files.walkFileTree(placePath, new SimpleFileVisitor<>() {
                @Override
                public FileVisitResult visitFile(Path file, BasicFileAttributes attrs)
                        throws IOException {
                    Files.delete(file);
                    return FileVisitResult.CONTINUE;
                }

                @Override
                public FileVisitResult postVisitDirectory(Path dir, IOException exc)
                        throws IOException {
                    Files.delete(dir);
                    return FileVisitResult.CONTINUE;
                }
            });
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void addNewScreen(String placeName) {
        Path placePath = Paths.get(DIRECTORY, placeName);
        int screensCount = 0;
        try (DirectoryStream<Path> directoryStream = Files.newDirectoryStream(placePath)) {
            for (Path ignored : directoryStream) {
                screensCount++;
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        String screenName = SCREEN_ + screensCount + EXTENSION_TXT;
        Path pathToScreen = placePath.resolve(screenName);

        try {
            Files.createFile(pathToScreen);
            System.out.println("Screen " + screensCount + " added to " + placeName);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void changePlaceConfiguration(String placeName, PlaceInfo newPlaceInfo) {
        Path placePath = Paths.get(DIRECTORY, placeName);
        try (DirectoryStream<Path> stream = Files.newDirectoryStream(placePath)) {
            for (Path screen : stream) {
                Files.writeString(screen, "", StandardCharsets.UTF_8);
            }

            Path infoFilePath = placePath.resolve(INFO_FILE);
            writeInFile(newPlaceInfo, infoFilePath);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void writeInFile(Object object, Path path) {
        try (ObjectOutputStream oos = new ObjectOutputStream
                (new FileOutputStream(path.toFile()))) {
            oos.writeObject(object);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}










