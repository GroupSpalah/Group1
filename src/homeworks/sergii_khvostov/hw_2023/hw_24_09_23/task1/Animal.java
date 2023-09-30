package homeworks.sergii_khvostov.hw_2023.hw_24_09_23.task1;

abstract class Animal {
    private static int nextId = 1;
    private int id;
    private int weight;

    public Animal(int weight) {
        this.id = nextId++;
        this.weight = weight;
    }

    public int getId() {
        return id;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public abstract void makeSound();
}
