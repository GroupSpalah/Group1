package homeworks.dmytro_k.hw_2023.hw_05_11_23;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.IntStream;

public class AdvertisementService {
    private static final List<PlaceInfo> PLACE_INFOS = List.of(
            new PlaceInfo()
    );

    public AdvertisementService(Path path) {
        createDefaultPlaces(path);
    }

    private void createDefaultPlaces(Path path) {
        IntStream.rangeClosed(1, 5)
                .forEach(index -> {
                    String absolutePath = path.toFile().getAbsolutePath();

                    Path pathToPlace = Paths.get(absolutePath, "Place_" + index);

                    try {
                        Files.createDirectory(pathToPlace);
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                });
    }

    private void createDefaultScreens(Path path) {
        IntStream.rangeClosed(1, 5)
                .forEach(index -> {
                    String absolutePath = path.toFile().getAbsolutePath();

                    Path pathToPlace = Paths.get(absolutePath, "Place_" + index);

                    try {
                        Files.createDirectory(pathToPlace);
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                });
    }
}
