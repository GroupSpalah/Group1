package lessons.work_with_files;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class LearnDirectoryStream {
    public static void main(String[] args) throws IOException {
        Path pathToDir = Paths.get("./Stream");

   /*     Files
                .newDirectoryStream(pathToDir)
                .forEach(path -> System.out.println(path));*/

        /*Files
                .newDirectoryStream(pathToDir)
                .forEach(path -> {

                    try {
                        Files.newDirectoryStream(path)
                                .forEach();
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                    try {
                        Files.deleteIfExists(path);
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                });
*/
    }
}
