package homeworks.sergii_khvostov.hw_2024.hw_10_03_24;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class TaskToThread implements Runnable {
    private String word;
    Path path = Paths.get("./Story.txt");

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
        long executionTime = endTime - startTime;
        System.out.println(Thread.currentThread().getName() + " counted " + wordCount +
                " coincidences " + "'" + word + "'" + " in " + executionTime + " milliseconds.");
    }

    private int countWordInFile(Path path, String word) throws IOException {
        String content = new String(Files.readAllBytes(path));
        return (int) Arrays.stream(content.split("\\s+"))
                .filter(w -> w.equalsIgnoreCase(word))
                .count();
    }

    private void executeApp() throws InterruptedException {
        List<Thread> threads = IntStream.range(0, 5)
                .mapToObj(i -> {
                    TaskToThread taskToThread;
                    try {
                        taskToThread = new TaskToThread(word);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    Thread thread = new Thread(taskToThread, "Thread " + (i + 1));
                    thread.start();
                    return thread;
                })
                .collect(Collectors.toList());

        threads.stream().forEach(thread -> {
            try {
                thread.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
    }

    public void execute() throws InterruptedException {
        System.out.println("Start:");
        executeApp();
        System.out.println("End");
    }
}

