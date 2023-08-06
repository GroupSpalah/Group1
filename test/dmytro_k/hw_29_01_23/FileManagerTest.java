package dmytro_k.hw_29_01_23;

import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.parser.PdfTextExtractor;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.SystemOutRule;
import org.junit.rules.TemporaryFolder;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static homeworks.dmytro_k.hw_2023.hw_29_01_23.FileManager.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class FileManagerTest {

    @Rule
    public TemporaryFolder tf = new TemporaryFolder();

    @Rule
    public SystemOutRule outRule = new SystemOutRule().enableLog();

    @Test
    public void shouldCreateTxt() throws IOException {

        File tempFolder = tf.newFolder();
        String folderPath = tempFolder.getAbsolutePath();
        Path filePath = Paths.get(folderPath, "One.txt");

        createTxt(filePath);

        assertTrue(Files.exists(filePath));
    }

    @Test
    public void shouldNotCreateTxt() throws IOException {

        File tempFile = tf.newFile("New file.txt");
        String absolutePath = tempFile.getAbsolutePath();
        Path path = Paths.get(absolutePath);

        createTxt(path);

        String log = outRule.getLog();

        assertTrue(log.contains("Such file already exists"));
    }

    @Test
    public void shouldCreateDirectory() throws IOException {

        File tempFolder = tf.newFolder("New folder");
        String absolutePath = tempFolder.getAbsolutePath();
        Path directoryPath = Paths.get(absolutePath, "Folder 1");

        createDirectory(directoryPath);

        assertTrue(Files.exists(directoryPath));
    }

    @Test
    public void shouldNotCreateDirectory() throws IOException {

        File tempFolder = tf.newFolder("New folder");
        String absolutePath = tempFolder.getAbsolutePath();
        Path directoryPath = Paths.get(absolutePath);

        createDirectory(directoryPath);

        String log = outRule.getLog();

        assertTrue(log.contains("Such directory already exists"));
    }

    @Test
    public void shouldNotCopyFile() throws IOException {

        File tempFolder = tf.newFolder("New folder");
        File tempFolder1 = tf.newFolder("New folder 1");
        String absolutePath = tempFolder.getAbsolutePath();
        String absolutePath1 = tempFolder1.getAbsolutePath();

        Path pathFileIn = Paths.get(absolutePath, "new file");
        Path pathFileOut = Paths.get(absolutePath1, "new file");

        copyFile(pathFileIn, pathFileOut);

        String log = outRule.getLog();

        assertTrue(log.contains("Such file does not exist"));
    }

    @Test
    public void shouldCopyFile() throws IOException {

        File tempFolder = tf.newFolder("New folder");
        String tempFolderIn = tempFolder.getAbsolutePath();
        File tempFolder2 = tf.newFolder("New folder2");
        String tempFolderOut = tempFolder2.getAbsolutePath();

        Path pathFileIn = Paths.get(tempFolderIn, "new file.txt");
        Files.createFile(pathFileIn);

        Path pathFileOut = Paths.get(tempFolderOut, "new file.txt");

        copyFile(pathFileIn, pathFileOut);

        Files.exists(pathFileOut);

        String contentIn = Files.readString(pathFileIn);
        String contentOut = Files.readString(pathFileOut);

        assertEquals(contentIn, contentOut);
    }

    @Test
    public void shouldDeleteFile() throws IOException {

        File tempFolder = tf.newFolder("New folder");
        String absolutePath = tempFolder.getAbsolutePath();
        Path filePath = Paths.get(absolutePath, "new file.txt");
        Files.createFile(filePath);

        deleteFile(filePath);

        assertTrue(Files.notExists(filePath));
    }

    @Test
    public void shouldNotDeleteFile() throws IOException {

        File tempFolder = tf.newFolder("New folder");
        String absolutePath = tempFolder.getAbsolutePath();
        Path filePath = Paths.get(absolutePath, "new file");

        deleteFile(filePath);

        String log = outRule.getLog();

        assertTrue(log.contains("Such file does not exist"));
    }

    @Test
    public void shouldDeleteDirectoryWithOutFiles() throws IOException {

        File tempFolder = tf.newFolder("New folder");
        String absolutePath = tempFolder.getAbsolutePath();
        Path directoryPath = Paths.get(absolutePath, "Folder 1");

        createDirectory(directoryPath);

        deleteFolder(directoryPath);

        assertTrue(Files.notExists(directoryPath));
    }

    @Test
    public void shouldDeleteDirectoryWithFiles() throws IOException {

        File tempFolder = tf.newFolder("New folder");
        String absolutePath = tempFolder.getAbsolutePath();
        Path directoryPath = Paths.get(absolutePath, "Folder 1");

        createDirectory(directoryPath);

        Path filePath = Paths.get(directoryPath.toString(), "file 1.txt");

        createTxt(filePath);

        deleteFolder(directoryPath);

        assertTrue(Files.notExists(directoryPath));
    }

    @Test
    public void shouldNotDeleteDirectory() throws IOException {

        File tempFolder = tf.newFolder("New folder");
        String absolutePath = tempFolder.getAbsolutePath();
        Path directoryPath = Paths.get(absolutePath, "Folder 1");

        deleteFolder(directoryPath);

        String log = outRule.getLog();

        Assert.assertTrue(log.contains("Such directory does not exist"));
    }

    @Test
    public void shouldRenameFileOrDirectory() throws IOException {

        File tempFolder = tf.newFolder("New folder");
        String absolutePath = tempFolder.getAbsolutePath();
        Path filePath = Paths.get(absolutePath, "file 1.txt");
        Path newFilePath = Paths.get(absolutePath, "file 2.txt");

        createTxt(filePath);

        rename(filePath, newFilePath);

        assertTrue(Files.exists(newFilePath));
    }

    @Test
    public void shouldNotRenameFileOrDirectory() throws IOException {

        Path filePath = Paths.get("file 1.txt");
        Path newFilePath = Paths.get("file 2.txt");

        rename(filePath, newFilePath);

        String log = outRule.getLog();

        assertTrue(log.contains("Such file or directory does not exist"));
    }

    @Test
    public void shouldConvertToPdf() throws IOException {//++

        File tempFolder = tf.newFolder("New folder");
        String absolutePath = tempFolder.getAbsolutePath();

        Path fileIn = Paths.get(absolutePath, "New file.txt");
        createTxt(fileIn);
        Files.writeString(fileIn, "1234567890");

        convertToPDF(fileIn);

        Path fileOutPdf = Paths.get(absolutePath, "New file.pdf");

        String contentTxt = Files.readString(fileIn);
        String contentPdf = "";

        PdfReader reader;

        try {
            reader = new PdfReader(fileOutPdf.toString());
            contentPdf = PdfTextExtractor.getTextFromPage(reader, 1);
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        assertTrue(Files.exists(fileOutPdf));
        assertEquals(contentTxt, contentPdf);
    }

    @Test
    public void shouldNotConvertToPdf() throws IOException, DocumentException {

        Path file = Paths.get("New file3.txt");

        convertToPDF(file);

        String log = outRule.getLog();

        Assert.assertTrue(log.contains("Such file does not exist"));
    }

    @Test
    public void shouldNotBrowseDirectory() throws IOException {

        Path directory = Paths.get("New folder");

        browseDirectory(directory);

        String log = outRule.getLog();

        Assert.assertTrue(log.contains("Such directory does not exist"));
    }

    @Test
    public void shouldBrowseDirectory() throws IOException {

        File tempFolder = tf.newFolder("New folder");
        String absolutePath = tempFolder.getAbsolutePath();
        Path filePath = Paths.get(absolutePath, "New file3.txt");

        createTxt(filePath);

        browseDirectory(Paths.get(absolutePath));

        String nameDirectory = tempFolder.getName();
        String nameFile = filePath.getFileName().toString();

        String log = outRule.getLog();

        Assert.assertTrue(log.contains(
                nameDirectory + " (directory)" + System.lineSeparator() +
                        nameFile + " (file)" + System.lineSeparator()));
    }
}
