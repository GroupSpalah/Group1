package homeworks.dmytro_k.hw_2024.hw_10_03_24;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileReader {

    private static final Path pathToFile = Path.of("Homeworks/2024/10_03_24/Story.txt");

    public static void repeatCounter(String searchWord) {

        try {
            String[] words = Files.readString(pathToFile).split(" ");
            int count = 0;

            for (String word : words) {
                if (word.equals(searchWord)) {
                    count++;
                }
            }

            System.out.println("Result: " + count);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
