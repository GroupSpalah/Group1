package homeworks.vladyslav_lazin.hw_2024.hw_17_03_24.task1;

import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

public class Task {
    public static void main(String[] args) {
        Random random = new Random();
        new Thread(() -> {
            IntStream.rangeClosed(0, 2)
                    .forEach(i -> {
                        System.out.println(random.nextInt(21) + 10);
                        try {
                            TimeUnit.SECONDS.sleep(3);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    });
        }).start();
        new Thread(() -> {
            IntStream.rangeClosed(0, 2)
                    .forEach(i -> {
                        System.out.println(random.nextInt(51) + 50);
                        try {
                            TimeUnit.SECONDS.sleep(3);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    });
        }).start();
    }
}
