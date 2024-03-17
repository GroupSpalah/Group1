package lessons.work_with_files;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;


public class WorkWithFiles {
    public static void main(String[] args) throws IOException {

        Path path = Paths.get("./Poem.txt");

//        Files.createFile(path);

        String hello = "\nWorld";
//        Files.write(path, hello.getBytes(), StandardOpenOption.CREATE, StandardOpenOption.APPEND);

        byte[] bytes = Files.readAllBytes(path);

        String text = new String(bytes);

        System.out.println(text);
    }
}
