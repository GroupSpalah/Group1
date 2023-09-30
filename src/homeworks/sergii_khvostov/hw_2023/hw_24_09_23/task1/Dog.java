package homeworks.sergii_khvostov.hw_2023.hw_24_09_23.task1;

public class Dog extends Animal {
    private int diggingCount = 0;
    private DogBreed breed;

    public Dog(int weight, DogBreed breed) {
        super(weight);
        this.breed = breed;
    }
    public DogBreed getBreed() {
        return breed;
    }

    @Override
    public void makeSound() {
        System.out.println("woof");
    }

    public void dig() {
        if (diggingCount < 10) {
            System.out.println("dog digs a hole");
            diggingCount++;
        } else {
            System.out.println("the dog can no longer dig");
        }
    }

    public void giveBirth(int puppyWeight) {
        int newWeight = getWeight() - puppyWeight;
        setWeight(newWeight);
    }
}
