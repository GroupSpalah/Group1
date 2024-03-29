package homeworks.sergii_khvostov.hw_2024.hw_17_03_24.task_2;

/*Write a program that check when an array will be filled fully:
   • create an empty array with 10 elements.
   • create two threads (one for filling values and one for checking if arrays
   is filled fully).
   • run all two threads.
   • first thread must put new random value into array and sleep for 2
   seconds.
   • second thread must check if all array is filled than print all values, if
   not than sleep for 3 seconds and check again*/

import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

public class ArrayOperations implements Runnable {
    private int ARRAY_SIZE = 10;
    private int RANDOM_NUM = 50;
    private long FILL_DELAY = 2;
    private long CHECK_DELAY = 3;

    private int[] array = new int[ARRAY_SIZE];
    private int count = 0;

    @Override
    public void run() {
        Thread fillThread = new Thread(this::fillingArray);
        Thread checkThread = new Thread(this::checkArray);
        fillThread.start();
        checkThread.start();
    }

    private void fillingArray() {
        Random random = new Random();
        IntStream.range(count, ARRAY_SIZE)
                .forEach(i -> {
                    array[i] = random.nextInt(RANDOM_NUM);
                    System.out.println("Added value: " + array[i]);
                });
        count = ARRAY_SIZE;
        try {
            TimeUnit.SECONDS.sleep(FILL_DELAY);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void checkArray() {
        while (count < ARRAY_SIZE) {
            try {
                TimeUnit.SECONDS.sleep(CHECK_DELAY);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Array filled completely:");
        Arrays.stream(array).forEach(System.out::println);
    }
}
