package homeworks.dmytro_k.hw_2023.hw_29_01_23;

/*Создать приложение файловый менеджер.
Приложение должно позволять:
++1) Создавать текстовые файлы и директории
++2) Конвертацию текстовых файлов в PDF файлы с помощью библиотеки
iText(http://howtodoinjava.com/apache-commons/create-pdf-files-in-java-itext-tutorial/#itext_overview)
(https://mkyong.com/java/itext-read-and-write-pdf-in-java/ - чтение pdf файлов (для тестов))
++3) Копировать файлы из одной директории в другую, если такой файл уже существует - перезатирать его, copy
++4) Удалять директории и файлы
++5) Переименовывать директории и файлы, move
++6) Просматривать содержимое директории

Использовать class Files*/

import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

import static java.nio.file.Files.*;

public class FileManager {

    public static void createTxt(Path path) throws IOException {//++

        boolean availability = Files.exists(path);

        if (availability) {
            System.out.println("Such file already exists");
            return;
        }

        Files.createFile(path);
    }

    public static void createDirectory(Path path) throws IOException {//++

        boolean availability = Files.exists(path);

        if (availability) {
            System.out.println("Such directory already exists");
            return;
        }

        Files.createDirectory(path);
    }

    public static void copyFile(Path pathIn, Path pathOut) throws IOException {//++

        boolean availabilityIn = Files.exists(pathIn);

        if (!availabilityIn) {
            System.out.println("Such file does not exist");
            return;
        }

        Files.copy(pathIn, pathOut, StandardCopyOption.REPLACE_EXISTING);
    }

    public static void convertToPDF(Path path) {//++

        boolean availability = Files.exists(path);

        if (!availability) {
            System.out.println("Such file does not exist");
            return;
        }

        String namePdf = path.toString().replace(".txt", ".pdf");

        Document document = new Document();

        try {
            FileOutputStream outputStream = new FileOutputStream(namePdf);
            PdfWriter writer = PdfWriter.getInstance(document, outputStream);
            document.open();
            document.add(new Chunk(""));
            Paragraph content = new Paragraph(readString(path));
            document.add(content);
            document.close();
            writer.close();
        } catch (DocumentException | FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void deleteFile(Path path) throws IOException {//++

        boolean availability = Files.exists(path);

        if (!availability) {
            System.out.println("Such file does not exist");
            return;
        }

        delete(path);
    }

    public static void deleteFile_es(Path path) throws IOException {//++

        boolean availability = Files.exists(path);

        if (!availability) {
            System.out.println("Such file does not exist");
            return;
        }

        boolean directory = isDirectory(path);

        if (directory) {
            Files.walkFileTree(path, new SimpleFileVisitor<>() {
                @Override
                public FileVisitResult visitFile(Path file, BasicFileAttributes attrs)
                        throws IOException {
                    Files.delete(file);
                    return FileVisitResult.CONTINUE;
                }
            });
            return;
        }

        delete(path);
    }

    public static void deleteFolder(Path dir) throws IOException {// v3

        boolean availability = Files.exists(dir);

        if (!availability) {
            System.out.println("Such directory does not exist");
            return;
        }

        Files.walkFileTree(dir, new SimpleFileVisitor<>() {

            @Override
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs)
                    throws IOException {
                Files.delete(file);
                return FileVisitResult.CONTINUE;
            }

            @Override
            public FileVisitResult postVisitDirectory(Path dir, IOException e)
                    throws IOException {
                if (e == null) {
                    Files.delete(dir);
                    return FileVisitResult.CONTINUE;
                } else {
                    throw e;
                }
            }
        });
    }

    public static void rename(Path name, Path newName) throws IOException {

        boolean availabilityIn = Files.exists(name);

        if (!availabilityIn) {
            System.out.println("Such file or directory does not exist");
            return;
        }

        move(name, newName, StandardCopyOption.REPLACE_EXISTING);
    }

    public static void browseDirectory(Path dir) throws IOException {

        boolean availability = Files.exists(dir);

        if (!availability) {
            System.out.println("Such directory does not exist");
            return;
        }

        Files.walkFileTree(dir, new SimpleFileVisitor<>() {
            @Override
            public FileVisitResult preVisitDirectory(Path path, BasicFileAttributes attrs) {
                System.out.println(path.getFileName() + " (directory)");
                return FileVisitResult.CONTINUE;
            }

            @Override
            public FileVisitResult visitFile(Path path, BasicFileAttributes attrs) {
                System.out.println(path.getFileName() + " (file)");
                return FileVisitResult.CONTINUE;
            }
        });
    }

    /*    public static void deleteFolder(File directory) throws IOException {// v1

        boolean availability = Files.exists(directory.toPath());

        if (!availability) {
            System.out.println("such directory does not exist");
            return;
        }

        for (File file : Objects.requireNonNull(directory.listFiles())) {
            if (file.isFile()) {
                file.delete();
            }
        }
        directory.delete();
    }*/

/*    public static void deleteFolder(Path path) throws IOException {// v2

        boolean availability = Files.exists(path);

        if (!availability) {
            System.out.println("such folder does not exist");
            return;
        }

        File[] files = path.toFile().listFiles();

        if (files == null) {
            delete(path);
            System.out.println(path.toFile().getName() + " deleted");
            return;
        }

        for (File file : files) {
            file.delete();
            System.out.println(file.getName() + " deleted");
        }

        {
            delete(path);
            System.out.println(path.toFile().getName() + " deleted");
        }
    }*/
}
