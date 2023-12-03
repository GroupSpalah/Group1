package dmytro_k.hw_05_11_23;

import homeworks.dmytro_k.hw_2023.hw_05_11_23.AdvertisementService;
import homeworks.dmytro_k.hw_2023.hw_05_11_23.Browser;
import homeworks.dmytro_k.hw_2023.hw_05_11_23.Os;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.SystemOutRule;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Objects;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class AdvertisementTest {

    private static final Path PATH = Path.of("src/homeworks/dmytro_k/hw_2023/hw_05_11_23/advertisement");
    private static final int DIFFERENCE = 1;

    AdvertisementService advertisementService = new AdvertisementService();

    @Rule
    public SystemOutRule outRule = new SystemOutRule().enableLog();

    @BeforeClass
    public static void createDir() {

    }

    @AfterClass
    public static void deleteDir() {
/*        try {
            Files.newDirectoryStream(PATH)
                    .forEach(file -> {
                        try {
                            Files.newDirectoryStream(file)
                                    .forEach(f-> {
                                try {
                                    Files.deleteIfExists(f);
                                } catch (IOException e) {
                                    throw new RuntimeException(e);
                                }
                            });
                            Files.deleteIfExists(file);
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                    });
        } catch (IOException e) {
            throw new RuntimeException(e);
        }*/
    }


    @Test
    public void shouldCreateNewPlace() {

        int placeCount = Objects.requireNonNull(PATH
                .toFile()
                .listFiles())
                .length;

        Path directoryPath = Path.of(String.valueOf(PATH), "place_" + (placeCount + DIFFERENCE));

        advertisementService.createNewPlace(Os.LINUX, Browser.SAFARI);

        int txtCount = Objects.requireNonNull(directoryPath
                .toFile()
                .listFiles(f -> f.getName().endsWith(".txt")))
                .length;

        int infCount = Objects.requireNonNull(directoryPath
                .toFile()
                .listFiles(f -> f.getName().endsWith(".inf")))
                .length;

        assertTrue(Files.exists(directoryPath));
        assertEquals(txtCount, 5);
        assertEquals(infCount, 1);
    }

    @Test
    public void shouldCreateNewScreen() throws IOException {

        String place = "place_1";

        Path directoryPath = Path.of(String.valueOf(PATH), place);

        int txtCount = Objects.requireNonNull(directoryPath
                .toFile()
                .listFiles(f -> f.getName().endsWith(".txt")))
                .length;

        Path screenPath = Path.of(String.valueOf(PATH), place, "/Screen_" + (txtCount + DIFFERENCE) + ".txt");

        advertisementService.createScreen(place);

        assertTrue(Files.exists(screenPath));

        Files.delete(screenPath);
    }

    @Test
    public void shouldNotCreateNewScreen() {


    }
}
