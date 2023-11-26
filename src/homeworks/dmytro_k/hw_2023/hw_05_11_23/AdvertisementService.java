package homeworks.dmytro_k.hw_2023.hw_05_11_23;

/*Создать приложение для связи рекламодателя и агенства по размещению рекламы.
Рекламное агенство имеет 5 площадок с экранами для размещения рекламы, каждая с разным браузером и ОС.
Каждая площадка - директория с пятью текстовыми файлами("экранами") и одним файлом, в котором сериализована
информация о данной площадке(ось, браузер).
Приложение должно позволять:
++ 1) Размещать рекламу рекламодателя только на устройствах с определенным браузером и ОС.
++2) Менять определенную рекламу на определенной площадке.
++3) Создавать новую площадку с 5 экранами.
++4) Удалять площадку со всей рекламой.
++5) Менять конфигурацию площадки с удалением всей рекламы.
++6) Добавлять экран на определенную площадку.*/

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.stream.IntStream;

public class AdvertisementService {

    private static final List<PlaceInfo> PLACE_INFO_LIST = new ArrayList<>();
    private static final int DIFFERENCE = 1; //_BETWEEN_INDEX_AND_ORDINAL
    private static int matchIndex;

    private static final Path PATH = Path.of("src/homeworks/dmytro_k/hw_2023/hw_05_11_23/advertisement");

    PlaceInfo placeInfo1 = new PlaceInfo(Os.I_OS, Browser.SAFARI);
    PlaceInfo placeInfo2 = new PlaceInfo(Os.LINUX, Browser.FIREFOX);
    PlaceInfo placeInfo3 = new PlaceInfo(Os.WINDOWS, Browser.MICROSOFT_EDGE);
    PlaceInfo placeInfo4 = new PlaceInfo(Os.MAC_OS, Browser.OPERA);
    PlaceInfo placeInfo5 = new PlaceInfo(Os.ANDROID, Browser.GOOGLE_CHROME);

    public AdvertisementService() {
        PLACE_INFO_LIST.add(placeInfo1);
        PLACE_INFO_LIST.add(placeInfo2);
        PLACE_INFO_LIST.add(placeInfo3);
        PLACE_INFO_LIST.add(placeInfo4);
        PLACE_INFO_LIST.add(placeInfo5);

        createDefaultPlaces();
    }

    private void createDefaultPlaces() {

        int content = filesOrDirectoryCount(PATH);
        if (content == 0) {
            IntStream.rangeClosed(1, 5)
                    .forEach(index -> {
                        Path pathToPlace = Path.of(PATH + "/place_" + index);

                        try {
                            Files.createDirectory(pathToPlace);
                            createDefaultScreens(pathToPlace);
                            createPlatformInfo(pathToPlace, index - DIFFERENCE);

                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                    });
        }
    }

    public void createNewPlace(Os os, Browser browser) {

        if (checkingPlaceInfo(os, browser)) {
            System.out.println("Such place already exist");
            return;
        }

        PlaceInfo inputPlaceInfo = new PlaceInfo(os, browser);
        int indexNewPlace = PLACE_INFO_LIST.size();
        PLACE_INFO_LIST.add(inputPlaceInfo);
        int index = filesOrDirectoryCount(PATH);
        try {
            Path pathToPlace = Path.of(PATH + "/place_" + (index + DIFFERENCE));

            Files.createDirectory(pathToPlace);
            createDefaultScreens(pathToPlace);
            createPlatformInfo(pathToPlace, indexNewPlace);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    private void createDefaultScreens(Path path) {
        IntStream.rangeClosed(1, 5)
                .forEach(index -> {
                    Path pathToPlace = Path.of(path + "/Screen_" + index + ".txt");

                    try {
                        Files.createFile(pathToPlace);
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                });
    }

    public void createScreen(String place) {

        Path pathToPlace = Path.of(PATH + "/" + place);

        int indexNewScreen = filesOrDirectoryCount(pathToPlace);

        Path pathToScreen = Path.of(pathToPlace + "/Screen_" + indexNewScreen + ".txt");
        try {
            Files.createFile(pathToScreen);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void changeScreen(String place, String screen, String advertising) {

        Path pathToScreen = Path.of(PATH + "/" + place + "/" + screen);

        boolean screenExists = pathToScreen.toFile().exists();

        if (!screenExists) {
            System.out.println("Such screen not exist");
            return;
        }

        try {
            Files.writeString(pathToScreen, advertising, StandardOpenOption.TRUNCATE_EXISTING);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void createPlatformInfo(Path path, int index) {

        Path pathToPlatformInfo = Path.of(path + "/Info.inf");

        try {
            FileOutputStream fileOutputStream = new FileOutputStream(pathToPlatformInfo.toFile());
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(PLACE_INFO_LIST.get(index));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private PlaceInfo readInfoFile(Path path) {
        Path pathToPlatformInfo = Path.of(path + "/Info.inf");
        try {
            FileInputStream fileInputStream = new FileInputStream(pathToPlatformInfo.toFile());
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            return (PlaceInfo) objectInputStream.readObject();
        } catch (ClassNotFoundException | IOException e) {
            throw new RuntimeException(e);
        }
    }

    private int filesOrDirectoryCount(Path path) {

        return Objects.requireNonNull(path
                .toFile()
                .listFiles())
                .length;
    }

    public void deleteFiles(Path path) {

        boolean availability = Files.exists(path);

        if (!availability) {
            System.out.println("Such directory does not exist");
            return;
        }
        Arrays
                .stream((Objects.requireNonNull(path.toFile().listFiles())))
                .forEach(File::delete);
    }

    public void deletePlace(Path path) { // как остановить или игнорировать процессы, в которых сейчас задействованы файлы?
        deleteFiles(path);
        path.toFile().delete();
    }

    public void changePlaceConfiguration(String placeName, Os inputOS, Browser inputBrowser) {

        String placeNumber = placeName.substring(placeName.length() - 1);
        int indexPlace = Integer.parseInt(placeNumber);

        Path pathToPlace = Path.of(PATH + "/" + placeName);

        deletePlace(pathToPlace);

        PlaceInfo inputPlaceInfo = new PlaceInfo(inputOS, inputBrowser);

        PLACE_INFO_LIST.add(indexPlace, inputPlaceInfo);
        try {
            Files.createDirectory(pathToPlace);
            createDefaultScreens(pathToPlace);
            createPlatformInfo(pathToPlace, indexPlace);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private boolean checkingPlaceInfo(Os os, Browser browser) {

        int placesCount = filesOrDirectoryCount(PATH);

        AtomicBoolean resultCheckingPlaceInfo = new AtomicBoolean(false);

        IntStream.rangeClosed(1, placesCount)
                .forEach(index -> {
                    Path pathToPlace = Path.of(PATH + "/place_" + index);
                    PlaceInfo defaultPlaceInfo = readInfoFile(pathToPlace);
                    if (defaultPlaceInfo.browser().equals(browser)
                            && defaultPlaceInfo.os().equals(os)) {
                        resultCheckingPlaceInfo.set(true);
                        matchIndex = index;
                    }
                });

        return resultCheckingPlaceInfo.get();
    }

    public void placeAdvertising(Os os, Browser browser, String advertising) {
        PlaceInfo inputPlaceInfo = new PlaceInfo(os, browser);

        if (checkingPlaceInfo(os, browser)) {
            Path pathToPlace = Path.of(PATH + "/place_" + matchIndex);
            try {
                writeAdvertising(pathToPlace, advertising);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } else {
            System.out.println("Such place does not exist");
        }
    }

    private void writeAdvertising(Path path, String advertising) throws IOException {

        try {
            for (Path pathFile : Files
                    .newDirectoryStream(path)) {
                if (pathFile.toString().endsWith(".txt")) {
                    boolean empty = Files.readString(pathFile).isEmpty();
                    if (empty) {
                        try {
                            Files.writeString(pathFile, advertising, StandardOpenOption.WRITE);
                            return;
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                    }
                }
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

