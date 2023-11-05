package lessons.inheritance;


import java.io.File;

class Car {//super-class, parent-class
    private String name;//has-a
    private int age;

    public Car(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void print() {
        System.out.println("Print car");
    }
}

public class Bmw extends Car {//sub-class, child-class, is-a
    private String bmwModel;

    public Bmw(String name, int age, String bmwModel) {
        super(name, age);
        this.bmwModel = bmwModel;
    }

    @Override
    public void print() {
        System.out.println("Print bmw");
    }
}

class Fiat extends Car {//is-a
    private String fiatModel;

    public Fiat(String name, int age, String fiatModel) {
        super(name, age);
        this.fiatModel = fiatModel;
    }

    public String getFiatModel() {
        return fiatModel;
    }
}

class TestInheritance {
    public static void main(String[] args) {
        Car fiat = new Fiat("Fiat", 23, "X5");

//        fiat.

//        int a = "Hello";
    }
}


