package lessons.file_manager;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileManagerTest {

    @Rule
    public TemporaryFolder tf = new TemporaryFolder();

    @Test
    public void testTf() throws IOException {
        File file = tf.newFile("Poem.txt");
        File dir = tf.newFolder("movie", "comedies");

        String absolutePath = dir.getAbsolutePath();

        Path path = Paths.get(absolutePath, "Poem.txt");

        Files.createFile(path);

        System.out.println();
    }
}
