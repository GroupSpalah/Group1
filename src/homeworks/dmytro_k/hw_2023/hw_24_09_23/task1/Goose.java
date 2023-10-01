package homeworks.dmytro_k.hw_2023.hw_24_09_23.task1;

/**
 * Гуси несут яйца, и мы хотим вести их учет.
 * Хозяин также хочет найти «Золотого гуся», он же Гусыня, которая снесла больше всех яиц.
 */

public class Goose extends Animal {

    private int eggs;
    private static int eggCounters = 0;

    public Goose(int weight, AnimalClass aAnimalClass) {
        super(weight, aAnimalClass);
        this.voice = "beep";
    }

    public int getEggs() {
        return eggs;
    }

    public void numberOfEggs() {
        System.out.println(eggs);
    }

    public void layEggs() {
        eggs = eggCounters++;
    }
}
