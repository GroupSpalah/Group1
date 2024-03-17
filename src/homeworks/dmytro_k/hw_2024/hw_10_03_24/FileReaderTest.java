package homeworks.dmytro_k.hw_2024.hw_10_03_24;


public class FileReaderTest {
    public static void main(String[] args) throws InterruptedException {

        long startTime = System.nanoTime();

        FileReader.repeatCounter("I");

        TestThread1 testThread1 = new TestThread1();
        TestThread2 testThread2 = new TestThread2();
        TestThread3 testThread3 = new TestThread3();
        TestThread4 testThread4 = new TestThread4();
        TestThread5 testThread5 = new TestThread5();

        long startTime1 = System.nanoTime();
        testThread1.start();
        long endTime1 = System.nanoTime();

        long startTime2 = System.nanoTime();
        testThread2.start();
        long endTime2 = System.nanoTime();

        long startTime3 = System.nanoTime();
        testThread3.start();
        long endTime3 = System.nanoTime();

        long startTime4 = System.nanoTime();
        testThread4.start();
        long endTime4 = System.nanoTime();

        long startTime5 = System.nanoTime();
        testThread5.start();
        long endTime5 = System.nanoTime();

        long endTime = System.nanoTime();

        //Join
        long startTimeAllWithJoin = System.nanoTime();

        FileReader.repeatCounter("I");

        TestThread1 testThread11 = new TestThread1();
        TestThread2 testThread22 = new TestThread2();
        TestThread3 testThread33 = new TestThread3();
        TestThread4 testThread44 = new TestThread4();
        TestThread5 testThread55 = new TestThread5();

        testThread11.start();
        testThread22.start();
        testThread33.start();
        testThread44.start();
        testThread55.start();

        testThread11.join();
        testThread22.join();
        testThread33.join();
        testThread44.join();
        testThread55.join();

        long endTimeAllWithJoin = System.nanoTime();

        long elapsedTime1 = endTime1 - startTime1;
        long elapsedTime2 = endTime2 - startTime2;
        long elapsedTime3 = endTime3 - startTime3;
        long elapsedTime4 = endTime4 - startTime4;
        long elapsedTime5 = endTime5 - startTime5;
        long elapsedTime = endTime - startTime;
        long elapsedTimeAllWithJoin = endTimeAllWithJoin - startTimeAllWithJoin;


        System.out.println("Time thread1: " + (elapsedTime1 * 0.000000001) + " c");
        System.out.println("Time thread2: " + (elapsedTime2 * 0.000000001) + " c");
        System.out.println("Time thread3: " + (elapsedTime3 * 0.000000001) + " c");
        System.out.println("Time thread4: " + (elapsedTime4 * 0.000000001) + " c");
        System.out.println("Time thread5: " + (elapsedTime5 * 0.000000001) + " c");
        System.out.println("Time all threads: " + (elapsedTime * 0.000000001) + " c");
        System.out.println("Time all threads with join: " + (elapsedTimeAllWithJoin * 0.000000001) + " c");
    }
}
