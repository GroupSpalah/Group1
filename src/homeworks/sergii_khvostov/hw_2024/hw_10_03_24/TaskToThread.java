package homeworks.sergii_khvostov.hw_2024.hw_10_03_24;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class TaskToThread implements Runnable {
    private String word;
    private long executionTime;
    Path path = Paths.get("D:\\IT\\Group1_Git\\Group1\\src\\homeworks\\sergii_khvostov\\hw_2024\\hw_10_03_24\\Story.txt");

    public TaskToThread(String word) throws InterruptedException {
        this.word = word;
        this.path = path;
    }

    @Override
    public void run() {
        long startTime = System.currentTimeMillis();
        int wordCount = 0;
        try {
            wordCount = countWordInFile(path, word);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        long endTime = System.currentTimeMillis();
        executionTime = endTime - startTime;
        System.out.println(Thread.currentThread().getName() + " counted " + wordCount +
                " coincidences " + "'" + word + "'" + " in " + executionTime + " milliseconds.");
    }

    private int countWordInFile(Path path, String word) throws IOException {
        byte[] fileContent = Files.readAllBytes(path);
        String content = new String(fileContent);
        String[] words = content.split("\\s+");
        int count = 0;
        for (String w : words) {
            if (w.equalsIgnoreCase(word)) {
                count++;
            }
        }
        return count;
    }

    private void executeApp() throws InterruptedException {
        Thread[] threads = new Thread[5];
        for (int i = 0; i < threads.length; i++) {
            TaskToThread taskToThread = new TaskToThread(word);
            threads[i] = new Thread(taskToThread, "Thread " + (i + 1));
            threads[i].start();
            threads[i].join();
        }
    }
    public void execute() throws InterruptedException {
        System.out.println("Start:");
        executeApp();
        System.out.println("End");
    }
}
