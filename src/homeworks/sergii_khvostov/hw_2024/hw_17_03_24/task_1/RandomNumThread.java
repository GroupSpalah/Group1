package homeworks.sergii_khvostov.hw_2024.hw_17_03_24.task_1;

/*Write a program that create 2 threads. The first thread must generate
random number from 10 to 30 and print to the console. The second thread
must generate random number from 50 to 100 and print to the console.
All thread must be run in the same time. Only need 3 numbers from each
thread, sleep time between generation is 3 seconds.*/

import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

public class RandomNumThread implements Runnable {
    public static final Random RANDOM = new Random();
    private int min;
    private int max;
    private int count;

    public RandomNumThread(int min, int max, int count) {
        this.min = min;
        this.max = max;
        this.count = count;
    }

    @Override
    public void run() {
        IntStream.range(0, count)
                .forEach(i -> {
                    int randomNum = RANDOM.nextInt(min, max);
                    System.out.println(Thread.currentThread().getName() +
                            " - random number: " + randomNum);
                    try {
                        TimeUnit.SECONDS.sleep(3);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                });
    }
}
