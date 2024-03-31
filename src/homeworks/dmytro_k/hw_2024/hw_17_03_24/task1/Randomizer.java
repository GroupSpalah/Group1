package homeworks.dmytro_k.hw_2024.hw_17_03_24.task1;

/**1) Write a program that create 2 threads. The first thread must generate
 * random number from 10 to 30 and print to the console. The second thread
 * must generate random number from 50 to 100 and print to the console.
 * All thread must be run in the same time. Only need 3 numbers from each
 * thread, sleep time between generation is 3 seconds.
 */

import java.util.Random;
import java.util.concurrent.TimeUnit;

public record Randomizer(int from, int upTo, long streamSize, int sleepTime) implements Runnable {

    private void generateRandomNumbers() {
        Random random = new Random();

        random.ints(streamSize, from, upTo).forEach(i -> {
            System.out.println(Thread.currentThread().getName() + ": " + i);
            try {
                TimeUnit.SECONDS.sleep(sleepTime);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
    }

    @Override
    public void run() {
        generateRandomNumbers();
    }
}
