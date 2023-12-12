package vladyslav_lazin.hw_2023.hw_05_11_23;

import homeworks.vladyslav_lazin.hw_2023.hw_05_11_23.AdvertisementService;
import homeworks.vladyslav_lazin.hw_2023.hw_05_11_23.Browser;
import homeworks.vladyslav_lazin.hw_2023.hw_05_11_23.Os;
import homeworks.vladyslav_lazin.hw_2023.hw_05_11_23.PlaceInfo;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

import static org.junit.Assert.*;

public class AdvertisementServiceTest {
    public final File parentDir = Paths.get("./test/vladyslav_lazin/hw_2023/hw_05_11_23").toFile();
    @Rule
    public TemporaryFolder temporaryFolder = new TemporaryFolder(parentDir);

    public Path testDir;
    AdvertisementService advertisementService;
    @Before
    public void setUp() {
        testDir = temporaryFolder.getRoot().toPath();
        advertisementService = new AdvertisementService(testDir);
    }
    @Test
    public void fileStructureCreatedAndShouldBeGotTrueNumbersOfDirectoriesAndFiles() throws IOException {
            assertEquals(5L, Files.list(testDir).count());
            Files.list(testDir)
                    .forEach(innerDir -> {
                try (Stream<Path> files = Files.list(innerDir)) {
                    assertEquals(6, files.count());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            });
    }

    @Test
    public void postAdvertisimentOnPlaceAndThenShouldBeRead() throws IOException {
        String content = "This is new advertisement";
        advertisementService.postAdvertisimentOnPlace(testDir, Os.GNU_LINUX, Browser.FIREFOX, content);
        Files.list(testDir)
                .forEach(currentPlace -> {
                    try (Stream<Path> files = Files.list(currentPlace)) {
                        files
                                .forEach(file -> {
                                    try {
                                        if (file.toString().endsWith(".txt") && Files.size(file) != 0) {
                                            assertEquals(content, Files.readString(file));
                                        }
                                    } catch (IOException e) {
                                        throw new RuntimeException(e);
                                    }
                                });
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                });
    }

    @Test
    public void replaceAdvertisimentAtPlaceThenSouldBeReadNewContent() throws IOException {
        String content = "This is the replaced content";
        String placeName = "Place_1";
        advertisementService.replaceAdvertisimentAtPlace(testDir, placeName, content);
        Path pathToReplacing = testDir.resolve(placeName);
        Files.list(pathToReplacing)
                .forEach(file -> {
                    try {
                        if (file.toString().endsWith(".txt") && Files.size(file) != 0) {
                            assertEquals(content, Files.readString(file));
                        }
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                });
    }

    @Test
    public void createNewPlaceAndThenShoulBeFoundNewPlaceAndFiles() throws IOException {
        advertisementService.createNewPlace(testDir, Os.OS_X, Browser.CHROME);
        Path pathToNewPlace = testDir.resolve("Place_6");
        long filesCount = Files.list(pathToNewPlace).count();
        assertTrue(Files.exists(pathToNewPlace));
        assertEquals(6L, filesCount);
    }

    @Test
    public void placePlaceShouldBeDeletedAndThenNotFound() throws IOException {
        String placeToBeDeleted = "Place_5";
        advertisementService.deletePlace(testDir, placeToBeDeleted);
        long placesCount = Files.list(testDir).count();
        assertEquals(4L, placesCount);
        Path pathToDeletedPlace = testDir.resolve(placeToBeDeleted);
        assertFalse(Files.exists(pathToDeletedPlace));
    }

    @Test
    public void placeConfigurationSouldBeChangedAndNewConfigurationRead() {
        String placeName = "Place_1";
        advertisementService.changePlaceConfiguration(testDir, placeName, Os.ANDROID, Browser.SAFARI);
        Path pathToChanedPlace = testDir.resolve(placeName);
        PlaceInfo writtenPlaceInfo = new PlaceInfo(Os.ANDROID, Browser.SAFARI);
        try (FileInputStream inputStream = new FileInputStream(pathToChanedPlace.resolve("place_info.dat").toFile());
             ObjectInputStream objectInputStream = new ObjectInputStream(inputStream)) {
            PlaceInfo readPlaceInfo = (PlaceInfo) objectInputStream.readObject();
            assertEquals(writtenPlaceInfo, readPlaceInfo);
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void newScreenSouldBeAddedAndThenFound() throws IOException {
        String placeName = "Place_1";
        Path pathToPlace = testDir.resolve(placeName);
        advertisementService.addScreenToPlace(testDir, placeName);
        long screensCount = Files.list(pathToPlace)
                .filter(file -> file.toString().endsWith(".txt"))
                .count();
        assertEquals(6L, screensCount);
        Path pathToNewScreen = pathToPlace.resolve("screen_6.txt");
        assertTrue(Files.exists(pathToNewScreen));
    }
}