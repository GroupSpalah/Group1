package homeworks.vladyslav_lazin.hw_2024.hw_10_03_24;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

public class TheBestThread {
    public static void main(String[] args) {
        List<String> words = List.of("we", "i", "holidays", "house", "can");

         words.forEach(word -> new Thread(new MyThread(word)));

    }


    public static String readFile() {

        Path pathToFile = Paths.get("./src/homeworks/vladyslav_lazin/hw_2024/hw_10_03_24/Story.txt");

        String line = null;
        try {
            line = Files.readString(pathToFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return line;
    }

    public static long wordCount(String countedWord, String line) {
        String[] words = line.split("\\s+");
        return Arrays.stream(words)
                .map(String::toLowerCase)
                .filter(word -> word.equals(countedWord))
                .count();
    }
}

class MyThread implements Runnable {
    private final String countedWord;
        
    public MyThread(String countedWord) {
        this.countedWord = countedWord;

        Thread t = new Thread(this);
        t.start();
        try {
            t.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void run() {
        long startTime = System.currentTimeMillis();
        String line = TheBestThread.readFile();

        long count = TheBestThread.wordCount(countedWord, line);
        long time = System.currentTimeMillis() - startTime;

        System.out.printf("Counted word: %s   count: %s times: %s ms%n", countedWord, count, time);
    }
}