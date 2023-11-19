package homeworks.sergii_khvostov.hw_2023.hw_05_11_23;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;
import java.nio.file.StandardOpenOption;

public class AdvertisementService {
    private static final List<PlaceInfo> PLACES_INFO = List.of(
            new PlaceInfo(Os.WINDOWS, Browser.CHROME),
            new PlaceInfo(Os.MAC, Browser.FIREFOX),
            new PlaceInfo(Os.LINUX, Browser.SAFARI),
            new PlaceInfo(Os.UNIX, Browser.EDGE),
            new PlaceInfo(Os.SOLARIS, Browser.OPERA)
    );
    private final Map<PlaceInfo, Integer> SCREENS_PLACE_MAP = new HashMap<>();
    private final String DIRECTORY = "Advertisement";
    private static final String INFO_FILE = "info.txt";
    private final String TXT = ".txt";
    private final String SCREEN_ = "Screen_";
    private final int QUANTITY_PLACE = 5;
    private final String PLACE_ = "Place_";

    public AdvertisementService(Path path) {
        createDefaultPlaces(path);
    }

    private void createDefaultPlaces(Path path) {
        Path advertisementPath = path.resolve(DIRECTORY);
        try {
            if (!Files.exists(advertisementPath)) {
                Files.createDirectories(advertisementPath);

                PLACES_INFO.forEach(placeInfo -> {
                    int placeIndex = PLACES_INFO.indexOf(placeInfo) + 1;
                    Path pathToPlace = advertisementPath.resolve(PLACE_ + placeIndex);

                    try {
                        Files.createDirectory(pathToPlace);
                        savePlaceInfo(pathToPlace, placeInfo);
                        createScreens(pathToPlace);
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                });
            }
        } catch (IOException e) {
            throw new RuntimeException("Failed to create Advertisement directory", e);
        }
    }

    private void createScreens(Path placePath) {
        IntStream.rangeClosed(1, 5)
                .forEach(screenIndex -> {
                    String screenName = SCREEN_ + screenIndex + TXT;
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

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(infoFilePath.toFile()))) {
            oos.writeObject(placeInfo);
        } catch (IOException e) {
            throw new RuntimeException("Failed to save PlaceInfo", e);
        }
    }

    public void placeAnAdvertisementOnly(Os os, Browser browser, String advertisementContent) {
        try {
            Files.walk(Paths.get(DIRECTORY))
                    .filter(Files::isRegularFile)
                    .filter(file -> file.toString().endsWith(INFO_FILE))
                    .forEach(file -> {
                        try {
                            ObjectInputStream ois = new ObjectInputStream(
                                    new FileInputStream(file.toFile()));
                            PlaceInfo placeInfo = (PlaceInfo) ois.readObject();

                            if (placeInfo.getOs() == os && placeInfo.getBrowser() == browser) {
                                int screensPlaced = SCREENS_PLACE_MAP.getOrDefault(placeInfo, 0);

                                int screenIndex = screensPlaced + 1;
                                while (screenIndex <= QUANTITY_PLACE) {
                                    Path advertisementPath = file.getParent()
                                            .resolve(SCREEN_ + screenIndex + TXT);

                                    String fileContent = "";
                                    if (Files.exists(advertisementPath)) {
                                        fileContent = Files.readString(advertisementPath);
                                    }
                                    if (fileContent.isEmpty()) {
                                        Files.write(advertisementPath, advertisementContent.getBytes(),
                                                StandardOpenOption.CREATE);
                                        System.out.println("Advertising successfully placed on "
                                                + file.getParent().getFileName() + " at screen " +
                                                screenIndex);

                                        SCREENS_PLACE_MAP.put(placeInfo, screenIndex);
                                        break;
                                    } else {
                                        System.out.println("Screen " + screenIndex + " at "
                                                + file.getParent().getFileName() +
                                                " is already occupied.");
                                        screenIndex++;
                                    }
                                }
                                if (screenIndex > QUANTITY_PLACE) {
                                    System.out.println("All 5 screens at "
                                            + file.getParent().getFileName() + " are already occupied.");
                                }
                            }
                            ois.close();
                        } catch (IOException | ClassNotFoundException e) {
                            throw new RuntimeException(
                                    "Failed to process files or place advertisement", e);
                        }
                    });
        } catch (IOException e) {
            throw new RuntimeException("Failed to walk through directories", e);
        }
    }
}










