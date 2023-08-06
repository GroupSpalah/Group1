package lessons.learn_class;

public class LearnThis {
    public static void main(String[] args) {
        ForThis john = new ForThis(23, "John");
        ForThis jack = new ForThis(28, "Jack");

        john.setAge(50);
        jack.setAge(50);

        jack
                .print1()//this
                .print2();

    }
}

class ForThis {
    private int age;
    private int height;
    private String name;

    public ForThis(String name, int age) {
        this.age = age;
        this.name = name;
    }

    public ForThis(int newAge, String newName) {
        this.age = age;
        this.name = name;
    }

    public ForThis(int age, int height, String name) {
//        this.age = age;
//        this.name = name;
        this(age, name);
        this.height = height;

    }

    public void setAge(int newAge) {
        this.age = newAge;
    }

    public ForThis print1() {
        return this;
    }

    public ForThis print2() {
        return this;
    }

}
