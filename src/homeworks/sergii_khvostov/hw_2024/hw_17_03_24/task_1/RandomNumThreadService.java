package homeworks.sergii_khvostov.hw_2024.hw_17_03_24.task_1;

public class RandomNumThreadService {
    public static void main(String[] args) {
        Thread thread1 = new Thread(new RandomNumThread(10, 30, 3));
        Thread thread2 = new Thread(new RandomNumThread(50, 100, 3));
        thread1.start();
        thread2.start();
    }
}
