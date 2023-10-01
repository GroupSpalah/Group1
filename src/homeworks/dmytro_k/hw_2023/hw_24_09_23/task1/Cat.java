package homeworks.dmytro_k.hw_2023.hw_24_09_23.task1;

/**
 * Кошки, собаки и коровы — млекопитающие. Когда они рожают, их вес уменьшается на вес ребенка.
 */

public class Cat extends Animal {

    public Cat(int weight, AnimalClass aAnimalClass) {
        super(weight, aAnimalClass);
        this.voice = "meow";
    }
}
