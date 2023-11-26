package homeworks.vladyslav_lazin.hw_2023.hw_05_11_23;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class LearnNewDirectoryStream {
    public static void main(String[] args) throws IOException {
        Path pathToDir = Paths.get("./src/homeworks/vladyslav_lazin/hw_2023/hw_05_11_23//stream");
        Files.newDirectoryStream(pathToDir)
                .forEach(path -> {
                    System.out.println(path);
                });
        Files.walk(pathToDir)
                .filter(Files::isDirectory)
                .forEach(path -> {
                    Path creatingFilePath = path.resolve("readme.txt");
                    try {
                        Files.createFile(creatingFilePath);
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                });
    }
}
