package homeworks.dmytro_k.hw_2023.hw_29_01_23;

import com.itextpdf.text.DocumentException;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileManagerService {
    public static void main(String[] args) throws IOException, DocumentException {

        Path path = Paths.get("src/homeworks/dmytro_k/hw_2023/hw_29_01_23/test_package");

        FileManager.createDirectory(Paths.get(String.valueOf(path),
                "destination_package"));// Какой вариант наиболее подходящий?

        FileManager.createTxt(Paths.get(String.valueOf(path), "/New file1.txt"));

        Path pathFile = Paths.get("src/homeworks/dmytro_k/hw_2023" +
                "/hw_29_01_23/test_package/New file1.txt");

        FileManager.convertToPDF(pathFile);

        FileManager.copyFile(pathFile,
                Paths.get("src/homeworks/dmytro_k/hw_2023/hw_29_01_23" +
                        "/test_package/destination_package2/New file1.txt"));

        FileManager.deleteFile(Paths.get("src/homeworks/dmytro_k/hw_2023" +
                "/hw_29_01_23/test_package/New file0.txt"));

        //File directory = new File("src/homeworks/dmytro_k/hw_2023" +
        //        "/hw_29_01_23/test_package/destination_package");

        //FileManager.deleteFolder(directory); //v1

        //FileManager.deleteFolder(Paths.get("src/homeworks/dmytro_k/hw_2023" +
          //      "/hw_29_01_23/test_package/destination_package"));

        FileManager.deleteFile_es(Paths.get("src/homeworks/dmytro_k/hw_2023" +
                "/hw_29_01_23/test_package/destination_package2"));


        FileManager.browseDirectory(Paths.get("src/homeworks/dmytro_k/hw_2023/hw_29_01_23/test_package"));

        //FileManager.rename(pathFile,
         //       Paths.get("src/homeworks/dmytro_k/hw_2023/hw_29_01_23/test_package/New file10.txt"));
    }
}
