package lessons.multithreading;

public class DeamonThread {
    public static void main(String[] args) {
        DRunnable dRunnable = new DRunnable();

        Thread thread = new Thread(dRunnable);

        thread.setDaemon(true);

        thread.start();
    }
}

class DRunnable implements Runnable {
    @Override
    public void run() {
        while (true);
    }
}
