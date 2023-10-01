package homeworks.sergii_khvostov.hw_2023.hw_24_09_23.task1;

public class Cow extends Animal{
    public Cow(int weight) {
        super(weight);
    }

    @Override
    public void makeSound() {
        System.out.println("muu");
    }

    public void giveBirth(int calfWeight) {
        int newWeight = getWeight() - calfWeight;
        setWeight(newWeight);
    }
}
