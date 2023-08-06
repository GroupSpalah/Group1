package homeworks.dmytro_k.hw_2023.hw_09_04_23.renameFiles;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

import static java.nio.file.Files.move;

public class RenameService {
    public static void main(String[] args) throws IOException {

        Path pathIn = Paths.get("./");

        RenameFiles.renameFiles(pathIn);
    }
}

class RenameFiles {

    public static void renameFiles(Path dir) throws IOException {

        Files.walkFileTree(dir, new SimpleFileVisitor<>() {

            @Override
            public FileVisitResult visitFile(Path path, BasicFileAttributes attrs) throws IOException {

                String fileName = path.toString();
                String newName = fileName.replaceFirst("y2mate\\.com - ", "");
                Path name = Paths.get(newName);

                move(path, name, StandardCopyOption.REPLACE_EXISTING);

                return FileVisitResult.CONTINUE;
            }
        });
    }
}