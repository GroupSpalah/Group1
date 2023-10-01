package homeworks.dmytro_k.hw_2023.hw_24_09_23.task1;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Stream;

/**
 * 2) Ферма животных
 * <p>
 * ++На животноводческой ферме у нас есть кошки, собаки, коровы и гуси. У всех животных есть вес, идентификатор
 * (не задавать в конструкторе, но чтобы был инкремент),
 * и при взаимодействии с ними они издают звук. Кошка говорит «мяу», собака говорит «гав», гусь говорит «гудок»,
 * корова говорит «муу».
 * ++Вес указан в граммах.
 * <p>
 * ++Гуси несут яйца, и мы хотим вести их учет. Собаки любят копать ямы, но нам это не нравится, поэтому после того,
 * как собака выкопала 10 раз, ей не разрешается копать больше.
 * <p>
 * ++Собаки на ферме могут быть типа овчарки, ретривера, хаски.
 * <p>
 * ++Кошки, собаки и коровы — млекопитающие. Когда они рожают, их вес уменьшается на вес ребенка.
 * <p>
 * ++Владелец фермы хочет иметь возможность просматривать каждое животное и взаимодействовать с ним,
 * чтобы слышать его звуки.
 * ??Хозяин также хочет найти «Золотого гуся», он же Гусыня, которая снесла больше всех яиц.
 */

public class Farm {
    public static void main(String[] args) {

        final List<Animal> animals = new ArrayList<>();

        Dog dog1 = new Dog(3000, AnimalClass.MAMMALS, DogType.SHEPHERDS);

        dog1.dig();
        dog1.dig();
        dog1.dig();
        dog1.dig();
        dog1.dig();
        dog1.dig();
        dog1.dig();
        dog1.dig();
        dog1.dig();
        dog1.dig();
        dog1.dig();
        dog1.interaction();

        Goose goose1 = new Goose(2000, AnimalClass.BIRDS);
        Goose goose2 = new Goose(2500, AnimalClass.BIRDS);
        Goose goose3 = new Goose(3000, AnimalClass.BIRDS);

        goose1.layEggs();
        goose1.layEggs();
        goose3.layEggs();
        goose3.layEggs();
        goose3.layEggs();
        goose2.layEggs();
        goose1.numberOfEggs();
        goose1.interaction();

        dog1.giveBirth(1000);

        System.out.println(dog1);

        animals.add(dog1);
        animals.add(goose1);
        animals.add(goose2);
        animals.add(goose3);

        animals.forEach(System.out::println);

        Comparator<Goose> comparatorEggs = (g1, g2) -> Integer.compare(g1.getEggs(), g2.getEggs());//?

//        Predicate<Goose> predicate1 = animal -> animal.getaAnimalClass().equals(AnimalClass.GOOSE);
     /*   Predicate<? super Animal> predicate1 = animal -> animal instanceof Goose;

        Stream<Goose> stream = (Stream<Goose>) animals.stream()
                .filter(predicate1);
        stream
                .max(comparatorEggs)*/

    }
}
