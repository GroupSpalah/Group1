package lessons.abstract_class;

public abstract class Human implements Runnable {
    private int age;
    private String name;

    public Human(int age, String name) {
        this.age = age;
        this.name = name;
    }

    public abstract void showInfo();
}

abstract class Manager extends Human {
    private float salary;

    public Manager(int age, String name, float salary) {
        super(age, name);
        this.salary = salary;
    }

    /*@Override
    public void showInfo() {

    }*/
}

class Client extends Human {
    private String lastName;

    public Client(int age, String name, String lastName) {
        super(age, name);
        this.lastName = lastName;
    }

    @Override
    public void showInfo() {

    }

    @Override
    public void run() {

    }
}
