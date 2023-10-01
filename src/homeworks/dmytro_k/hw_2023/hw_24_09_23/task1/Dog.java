package homeworks.dmytro_k.hw_2023.hw_24_09_23.task1;

/**
 * Собаки на ферме могут быть типа овчарки, ретривера, хаски.
 * Собаки любят копать ямы, но нам это не нравится, поэтому после того,
 * как собака выкопала 10 раз, ей не разрешается копать больше.
 */

public class Dog extends Animal {

    private DogType dogType;
    private int pit;

    public Dog(int weight, AnimalClass aAnimalClass, DogType dogType) {
        super(weight, aAnimalClass);
        this.voice = "woof";
        this.dogType = dogType;
    }

    public void dig() {
        if (pit < 10) {
            pit++;
        } else {
            System.out.println("you can't dig");
        }
    }
}
