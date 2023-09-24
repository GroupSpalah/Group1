package homeworks.dmytro_k.hw_2023.hw_17_09_23;

/**
 * Гуси несут яйца, и мы хотим вести их учет.
 * Хозяин также хочет найти «Золотого гуся», он же Гусыня, которая снесла больше всех яиц.
 */

public class Goose extends Animal {

    private int eggs;

    public Goose(int weight, int identifier) {
        super(weight, identifier);
        this.voice = "beep";
    }

    public void numberOfEggs() {
        System.out.println(eggs);
    }

    public void layEggs() {
        eggs++;
    }
}
