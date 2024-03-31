package homeworks.dmytro_k.hw_2024.hw_17_03_24.task2;

import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

public class Recorder implements Runnable {

    public static final Random RANDOM = new Random();
    private static final int[] arrayInput = ArrayService.getArrayInput();

    private void writeRandomNumbers() {
        while (!Thread.currentThread().isInterrupted()) {
            IntStream.range(0, arrayInput.length)
                    .filter(i -> arrayInput[i] == 0)
                    .findFirst()
                    .ifPresent(i -> {
                        arrayInput[i] = RANDOM.nextInt();
                        System.out.println(Thread.currentThread().getName() +
                                " - index: " + i + ": input element: " + arrayInput[i]);
                        try {
                            TimeUnit.SECONDS.sleep(2);
                        } catch (InterruptedException e) {
                            Thread.currentThread().interrupt();
                        }
                    });

            if (IntStream.range(0, arrayInput.length).noneMatch(i -> arrayInput[i] == 0)) {
                break;
            }
        }
    }

    @Override
    public void run() {
        writeRandomNumbers();
    }
}

