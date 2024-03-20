package homeworks.vladyslav_lazin.hw_2024.hw_10_03_24;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

public class TheBestThread {
    public static void main(String[] args) {
        List<String> words = List.of("we", "i", "holidays", "house", "can");
        words.forEach(word -> new Thread(new MyThread(word)));
    }
}

class MyThread implements Runnable {
    private final String countedWord;

    public MyThread(String countedWord) {
        this.countedWord = countedWord;

        Thread thread = new Thread(this);
        thread.start();
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static long wordCount(String countedWord, String line) {
        String[] words = line.split("\\s+");
        return Arrays.stream(words)
                .map(String::toLowerCase)
                .filter(word -> word.equals(countedWord))
                .count();
    }

    public void run() {
        long startTime = System.currentTimeMillis();
        String line;
        try {
            line = Files.readString(Paths.get("./src/homeworks/vladyslav_lazin/hw_2024/hw_10_03_24/Story.txt"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        long count = wordCount(countedWord, line);
        long time = System.currentTimeMillis() - startTime;

        System.out.printf("Counted word: %s   count: %s times: %s ms%n", countedWord, count, time);
    }
}