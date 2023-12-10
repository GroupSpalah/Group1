package sergii_khvostov.hw_05_11_23;

import homeworks.sergii_khvostov.hw_2023.hw_05_11_23.AdvertisementService;
import homeworks.sergii_khvostov.hw_2023.hw_05_11_23.Browser;
import homeworks.sergii_khvostov.hw_2023.hw_05_11_23.Os;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.SystemOutRule;
import org.junit.rules.TemporaryFolder;

import java.io.File;
import java.io.IOException;
import java.nio.file.*;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
public class AdvertisementServiceTest {

    @Rule
    public SystemOutRule outRule = new SystemOutRule().enableLog();

    @Rule
    public TemporaryFolder tf = new TemporaryFolder();

    @Test
    public void shouldCreateDefaultPlaces() throws IOException {
        File tempDir = tf.newFolder("test");
        String absolutePath = tempDir.getAbsolutePath();
        Path path = Paths.get(absolutePath);
        assertTrue(Files.exists(path));
    }

    @Test
    public void shouldPlaceAdvertisement() throws IOException {
        File tempDir = tf.newFolder("test");
        String absolutePath = tempDir.getAbsolutePath();
        Path path = Paths.get(absolutePath);

        Os os = Os.WINDOWS;
        Browser browser = Browser.CHROME;
        String content = "My content";

        AdvertisementService as = new AdvertisementService(path);
        as.placeAdvertisement(os, browser, content);

        assertTrue(Files.exists(path));
    }

    @Test
    public void shouldReplaceAdvertisement() throws IOException {
        String placeName = AdvertisementService.PLACE_ + 1;
        int screenNumber = 1;
        String newContent  = "New content";

        File tempDir = tf.newFolder("test");
        String absolutePath = tempDir.getAbsolutePath();
        Path path = Paths.get(absolutePath);
        AdvertisementService as = new AdvertisementService(path);
        AdvertisementService asSpy = spy(as);

        asSpy.replaceAdvertisement(placeName, screenNumber, newContent);

        verify(asSpy, times(1))
                .replaceAdvertisement(placeName, screenNumber, newContent);

        String log = outRule.getLog();

        assertTrue(log.contains("Advertisement successfully replaced at " +
                placeName + " on screen " + screenNumber));
    }

    @Test
    public void shouldCheckIfNoPlaceInfoForReplaced() {
        String placeName = AdvertisementService.PLACE_ + 6;
        int screenNumber = 1;
        String newContent  = "New content";

        Path tempDir = tf.getRoot().toPath();
        AdvertisementService as = new AdvertisementService(tempDir);
        AdvertisementService asSpy = spy(as);

        asSpy.replaceAdvertisement(placeName, screenNumber, newContent);

        verify(asSpy, times(1))
                .replaceAdvertisement(placeName, screenNumber, newContent);

        String log = outRule.getLog();

        assertTrue(log.contains("Place " + placeName + " not found."));

    }

    @Test
    public void shouldCreateNewPlace() throws IOException {
        File tempDir = tf.newFolder("test");
        String absolutePath = tempDir.getAbsolutePath();
        Path path = Paths.get(absolutePath);

        Os os = Os.LINUX;
        Browser browser = Browser.CHROME;

        AdvertisementService as = new AdvertisementService(path);
        as.createNewPlace(os, browser);

        assertTrue(Files.exists(path));
    }

    @Test
    public void shouldDeletePlace() throws IOException {
        File tempDir = tf.newFolder("test");
        String absolutePath = tempDir.getAbsolutePath();
        Path path = Paths.get(absolutePath);

        String placeName = AdvertisementService.PLACE_ + 5;

        AdvertisementService as = new AdvertisementService(path);
        as.deletePlace(placeName);

        Path deletedPlacePath = path.resolve(placeName);

        assertFalse(Files.exists(deletedPlacePath));
    }

    @Test
    public void shouldAddNewScreen() throws IOException {
        Path tempDir = tf.newFolder(AdvertisementService.DIRECTORY).toPath();
        AdvertisementService as = new AdvertisementService(tempDir);

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

   /* @Test
    public void shouldChangePlaceConfiguration() throws IOException {
        Path tempDir = tf.newFolder(AdvertisementService.DIRECTORY).toPath();
        AdvertisementService as = new AdvertisementService(tempDir);

        String placeName = AdvertisementService.PLACE_ + 1;
        PlaceInfo newPlaceInfo = new PlaceInfo(Os.WINDOWS, Browser.SAFARI);

        as.changePlaceConfiguration(placeName, newPlaceInfo);

        Path placePath = tempDir.resolve(placeName);
        Path infoFilePath = placePath.resolve("info.txt");

        assertTrue(Files.exists(placePath));
        assertTrue(Files.exists(infoFilePath));
    }
*/
}







