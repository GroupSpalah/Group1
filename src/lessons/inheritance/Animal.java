package lessons.inheritance;

/**
 * Create a class Animal in which define instance variable type(name and age), constructor that will
 * initialize instance variables and 2 methods eat and sleep.
 * Create a subclass Cat in which override method sleep
 * Create 3 Kitten subclasses of a Cat class and override method eat
 * for 1 kitten - eats milk
 * for 2 kitten - eats snack
 * for 3 kitten - eats everything
 * In main method create object of Cat class and all 3 kittens classes and store
 * into an array of Animals. Call available methods:
 * **Expected Output:**
 * ```
 * Cat eats
 * Cat sleeps a lot
 * kitten1 eats milk
 * kitten1 sleeps a lot
 * kitten2 eats snacks
 * kitten2 sleeps a lot
 * kitten3 eats everything
 * kitten3 sleeps a lot
 * ```
 */
public class Animal {
    private String name;
    private int age;

    public Animal(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void eat() {
        System.out.println("Cat eats");
    }

    public void sleep() {
        System.out.println("Cat sleeps a lot");
    }
}

class Cat1 extends Animal {
    public Cat1(String name, int age) {
        super(name, age);
    }

    @Override
    public void eat() {
        System.out.println("Eat milk");
    }
}

class Cat2 extends Animal {
    public Cat2(String name, int age) {
        super(name, age);
    }

    @Override
    public void eat() {
        System.out.println("Eat snack");
    }

}

class Cat3 extends Animal {
    public Cat3(String name, int age) {
        super(name, age);
    }

    @Override
    public void eat() {
        System.out.println("Eat everything");
    }
}

class TestCats {
    public static void main(String[] args) {
        Cat1 cat1 = new Cat1("John", 23);
        Cat2 cat2 = new Cat2("John", 23);
        Cat3 cat3 = new Cat3("John", 23);

        Animal[] animals = new Animal[3];

        animals[0] = cat1;
        animals[1] = cat2;
        animals[2] = cat3;

        for (Animal animal : animals) {
            animal.eat();
            animal.sleep();
        }
    }
}
