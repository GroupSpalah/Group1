package homeworks.dmytro_k.hw_2024.hw_10_03_24;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.stream.Stream;

public class FileReader {
    private static final Path pathToFile = Path.of("Homeworks/2024/03.24/10_03_24/Story.txt");

    public static void repeatCounter(String searchWord) {
//учитывает первое слово в рядке и слова со знаками препинания после, без учета регистра
        try {
            long count = Files.lines(pathToFile)
                    .flatMap(line -> Arrays.stream(line.split("\\W+")))
                    .filter(word -> word.equalsIgnoreCase(searchWord))
                    .count();

            System.out.println("Result: " + count);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
