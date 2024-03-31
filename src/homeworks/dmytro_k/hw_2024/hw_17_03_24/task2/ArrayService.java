package homeworks.dmytro_k.hw_2024.hw_17_03_24.task2;

/**
 * 2)  Write a program that check when an array will be filled fully:
 * • create an empty array with 10 elements.
 * • create two threads (one for filling values and one for checking if arrays
 * is filled fully).
 * • run all two threads.
 * • first thread must put new random value into array and sleep for 2
 * seconds.
 * • second thread must check if all array is filled than print all values, if
 * not than sleep for 3 seconds and check again
 */

public class ArrayService {

    private static int[] arrayInput;

    public ArrayService(int[] arrayInput) {
        ArrayService.arrayInput = arrayInput;
    }

    public static int[] getArrayInput() {
        return arrayInput;
    }

    public void startThreads() {
        Recorder recorder = new Recorder();
        Checker checker = new Checker();

        Thread thread1 = new Thread(recorder, "Thread 1");
        Thread thread2 = new Thread(checker, "Thread 2");
        thread1.start();
        thread2.start();
    }
}
