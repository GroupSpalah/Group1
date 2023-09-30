package homeworks.sergii_khvostov.hw_2023.hw_24_09_23.task1;

/*Ферма животных
   На животноводческой ферме у нас есть кошки, собаки, коровы и гуси.
   У всех животных есть вес(вес указан в граммах), идентификатор (не задавать в
   конструкторе,
   но чтобы был инкремент), и при взаимодействии с ними они издают звук.

   Кошка говорит «мяу», собака говорит «гав», гусь говорит «га-га», корова говорит «муу».

   Гуси несут яйца, и мы хотим вести их учет.
   Хозяин
   также хочет найти гусыню, которая снесла больше всех яиц.

   Собаки любят копать ямы, но нам это не нравится, поэтому после того,как собака выкопала 10 раз,
   ей не разрешается копать больше.
   Собаки на ферме могут быть типа овчарки, ретривера, хаски.

   Кошки, собаки и коровы — млекопитающие. Когда они рожают, их вес уменьшается на вес ребенка.

   Владелец фермы хочет иметь возможность просматривать каждое животное и взаимодействовать с ним,
   чтобы слышать его звуки.*/

import java.util.*;

public class FarmService {
    public static void main(String[] args) {
        List<Animal> animals = new ArrayList<>();

        Cat cat1 = new Cat(3000);
        Dog dog1 = new Dog(5000, DogBreed.SHEPHERD);
        Goose goose1 = new Goose(2000);
        Goose goose2 = new Goose(2200);
        Cow cow1 = new Cow(60000);

        animals.add(cat1);
        animals.add(dog1);
        animals.add(goose1);
        animals.add(goose2);
        animals.add(cow1);

        animals.forEach(animal -> {
            System.out.println("ID: " + animal.getId() + ", Weight: " + animal.getWeight());
            animal.makeSound();
        });

        animals.stream()
                .filter(animal -> animal instanceof Dog)
                .forEach(dog -> {
                    System.out.println("ID: " + dog.getId() + ", Weight: " + dog.getWeight());
                    dog.makeSound();
                    ((Dog) dog).dig();
                });

        Optional<Goose> topEggManufacturer = animals.stream()
                .filter(animal -> animal instanceof Goose)
                .map(animal -> (Goose) animal)
                .max(Comparator.comparing(Goose::getEggCount));

        topEggManufacturer.ifPresent(goose ->
                System.out.println("ID: " + goose.getId() + ", Eggs: " + goose.getEggCount()));
    }
}
