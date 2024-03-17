package lessons.multithreading;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class ExceptionInRun {
    public static void main(String[] args) {
        MyRunnable11 runnable = new MyRunnable11();

        Thread thread = new Thread(runnable);

        thread.start();
    }
}

class MyRunnable11 implements Runnable {
    @Override
    public void run() {
//        throw new IOException();
        try {
            print();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void print() throws IOException {
        throw new IOException();
    }
}

