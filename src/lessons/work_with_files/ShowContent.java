package lessons.work_with_files;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

public class ShowContent {
    public static void main(String[] args) throws IOException {
        Path path = Paths.get("./libs");

        Files.walkFileTree(path, new ShowVisitor());

    }
}

class ShowVisitor extends SimpleFileVisitor<Path> {
    @Override
    public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
        System.out.println(dir.toFile().getName());
        return FileVisitResult.CONTINUE;
    }

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        System.out.println(file.toFile().getName());
        return FileVisitResult.CONTINUE;
    }
}
