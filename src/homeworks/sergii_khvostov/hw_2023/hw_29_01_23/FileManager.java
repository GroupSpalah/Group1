package homeworks.sergii_khvostov.hw_2023.hw_29_01_23;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;


public class FileManager {

    public void createFile(Path path) throws IOException {
        if (!Files.exists(path)) {
            Files.createFile(path);
        } else {
            System.out.println("File with the same name already exists");
        }
    }


    public void createDirectory(Path path) throws IOException {
        if (!Files.exists(path)) {
            Files.createDirectory(path);
        } else {
            System.out.println
                    ("Directory with the same name already exists");
        }
    }

    public void copyFile(Path path, Path newPath) throws IOException {
        Files.copy(path, newPath);
    }

    public void deleteFile(Path path) throws IOException {
        Files.delete(path);
    }


    public void deleteDirectory(Path path) throws IOException {
        Files.walkFileTree(path, new SimpleFileVisitor<>() {
            @Override
            public FileVisitResult visitFile
                    (Path file, BasicFileAttributes attrs)
                    throws IOException {
                Files.delete(file);
                return FileVisitResult.CONTINUE;
            }

            @Override
            public FileVisitResult postVisitDirectory
                    (Path dir, IOException e)
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

    public void renameFile(Path path, Path newPath) throws IOException {
        Files.move(path, newPath, StandardCopyOption.REPLACE_EXISTING);
    }

    public void renameDirectory(Path path, Path newPath) throws IOException {
        Files.move(path, newPath, StandardCopyOption.REPLACE_EXISTING);
    }

    public void readDirectory(Path path) throws IOException {
        Files.walkFileTree(path, new SimpleFileVisitor<>() {
            @Override
            public FileVisitResult visitFile
                    (Path file, BasicFileAttributes attrs)
                    throws IOException {
                Files.readAllBytes(file);
                System.out.println(file);
                return FileVisitResult.CONTINUE;
            }
        });
    }

    public void convertToPDF(Path path) throws IOException, DocumentException {
        String namePdf = path.toString().replace(".txt", ".pdf");

        Document document = new Document();

        FileOutputStream outputStream =
                new FileOutputStream((namePdf));
        PdfWriter.getInstance(document, outputStream);

        document.open();

        document.add(new Paragraph(""));

        Paragraph paragraph =
                new Paragraph(new String(Files.readAllBytes(path)));
        document.add(paragraph);

        document.close();
        outputStream.close();
    }
}








