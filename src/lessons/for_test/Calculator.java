package lessons.for_test;

import java.util.Random;

public class Calculator {
    public int sum(int a, int b) {
        return a + b;
    }

    public void print() {
        System.out.println("Hello world");
    }

    public int sumRandom(int a) {
//        print();
        return a + getRandom();
    }

    public int getRandom() {
        return new Random().nextInt(50);
    }
}
