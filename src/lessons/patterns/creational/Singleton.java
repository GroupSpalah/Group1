package lessons.patterns.creational;

import java.util.Objects;

public class Singleton {
    private int age;
    private String name;
    private static Singleton object;

    public static int COUNT = 5;

    private Singleton(int age, String name) {
        this.age = age;
        this.name = name;
    }

    public static Singleton getInstance(String name, int age) {
        if (Objects.isNull(object)) {
            object = new Singleton(age, name);
        }

        return object;
    }

    @Override
    public String toString() {
        return "Singleton{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
}

class TestSingleton {
    public static void main(String[] args) {
        Singleton john = Singleton.getInstance("John", 32);

        System.out.println(john);

        Singleton jack = Singleton.getInstance("Jack", 25);

        System.out.println(jack);
    }
}
