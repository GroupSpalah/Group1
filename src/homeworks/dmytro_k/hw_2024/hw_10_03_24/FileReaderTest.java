package homeworks.dmytro_k.hw_2024.hw_10_03_24;

public class FileReaderTest {
    public static void main(String[] args) throws InterruptedException {
        FileReaderRunnable fileReaderRunnable = new FileReaderRunnable("holidays", 5);
        fileReaderRunnable.startThreadMaker();
    }
}
