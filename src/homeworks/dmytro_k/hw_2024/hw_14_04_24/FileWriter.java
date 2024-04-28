package homeworks.dmytro_k.hw_2024.hw_14_04_24;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.time.LocalDateTime;

public class FileWriter {

    private static final String PATH_TO_FILE =
            "src/homeworks/dmytro_k/hw_2024/hw_14_04_24/factory_package/product name + worker name.txt";

    public static void writeToFile(String content) {
        try {
            Files.write(Paths.get(PATH_TO_FILE),
                    ("Current stage: " + content + " " + LocalDateTime.now() + "\n").getBytes(),
                    StandardOpenOption.CREATE, StandardOpenOption.APPEND);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
