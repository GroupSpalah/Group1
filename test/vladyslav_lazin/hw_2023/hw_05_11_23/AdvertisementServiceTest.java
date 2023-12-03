package vladyslav_lazin.hw_2023.hw_05_11_23;

import homeworks.vladyslav_lazin.hw_2023.hw_05_11_23.AdvertisementService;
import homeworks.vladyslav_lazin.hw_2023.hw_05_11_23.Browser;
import homeworks.vladyslav_lazin.hw_2023.hw_05_11_23.Os;
import homeworks.vladyslav_lazin.hw_2023.hw_05_11_23.PlaceInfo;
import org.junit.After;
import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Comparator;
import java.util.stream.Stream;

import static org.junit.Assert.*;

public class AdvertisementServiceTest {
    private  static final Path testDir = Paths.get("./test/vladyslav_lazin/hw_2023/hw_05_11_23/places");

    @After
    public void deleteFileStructure() {
        try(Stream<Path> deletingStructureWalk = Files.walk(testDir)) {
            deletingStructureWalk
                    .sorted(Comparator.reverseOrder())
                    .map(Path::toFile)
                    .forEach(File::delete);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    @Test
    public void fileStructureShouldBeCreated() {
        AdvertisementService advertisementService = new AdvertisementService(testDir);
        try(Stream<Path> places = Files.list(testDir)) {
            assertEquals(5L, places.count());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try(Stream<Path> places = Files.list(testDir)) {
            places.forEach(innerDir -> {
                try(Stream<Path> files = Files.list(innerDir)) {
                    assertEquals(6, files.count());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            });
        } catch (IOException e) {
            throw new RuntimeException();
        }

    }
    @Test
    public void postAdvertisimentOnPlace() {
        AdvertisementService advertisementService = new AdvertisementService(testDir);
        String content = "This is new advertisement";
        advertisementService.postAdvertisimentOnPlace(testDir, Os.GNU_LINUX, Browser.FIREFOX, content);
        try(Stream<Path> places = Files.list(testDir)) {
            places
                    .forEach(currentPlace -> {
                        try(Stream<Path> files = Files.list(currentPlace)) {
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
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    @Test
    public void replaceAdvertisimentAtPlace() {
        AdvertisementService advertisementService = new AdvertisementService(testDir);
        String content = "This is the replaced content";
        String placeName = "Place_1";
        advertisementService.replaceAdvertisimentAtPlace(testDir, placeName, content);
        Path pathToReplacing = testDir.resolve(placeName);
        try(Stream<Path> files = Files.list(pathToReplacing)) {
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

    }

    @Test
    public void createNewPlace() {
        AdvertisementService advertisementService = new AdvertisementService(testDir);
        advertisementService.createNewPlace(testDir, Os.OS_X, Browser.CHROME);
        Path pathToNewPlace = testDir.resolve("Place_6");
        try {
            long filesCount = Files.list(pathToNewPlace).count();
            assertTrue(Files.exists(pathToNewPlace));
            assertEquals(6L, filesCount);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void deletePlace() throws IOException {
        AdvertisementService advertisementService = new AdvertisementService(testDir);
        String placeToBeDeleted = "Place_5";
        advertisementService.deletePlace(testDir, placeToBeDeleted);
        try(Stream<Path> places = Files.list(testDir)) {
            long placesCount = places.count();
            assertEquals(4L, placesCount);
        }
        Path pathToDeletedPlace = testDir.resolve(placeToBeDeleted);
        assertFalse(Files.exists(pathToDeletedPlace));
    }

    @Test
    public void changePlaceConfiguration() {
        AdvertisementService advertisementService = new AdvertisementService(testDir);
        String placeName = "Place_1";
        advertisementService.changePlaceConfiguration(testDir, placeName, Os.ANDROID, Browser.SAFARI);
        Path pathToChanedPlace = testDir.resolve(placeName);
        PlaceInfo writtenPlaceInfo = new PlaceInfo(Os.ANDROID, Browser.SAFARI);
        try(FileInputStream inputStream = new FileInputStream(pathToChanedPlace.resolve("place_info.dat").toFile());
            ObjectInputStream objectInputStream = new ObjectInputStream(inputStream)) {
            PlaceInfo readPlaceInfo = (PlaceInfo) objectInputStream.readObject();
            assertEquals(writtenPlaceInfo, readPlaceInfo);
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void addScreenToPlace() {
        AdvertisementService advertisementService = new AdvertisementService(testDir);
        String placeName = "Place_1";
        Path pathToPlace = testDir.resolve(placeName);
        advertisementService.addScreenToPlace(testDir, placeName);
        try(Stream<Path> files = Files.list(pathToPlace)) {
            long screensCount = files
                    .filter(file -> file.toString().endsWith(".txt"))
                    .count();
            assertEquals(6L, screensCount);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Path pathToNewScreen = pathToPlace.resolve("screen_6.txt");
        assertTrue(Files.exists(pathToNewScreen));
    }
}