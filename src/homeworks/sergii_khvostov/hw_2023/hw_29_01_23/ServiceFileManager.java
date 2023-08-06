package homeworks.sergii_khvostov.hw_2023.hw_29_01_23;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ServiceFileManager {
    public static void main(String[] args) throws IOException {
        FileManager operation = new FileManager();

        Path directory1 = Paths.get("./new1");
        Path directory2 = Paths.get("./new2");

        Path path1 = Paths.get("POP.txt");
        Path path2 = Paths.get("new2/POP1.pdf");
        Path path3 = Paths.get("new2/POP2.txt");

    }

}
