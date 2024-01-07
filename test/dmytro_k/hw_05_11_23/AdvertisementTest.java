package dmytro_k.hw_05_11_23;

import homeworks.dmytro_k.hw_2023.hw_05_11_23.AdvertisementService;
import homeworks.dmytro_k.hw_2023.hw_05_11_23.Browser;
import homeworks.dmytro_k.hw_2023.hw_05_11_23.Os;
import homeworks.dmytro_k.hw_2023.hw_05_11_23.PlaceInfo;
import org.junit.*;
import org.junit.contrib.java.lang.system.SystemOutRule;

import java.io.*;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.Objects;
import java.util.stream.IntStream;
import static org.junit.Assert.*;

public class AdvertisementTest {

    private static final Path PATH = Path.of("src/homeworks/dmytro_k/hw_2023/hw_05_11_23/advertisement/test");
    private static File testDir;
    private static final int DIFFERENCE = 1;
    private static final String PLACE = "/place_";

    @BeforeClass
    public static void createTestDir() {
        try {
            testDir = Files.createDirectory(PATH).toFile();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    @Rule
    public SystemOutRule outRule = new SystemOutRule().enableLog();

    //@AfterClass
    public void deleteFolder() throws IOException {

        boolean availability = Files.exists(PATH);

        if (!availability) {
            System.out.println("Such directory does not exist");
            return;
        }

        Files.walkFileTree(PATH, new SimpleFileVisitor<>() {

            @Override
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs)
                    throws IOException {
                Files.delete(file);
                return FileVisitResult.CONTINUE;
            }

            @Override
            public FileVisitResult postVisitDirectory(Path dir, IOException e)
                    throws IOException {
                if (e == null) {
                    Files.delete(dir);
                    return FileVisitResult.CONTINUE;
                } else {
                    throw e;
                }
            }
        });
    }

    @Test
    public void shouldCreateDefaultPlace() {

        Path pathToDirTest1 = Path.of(PATH + "/test_1");

        try {
            testDir = Files.createDirectory(pathToDirTest1).toFile();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        AdvertisementService as = new AdvertisementService(pathToDirTest1);

        int placeCount = Objects.requireNonNull(pathToDirTest1
                .toFile()
                .listFiles())
                .length;

        IntStream.rangeClosed(1, placeCount)
                .forEach(index -> {

                    Path pathToPlace = Path.of(pathToDirTest1 + PLACE + index);

                    int txtCount = Objects.requireNonNull(pathToPlace
                            .toFile()
                            .listFiles(f -> f.getName().endsWith(".txt")))
                            .length;

                    int infCount = Objects.requireNonNull(pathToPlace
                            .toFile()
                            .listFiles(f -> f.getName().endsWith(".inf")))
                            .length;

                    assertEquals(5, txtCount);
                    assertEquals(1, infCount);
                });

        assertEquals(5, placeCount);
    }

    @Test
    public void shouldCreateNewPlace() {

        Path pathToDirTest2 = Path.of(PATH + "/test_2");

        try {
            testDir = Files.createDirectory(pathToDirTest2).toFile();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        AdvertisementService as = new AdvertisementService(pathToDirTest2);

        int placeCount = Objects.requireNonNull(pathToDirTest2
                .toFile()
                .listFiles())
                .length;
        as.createNewPlace(pathToDirTest2, Os.WINDOWS, Browser.SAFARI);

        Path newPlacePath = Path.of(String.valueOf(pathToDirTest2), PLACE + (placeCount + DIFFERENCE));

        int txtCount = Objects.requireNonNull(newPlacePath
                .toFile()
                .listFiles(f -> f.getName().endsWith(".txt")))
                .length;

        int infCount = Objects.requireNonNull(newPlacePath
                .toFile()
                .listFiles(f -> f.getName().endsWith(".inf")))
                .length;

        assertTrue(Files.exists(newPlacePath));
        assertEquals(5, txtCount);
        assertEquals(1, infCount);
    }

    @Test
    public void shouldNotCreateNewPlace() {

        Path pathToDirTest6 = Path.of(PATH + "/test_2");

        try {
            testDir = Files.createDirectory(pathToDirTest6).toFile();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        AdvertisementService as = new AdvertisementService(pathToDirTest6);

        as.createNewPlace(pathToDirTest6, Os.I_OS, Browser.SAFARI);

        String log = outRule.getLog();

        assertTrue(log.contains("Such place already exist"));
    }

    @Test
    public void shouldCreateNewScreen() {

        Path pathToDirTest3 = Path.of(PATH + "/test_3");

         try {
             testDir = Files.createDirectory(pathToDirTest3).toFile();
         } catch (IOException e) {
             System.out.println(e.getMessage());
         }

        AdvertisementService as = new AdvertisementService(pathToDirTest3);

        String placeName = PLACE + "5";

        Path placePath = Path.of(pathToDirTest3 + placeName);

        int txtCount = Objects.requireNonNull(placePath
                .toFile()
                .listFiles(f -> f.getName().endsWith(".txt")))
                .length;

        Path screenPath = Path.of(String.valueOf(placePath), "/Screen_" + (txtCount + DIFFERENCE) + ".txt");

        as.createScreen(placePath);

        assertTrue(Files.exists(screenPath));
    }

    @Test
    public void shouldChangeAdvertisement() throws IOException {

        Path pathToDirTest4 = Path.of(PATH + "/test_4");

        try {
            testDir = Files.createDirectory(pathToDirTest4).toFile();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        AdvertisementService as = new AdvertisementService(pathToDirTest4);

        Path pathToScreen = Path.of(pathToDirTest4 + "/place_5/Screen_1.txt");

        String oldAdvertising = "111";
        Files.writeString(pathToScreen, oldAdvertising, StandardOpenOption.WRITE);

        String newAdvertising = "222";
        as.changeAdvertisement(pathToScreen, newAdvertising);

        String content = Files.readString(pathToScreen);

        assertEquals("222", content);
    }

    @Test
    public void shouldNotChangeAdvertisement() {

        Path pathToDirTest4 = Path.of(PATH + "/test_4");

        AdvertisementService as = new AdvertisementService(pathToDirTest4);

        Path pathToScreen10 = Path.of(pathToDirTest4 + "/place_1/Screen_10.txt");

        String newAdvertising = "222";
        as.changeAdvertisement(pathToScreen10, newAdvertising);

        String log = outRule.getLog();

        assertTrue(log.contains("Such screen not exist"));
    }

    @Test
    public void shouldChangePlaceConfiguration() throws IOException, ClassNotFoundException {

        Path pathToDirTest5 = Path.of(PATH + "/test_5");

        try {
            testDir = Files.createDirectory(pathToDirTest5).toFile();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } //вынести это все в бифор и передавать имя папки?

        AdvertisementService as = new AdvertisementService(pathToDirTest5);

        Path pathToPlace1 = Path.of(pathToDirTest5 + PLACE + "1");

        Path pathToPlatformInfo1 = Path.of(pathToPlace1 + "/Info.inf");

        PlaceInfo placeInfoTest = new PlaceInfo(Os.WINDOWS, Browser.SAFARI);
        as.changePlaceConfiguration(pathToPlace1, Os.WINDOWS, Browser.SAFARI);

        PlaceInfo PlaceInfo1;

        try (ObjectInputStream ois = new ObjectInputStream(Files.newInputStream(pathToPlatformInfo1))) {
            PlaceInfo1 = (PlaceInfo) ois.readObject();
        }

        assertEquals(PlaceInfo1.browser(), placeInfoTest.browser());
        assertEquals(PlaceInfo1.os(), placeInfoTest.os());
    }
}
