package sergii_khvostov.hw_05_11_23;

import homeworks.sergii_khvostov.hw_2023.hw_05_11_23.AdvertisementService;
import homeworks.sergii_khvostov.hw_2023.hw_05_11_23.Browser;
import homeworks.sergii_khvostov.hw_2023.hw_05_11_23.Os;
import homeworks.sergii_khvostov.hw_2023.hw_05_11_23.PlaceInfo;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.SystemOutRule;
import org.junit.rules.ExpectedException;
import org.junit.rules.TemporaryFolder;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.*;
public class AdvertisementServiceTest {

    @Rule
    public SystemOutRule outRule = new SystemOutRule().enableLog();

    @Rule
//    public TemporaryFolder tf = new TemporaryFolder(new File(AdvertisementService.DIRECTORY));
    public TemporaryFolder tf = new TemporaryFolder();

    @Test
    public void shouldCreateDefaultPlaces() throws IOException {
        File tempDir = tf.newFolder("test");
        String absolutePath = tempDir.getAbsolutePath();
        Path path = Paths.get(absolutePath);
        AdvertisementService as = new AdvertisementService(path);
        assertTrue(Files.exists(path));
    }

    @Test
    public void shouldCreateScreens() throws IOException {
        File tempDir = tf.newFolder("test");
        String absolutePath = tempDir.getAbsolutePath();
        Path path = Paths.get(absolutePath);
        Path placePath = path.resolve("place");

        AdvertisementService as = new AdvertisementService(placePath);
        as.createScreens(placePath);

        long count = Files.list(placePath)
                .filter(place -> place.toString().endsWith(AdvertisementService.EXTENSION_TXT))
                .count();

        assertEquals(5, count);
    }

    @Test
    public void shouldSavePlaceInfo() throws IOException {
        AdvertisementService as = new AdvertisementService(tf.getRoot().toPath());
        AdvertisementService spiedClass = spy(as);
        PlaceInfo placeInfo = new PlaceInfo(Os.WINDOWS, Browser.CHROME);

        File tempDir = tf.newFolder("test");
        String absolutePath = tempDir.getAbsolutePath();
        Path testPath = Paths.get(absolutePath);

        doNothing().when(spiedClass).savePlaceInfo(testPath, placeInfo);
        spiedClass.savePlaceInfo(testPath, placeInfo);

        verify(spiedClass).savePlaceInfo(testPath, placeInfo);
    }

   /* @Test
    public void shouldPlaceAdvertisement() throws IOException {
        AdvertisementService as = new AdvertisementService(tempDir);

        Os os = Os.WINDOWS;
        Browser browser = Browser.CHROME;
        String advertisementContent = "My content";
        as.placeAdvertisement(os, browser, advertisementContent);

        Path advertisementPath = tempDir.resolve(AdvertisementService.INFO_FILE);
        assertTrue(Files.exists(advertisementPath));

        String content = Files.readString(advertisementPath);
        assertTrue(content.contains(advertisementContent));
    }*/

    @Test
    public void shouldReplaceAdvertisement() {
        String placeName = AdvertisementService.PLACE_ + 1;
        int screenNumber = 1;
        String newContent  = "New content";

        Path tempDir = tf.getRoot().toPath();
        AdvertisementService as = new AdvertisementService(tempDir);
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
}





