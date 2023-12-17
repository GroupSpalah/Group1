package sergii_khvostov.hw_05_11_23;

import homeworks.sergii_khvostov.hw_2023.hw_05_11_23.AdvertisementService;
import homeworks.sergii_khvostov.hw_2023.hw_05_11_23.Browser;
import homeworks.sergii_khvostov.hw_2023.hw_05_11_23.Os;
import homeworks.sergii_khvostov.hw_2023.hw_05_11_23.PlaceInfo;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.SystemOutRule;
import org.junit.rules.TemporaryFolder;

import java.io.File;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.nio.file.*;
import java.util.Objects;
import java.util.stream.IntStream;

import static org.junit.Assert.*;

public class AdvertisementServiceTest {

    @Rule
    public SystemOutRule outRule = new SystemOutRule().enableLog();
    @Rule
    public TemporaryFolder tf = new TemporaryFolder();


    @Test
    public void shouldPlaceAdvertisement() throws IOException {
        AdvertisementService as = new AdvertisementService();

        Os os = Os.WINDOWS;
        Browser browser = Browser.CHROME;
        String content = "My content";
        String placeName = AdvertisementService.PLACE_ + 1;
        String screenNumber = AdvertisementService.SCREEN_ + 1 + AdvertisementService.EXTENSION_TXT;
        String dir = AdvertisementService.DIRECTORY;

        Path placePath = Paths.get(dir)
                .resolve(placeName).resolve(screenNumber);

        as.placeAdvertisement(os, browser, content);

        String actualContent = Files.readString(placePath);
        assertEquals(content, actualContent);

    }

    @Test
    public void shouldReplaceAdvertisement() throws IOException {
        AdvertisementService as = new AdvertisementService();

        String placeName = AdvertisementService.PLACE_ + 1;
        int screenNumber = 1;
        String newContent = "New content";
        String dir = AdvertisementService.DIRECTORY;


        Path screenFile = Paths.get(dir)
                .resolve(placeName).resolve("Screen_1.txt");


        as.replaceAdvertisement(placeName, screenNumber, newContent);

        String actualContent = Files.readString(screenFile);
        assertEquals(newContent, actualContent);
    }

    @Test
    public void shouldCheckIfNoPlaceInfoForReplaced() {
        AdvertisementService as = new AdvertisementService();
        String placeName = AdvertisementService.PLACE_ + 6;
        int screenNumber = 1;
        String newContent = "New content";

        as.replaceAdvertisement(placeName, screenNumber, newContent);

        String log = outRule.getLog();
        assertTrue(log.contains("Place " + placeName + " not found."));
    }

    @Test
    public void shouldCreateNewPlace() {
        AdvertisementService as = new AdvertisementService();

        Os os = Os.LINUX;
        Browser browser = Browser.CHROME;
        String dir = AdvertisementService.DIRECTORY;
        String newPlaceName = AdvertisementService.PLACE_ + 6;

        Path newPlacePath = Paths.get(dir).resolve(newPlaceName);

        as.createNewPlace(os, browser);

        int txtCount = Objects.requireNonNull((newPlacePath)
                .toFile()
                .listFiles(f -> f.getName().endsWith("txt")))
                .length;
        int infoCount = Objects.requireNonNull(((newPlacePath))
                .toFile()
                .listFiles(f -> f.getName().endsWith("info")))
                .length;

        assertTrue(Files.exists(newPlacePath));
        assertEquals(5, txtCount);
        assertEquals(1, infoCount);

        String log = outRule.getLog();
        assertTrue(log.contains("New place " + newPlaceName + " with 5 screens created."));

        as.deletePlace(newPlaceName);
    }

    @Test
    public void shouldDeletePlace() {
        AdvertisementService as = new AdvertisementService();
        String placeName = AdvertisementService.PLACE_ + 1;
        String dir = AdvertisementService.DIRECTORY;

        Path placeDelPath = Paths.get(dir).resolve(placeName);

        as.deletePlace(placeName);

        assertFalse(Files.exists(placeDelPath));
    }

    @Test
    public void shouldAddNewScreen() throws IOException {
        AdvertisementService as = new AdvertisementService();

        String placeName = AdvertisementService.PLACE_ + 1;

        as.addNewScreen(placeName);

        Path placePath = Paths.get(AdvertisementService.DIRECTORY, placeName);

        assertTrue(Files.exists(placePath));

        long screenCount = Files.list(placePath)
                .filter(p -> p.getFileName().toString().startsWith(AdvertisementService.SCREEN_))
                .count();

        String expectedScreenName = AdvertisementService.SCREEN_ + screenCount +
                AdvertisementService.EXTENSION_TXT;
        Path pathToScreen = placePath.resolve(expectedScreenName);

        assertTrue(Files.exists(pathToScreen));

        String log = outRule.getLog();
        assertTrue(log.contains("Screen " + screenCount + " added to " + placeName));
    }

    @Test
    public void shouldChangePlaceConfiguration() throws IOException, ClassNotFoundException {
        AdvertisementService as = new AdvertisementService();
        String placeName = AdvertisementService.PLACE_ + 1;
        PlaceInfo newPlaceInfo = new PlaceInfo(Os.WINDOWS, Browser.SAFARI);

        as.changePlaceConfiguration(placeName, newPlaceInfo);

        Path placePath = Paths.get(AdvertisementService.DIRECTORY)
                .resolve(placeName)
                .resolve(AdvertisementService.INFO_FILE);

        assertTrue(Files.exists(placePath));

        PlaceInfo savedPlaceInfo;
        try (ObjectInputStream ois = new ObjectInputStream(Files.newInputStream(placePath))) {
            savedPlaceInfo = (PlaceInfo) ois.readObject();
        }
        assertEquals(newPlaceInfo.getOs(), savedPlaceInfo.getOs());
        assertEquals(newPlaceInfo.getBrowser(), savedPlaceInfo.getBrowser());
    }
}







