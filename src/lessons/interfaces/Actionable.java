package lessons.interfaces;

import lessons.two_dim_array.WorkWithRows;

public interface Actionable extends Convertable, Runnable {
    public static final int COUNT = 5;
    public abstract void action();

    public default void print() {

    }

    public static void stMethod() {

    }

    private void prMethod() {

    }
}

interface Convertable {
    void convert();
}

class Work implements Actionable {

    private int age;

    @Override
    public void action() {
        System.out.println("Action for work");
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public void convert() {

    }

    @Override
    public void run() {

    }

}

class Child extends Work {

}

class TestInterface {
    public static void main(String[] args) {
        Convertable work = new Child();

//        work.convert();
    }
}


