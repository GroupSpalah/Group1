package homeworks.dmytro_k.hw_2023.hw_05_11_23;

/*Создать приложение для связи рекламодателя и агентства по размещению рекламы.
Рекламное агентство имеет 5 площадок с экранами для размещения рекламы, каждая с разным браузером и ОС.
Каждая площадка - директория с пятью текстовыми файлами("экранами") и одним файлом, в котором сериализована
информация о данной площадке(ось, браузер).
Приложение должно позволять:
++ 1) Размещать рекламу рекламодателя только на устройствах с определенным браузером и ОС.
++2) Менять определенную рекламу на определенной площадке.
++3) Создавать новую площадку с 5 экранами.
++4) Удалять площадку со всей рекламой.
++5) Менять конфигурацию площадки с удалением всей рекламы.
++6) Добавлять экран на определенную площадку.*/

import javax.swing.*;
import java.io.*;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.*;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public class AdvertisementService {

    private static final List<PlaceInfo> PLACE_INFO_LIST = new ArrayList<>(List.of(
            new PlaceInfo(Os.I_OS, Browser.SAFARI),
            new PlaceInfo(Os.LINUX, Browser.FIREFOX),
            new PlaceInfo(Os.WINDOWS, Browser.MICROSOFT_EDGE),
            new PlaceInfo(Os.MAC_OS, Browser.OPERA),
            new PlaceInfo(Os.ANDROID, Browser.GOOGLE_CHROME)
    ));
    private static final int DIFFERENCE = 1;
    private static int matchIndex;
    private static final String PLACE = "/place_";
    private static final String TXT = ".txt";
    private static final String SCREEN = "/Screen_";
    private static final String SLASH = "/";
    private static final String INFO_FILE = "/Info.inf";
    private static final Path PATH_TO_ADVERTISEMENT
            = Path.of("src/homeworks/dmytro_k/hw_2023/hw_05_11_23/advertisement");//передавать в метод

    public AdvertisementService(Path path) {
        createDefaultPlaces(path);
    }
    public AdvertisementService() {

    }


    private void createDefaultPlaces(Path pathToAdvertisement) {

        int content = filesOrDirectoryCount(pathToAdvertisement);
        if (content == 0) {
            IntStream.rangeClosed(1, 5)
                    .forEach(index -> {

                        Path pathToPlace = Path.of(pathToAdvertisement + PLACE + index);

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


    public void createNewPlace(Path pathToAdvertisement, Os os, Browser browser) {

        if (checkingPlaceInfo(pathToAdvertisement, os, browser)) {
            System.out.println("Such place already exist");
            return;
        }

        PlaceInfo inputPlaceInfo = new PlaceInfo(os, browser);
        int indexNewPlace = PLACE_INFO_LIST.size();
        PLACE_INFO_LIST.add(inputPlaceInfo);
        int index = filesOrDirectoryCount(pathToAdvertisement);
        try {
            Path pathToPlace = Path.of(pathToAdvertisement + PLACE + (index + DIFFERENCE));

            Files.createDirectory(pathToPlace);
            createDefaultScreens(pathToPlace);
            createPlatformInfo(pathToPlace, indexNewPlace);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    private void createDefaultScreens(Path pathToAdvertisement) {
        IntStream.rangeClosed(1, 5)
                .forEach(index -> {
                    Path pathToPlace = Path.of(pathToAdvertisement + SCREEN + index + TXT);
                    try {
                        Files.createFile(pathToPlace);
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                });
    }

    public void createScreen(Path pathToPlace) {

        int indexNewScreen = filesOrDirectoryCount(pathToPlace);

        Path pathToScreen = Path.of(pathToPlace + SCREEN + indexNewScreen + TXT);
        try {
            Files.createFile(pathToScreen);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void changeAdvertisement(Path pathToScreen, String advertising) {

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

        Path pathToPlatformInfo = Path.of(path + INFO_FILE);

        try {
            FileOutputStream fileOutputStream = new FileOutputStream(pathToPlatformInfo.toFile());
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(PLACE_INFO_LIST.get(index));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private PlaceInfo readInfoFile(Path path) {
        Path pathToPlatformInfo = Path.of(path + INFO_FILE);
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

    private void deleteFiles(Path pathToDirectory) {

        boolean availability = Files.exists(pathToDirectory);

        if (!availability) {
            System.out.println("Such directory does not exist");
            return;
        }
        try {
            Files.newDirectoryStream(pathToDirectory)
                    .forEach(file -> {
                        try {
                            Files.deleteIfExists(file);
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                    });
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void deletePlace(Path pathToDirectory) {
        deleteFiles(pathToDirectory);
        try {
            Files.delete(pathToDirectory);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void changePlaceConfiguration(Path pathToPlace, Os inputOS, Browser inputBrowser) {

        String placeName = pathToPlace.getFileName().toString();//test

        boolean availability = Files.exists(pathToPlace);

        if (!availability) {
            System.out.println("Such place does not exist");
            return;
        }

        deletePlace(pathToPlace);

        String placeNumber = placeName.substring(placeName.length() - 1);
        int indexPlace = Integer.parseInt(placeNumber);

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

    private boolean checkingPlaceInfo(Path pathToAdvertisement, Os os, Browser browser) {

        int placesCount = filesOrDirectoryCount(pathToAdvertisement);

        AtomicBoolean resultCheckingPlaceInfo = new AtomicBoolean(false);

        IntStream.rangeClosed(1, placesCount)
                .forEach(index -> {
                    Path pathToPlace = Path.of(pathToAdvertisement + PLACE + index);
                    PlaceInfo defaultPlaceInfo = readInfoFile(pathToPlace);
                    if (defaultPlaceInfo.browser().equals(browser)
                            && defaultPlaceInfo.os().equals(os)) {
                        resultCheckingPlaceInfo.set(true);
                        matchIndex = index;
                    }
                });

        return resultCheckingPlaceInfo.get();
    }

    public void placeAdvertising(Path pathToAdvertisement, Os os, Browser browser, String advertising) {

        if (checkingPlaceInfo(pathToAdvertisement, os, browser)) {//test
            Path pathToPlace = Path.of(pathToAdvertisement + PLACE + matchIndex);
            try {
                writeAdvertising61(pathToPlace, advertising);
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
                if (pathFile.toString().endsWith(TXT)) {
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

    private void writeAdvertising2(Path path, String advertising) throws IOException {

        /*
        forEach Link icon
        void forEach(Consumer<? super T> action)
        Performs an action for each element of this stream.
        This is a terminal operation.
        The behavior of this operation is explicitly nondeterministic.
        For parallel stream pipelines, this operation does not guarantee to respect the encounter order of the stream,
        as doing so would sacrifice the benefit of parallelism. For any given element, the action may be performed at
        whatever time and in whatever thread the library chooses. If the action accesses shared state, it is responsible
        for providing the required synchronization.

        Выполняет действие для каждого элемента этого потока. Это терминальная операция.
        Поведение этой операции явно НЕДЕТЕРМИНИРОВАНО. Для конвейеров параллельных потоков эта операция не гарантирует
        соблюдения порядка встреч потока, поскольку это приведет к ухудшению преимуществ параллелизма. Для любого
        данного элемента действие может быть выполнено в любое время и в любом потоке, выбранном библиотекой.
        Если действие обращается к общему состоянию, оно отвечает за обеспечение необходимой синхронизации.
        Parameters:
            action - a non-interfering action to perform on the elements*/

        DirectoryStream.Filter<Path> txtFilter = p -> p.toString().endsWith(TXT);

        Files
                .newDirectoryStream(path, txtFilter)
                .forEach(path1 -> {
                    try {
                        boolean empty = Files.readString(path1).isEmpty();
                        if (empty) {
                            Files.writeString(path1, advertising, StandardOpenOption.WRITE);
                            //return;// return не работает из-за указанных выше свойств метода.
                            wait(); // не работает, пишет дальше потому что поток 1?
                        }
                    } catch (IOException | InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                });
    }


    private void writeAdvertising5(Path path, String advertising) throws IOException {

        DirectoryStream.Filter<Path> txtFilter = p -> p.toString().endsWith(TXT);

        DirectoryStream<Path> files = Files.newDirectoryStream(path, txtFilter);

        Stream<Path> stream = StreamSupport.stream(files.spliterator(), false);

        stream.findFirst()//презаписывает 1-й файл и не идет дальше.
                .ifPresent(path1 -> {
                    try {
                        Files.writeString(path1, advertising, StandardOpenOption.WRITE);
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                });

        files.close();
    }


    private void writeAdvertising61(Path path, String advertising) throws IOException {//вариант 6.1

        Stream<Path> files = Files.walk(path);
        files = files.filter(f -> f.toString().endsWith(TXT));
        Optional<Path> emptyFile = files.filter(f -> {
            try {
                return Files.readString(f).isEmpty();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }).findAny();
        emptyFile.ifPresent(f -> {
            try {
                Files.write(f, Collections.singletonList(advertising));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
    }

    private void writeAdvertising62(Path path, String advertising) throws IOException {//вариант 6.2
        Stream<Path> files = Files.walk(path);
        files = files.filter(f -> f.toString().endsWith(TXT));
        Optional<Path> emptyFile = files.filter(f -> {
            try {
                return Files.readString(f).isEmpty();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }).findAny();

        emptyFile.ifPresent(f -> {
            try {
                Files.writeString(f, advertising, StandardOpenOption.WRITE);//другие параметры для записи(нужен тест)
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
    }

    private void writeAdvertising4(Path path, String advertising) throws IOException {//пишет инфу во все пустые файлы

        try {
            DirectoryStream.Filter<Path> filter = p -> p.toString().endsWith(TXT);
            DirectoryStream<Path> files = Files.newDirectoryStream(path, filter);
            files.forEach(f -> {
                try {
                    Files.writeString(f, advertising, StandardOpenOption.WRITE);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            });
            files.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

