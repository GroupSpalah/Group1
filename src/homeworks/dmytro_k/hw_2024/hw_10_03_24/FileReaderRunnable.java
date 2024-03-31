package homeworks.dmytro_k.hw_2024.hw_10_03_24;

import java.util.stream.IntStream;

public class FileReaderRunnable implements Runnable {
    private final String searchWord;
    private final int numberOfThreads;
    private static final int INDEX_OFFSET = 1;
    private static final double NUMBER_ORDER_CORRECTION = 0.000000001;

    public FileReaderRunnable(String searchWord, int numberOfThreads) {
        this.searchWord = searchWord;
        this.numberOfThreads = numberOfThreads;
    }

    @Override
    public void run() {
        long startTime = System.nanoTime();
        FileReader.repeatCounter(searchWord);
        long endTime = System.nanoTime();
        long elapsedTime = endTime - startTime;
        System.out.println("Time" + Thread.currentThread().getName() + ": "
                + (elapsedTime * NUMBER_ORDER_CORRECTION) + " s");
    }

    public void startThreadMaker() {
        Thread[] threads = new Thread[numberOfThreads];

        IntStream.range(0, threads.length)
                .forEach(i -> {
                    FileReaderRunnable fileReaderRunnable = new FileReaderRunnable(searchWord, numberOfThreads);
                    threads[i] = new Thread(fileReaderRunnable, "Thread " + (i + INDEX_OFFSET));
                    threads[i].start();
                    try {
                        threads[i].join();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                });
    }
}
