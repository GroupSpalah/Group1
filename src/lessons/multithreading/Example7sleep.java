package lessons.multithreading;

import java.util.concurrent.TimeUnit;

public class Example7sleep {
    public static void main(String[] args) throws InterruptedException {
        for (int i = 5; i > 0; i--) {
            System.out.println(i);
//            Thread.sleep(1000);
            TimeUnit.SECONDS.sleep(1);
        }
        System.out.println("Go!");
    }
}
