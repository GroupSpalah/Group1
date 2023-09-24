package homeworks.dmytro_k.hw_2023.hw_17_09_23;

/**
 * Кошки, собаки и коровы — млекопитающие. Когда они рожают, их вес уменьшается на вес ребенка.*/

public class Cat extends Animal{

    public Cat(int weight, int identifier) {
        super(weight, identifier);
        this.voice = "meow";
    }
}
