package lessons.multithreading;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class InterruptThread {
    public static void main(String[] args) throws InterruptedException {

        MyRunnable runnable = new MyRunnable();

        Thread thread = new Thread(runnable, "Vasya");

        thread.start();
//        thread.start();

        thread.interrupt();

       /* boolean interrupted = thread.isInterrupted();

        System.out.println(interrupted);*/

    }
}

class MyRunnable implements Runnable {
    @Override
    public void run() {
        Thread thread = Thread.currentThread();

        boolean interrupted = thread.isInterrupted();

        System.out.println("Before sleep -> " + interrupted);
/*
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            boolean interrupted1 = thread.isInterrupted();
            System.out.println("Inside catch -> " + interrupted1);
            thread.interrupt();
        }*/

        try {
            throw new IOException();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
