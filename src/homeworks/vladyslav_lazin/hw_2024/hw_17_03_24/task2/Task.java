package homeworks.vladyslav_lazin.hw_2024.hw_17_03_24.task2;

import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Task {
    private static final int[] array = new int[10];
    public static void main(String[] args) {
        new Thread(() -> {
            Random random = new Random();
            for (int i = 0; i < array.length; i++) {
                System.out.println("Fill " + i);
                array[i] = random.nextInt();
                try {
                    TimeUnit.SECONDS.sleep(2);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }).start();

        new Thread(() -> {
            while (true) {
                System.out.println("checking array");
                if (array[array.length - 1] != 0) {
                    Arrays.stream(array).forEach(System.out::println);
                    break;
                } else {
                    System.out.println("awaiting");
                    try {
                        TimeUnit.SECONDS.sleep(3);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        }).start();
    }
}
