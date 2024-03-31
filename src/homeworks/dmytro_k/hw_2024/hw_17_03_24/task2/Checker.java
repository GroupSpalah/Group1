package homeworks.dmytro_k.hw_2024.hw_17_03_24.task2;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;

public class Checker implements Runnable {

    private static final int[] arrayInput = ArrayService.getArrayInput();

    private void checkingZeros() {
        while (true) {
            Thread thread = Thread.currentThread();

            if (!thread.isInterrupted()) break;
            if (Arrays.stream(arrayInput).anyMatch(i -> i == 0)) {
                System.out.println(thread.getName() +
                        " - The array is not yet completely filled. Current state: " +
                        Arrays.toString(arrayInput));
                try {
                    TimeUnit.SECONDS.sleep(3);
                } catch (InterruptedException e) {
                    thread.interrupt();
                }
            } else {
                System.out.println("The array is full: " + Arrays.toString(arrayInput));
                thread.interrupt();
                return;//?
            }
        }
    }

    @Override
    public void run() {
        checkingZeros();
    }
}
