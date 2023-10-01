package homeworks.sergii_khvostov.hw_2023.hw_24_09_23.task1;

public class Cat extends Animal {
    public Cat(int weight) {
        super(weight);
    }

    @Override
    public void makeSound() {
        System.out.println("meow");
    }

    public void giveBirth(int kittenWeight) {
        int newWeight = getWeight() - kittenWeight;
        setWeight(newWeight);
    }
}
