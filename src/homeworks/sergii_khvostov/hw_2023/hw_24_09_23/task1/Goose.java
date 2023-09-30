package homeworks.sergii_khvostov.hw_2023.hw_24_09_23.task1;

public class Goose extends Animal {
    private int eggCount = 0;
    private static Goose topEggManufacturer;


    public Goose(int weight) {
        super(weight);
    }

    @Override
    public void makeSound() {
        System.out.println("ha-ha");
    }

    public void layEgg(int numberOfEggs) {
        eggCount += numberOfEggs;
        if (topEggManufacturer == null || eggCount > topEggManufacturer.getEggCount()) {
            topEggManufacturer = this;
        }
    }

    public int getEggCount() {
        return eggCount;
    }

    public static Goose getTopEggManufacturer() {
        return topEggManufacturer;
    }
}
