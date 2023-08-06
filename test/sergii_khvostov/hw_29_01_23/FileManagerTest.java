package sergii_khvostov.hw_29_01_23;

import com.itextpdf.text.DocumentException;
import homeworks.sergii_khvostov.hw_2023.hw_29_01_23.FileManager;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.SystemOutRule;
import org.junit.rules.TemporaryFolder;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class FileManagerTest {
    private final FileManager fileManager = new FileManager();
    @Rule
    public SystemOutRule outRule = new SystemOutRule().enableLog();
    @Rule
    public TemporaryFolder tf = new TemporaryFolder();


    @Test
    public void shouldCreateFile() throws IOException {
        File tempFile = tf.newFile("01.txt");
        String absolutePath = tempFile.getAbsolutePath();
        Path path = Paths.get(absolutePath);

        fileManager.createFile(path);
        assertTrue(Files.exists(path));
    }

    @Test
    public void shouldCheckIfFileNotCreate() throws IOException {
        File tempfile = tf.newFile("02.txt");
        String absolutePath = tempfile.getAbsolutePath();
        Path path = Paths.get(absolutePath);

        fileManager.createFile(path);

        String log = outRule.getLog();

        assertTrue(log.contains("File with the same name already exists"));
    }


    @Test
    public void shouldCreateDirectory() throws IOException {
        File dir = tf.newFolder("dirtest");
        String absolutePath = dir.getAbsolutePath();
        Path path = Paths.get(absolutePath);

        fileManager.createDirectory(path);
        assertTrue(Files.exists(path));
    }

    @Test
    public void shouldCheckIfDirectoryNotCreate() throws IOException {
        File dir = tf.newFolder("dirtest");
        String absolutePath = dir.getAbsolutePath();
        Path path = Paths.get(absolutePath);

        fileManager.createDirectory(path);

        String log = outRule.getLog();

        assertTrue(log.contains("Directory with the same name already exists"));
    }

    @Test
    public void shouldCopyFile() throws IOException {
        File tempFile = tf.newFile("03.txt");
        File tempDir = tf.newFolder("dir");
        String absolutePathDir = tempDir.getAbsolutePath();
        Path path = Paths.get(absolutePathDir, "03.txt");

        fileManager.copyFile(tempFile.toPath(), path);
        assertTrue(Files.exists(path));
    }

    @Test
    public void shouldDeleteFile() throws IOException {
        File tempFile = tf.newFile("04.txt");
        String absolutePath = tempFile.getAbsolutePath();
        Path path = Paths.get(absolutePath);
        assertTrue(Files.exists(path));

        fileManager.deleteFile(path);

        assertFalse(Files.exists(path));
    }

    @Test
    public void shouldDeleteDirectory() throws IOException {
        File tempDir = tf.newFolder("dir");
        String absolutePath = tempDir.getAbsolutePath();
        Path path = Paths.get(absolutePath);

        assertTrue(Files.exists(path));

        fileManager.deleteDirectory(path);

        assertFalse(Files.exists(path));
    }

    @Test
    public void shouldRenameFile() throws IOException {
        File tempFile = tf.newFile("05.txt");
        String absolutePath = tempFile.getAbsolutePath();
        Path path = Paths.get(absolutePath);

        File tempNewFile = tf.newFile("06.txt");
        String absoluteNewPath = tempNewFile.getAbsolutePath();
        Path newPath = Paths.get(absoluteNewPath);

        fileManager.renameFile(path, newPath);

        assertTrue(Files.exists(newPath));
    }

    @Test
    public void shouldRenameDirectory() throws IOException {
        File tempDir = tf.newFolder("dir");
        String absolutePath = tempDir.getAbsolutePath();
        Path path = Paths.get(absolutePath);

        File tempNewDir = tf.newFolder("newdir");
        String absoluteNewPath = tempNewDir.getAbsolutePath();
        Path newPath = Paths.get(absoluteNewPath);

        fileManager.renameDirectory(path, newPath);

        assertTrue(Files.exists(newPath));
    }

    @Test
    public void shouldReadDirectory() throws IOException {
        File testDir = tf.newFolder("testDir");

        Path file1 = Paths.get(testDir.getAbsolutePath(), "file1.txt");
        Files.createFile(file1);

        Path file2 = Paths.get(testDir.getAbsolutePath(), "file2.txt");
        Files.createFile(file2);

        fileManager.readDirectory(testDir.toPath());

        assertTrue(Files.exists(testDir.toPath()));
    }

    @Test
    public void shouldConvertToPDF() throws IOException, DocumentException {
        File testFile = tf.newFile("test.txt");
        Files.write(testFile.toPath(), "Hello, world!".getBytes());

        fileManager.convertToPDF(testFile.toPath());

        Path pdfPath = Paths.get
                (testFile.getAbsolutePath().replace(".txt", ".pdf"));

        assertTrue(Files.exists(pdfPath));
    }
}








