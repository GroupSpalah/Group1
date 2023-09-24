package homeworks.dmytro_k.hw_2023.hw_17_09_23;

import java.util.ArrayList;
import java.util.List;

/**
 * 2) Ферма животных
 *
 *    На животноводческой ферме у нас есть кошки, собаки, коровы и гуси. У всех животных есть вес, идентификатор
 *    (не задавать в конструкторе, но чтобы был инкремент),
 *     и при взаимодействии с ними они издают звук. Кошка говорит «мяу», собака говорит «гав», гусь говорит «гудок»,
 *     корова говорит «муу».
 *    Вес указан в граммах.
 *
 *    Гуси несут яйца, и мы хотим вести их учет. Собаки любят копать ямы, но нам это не нравится, поэтому после того,
 *     как собака выкопала 10 раз, ей не разрешается копать больше.
 *
 *    Собаки на ферме могут быть типа овчарки, ретривера, хаски.++
 *
 *    Кошки, собаки и коровы — млекопитающие. Когда они рожают, их вес уменьшается на вес ребенка.
 *
 *    Владелец фермы хочет иметь возможность просматривать каждое животное и взаимодействовать с ним,
 *    чтобы слышать его звуки.
 *    Хозяин также хочет найти «Золотого гуся», он же Гусыня, которая снесла больше всех яиц.*/

public class Farm {
    public static void main(String[] args) {

        Dog dog1 = new Dog(3000, 1, DogType.SHEPHERDS);

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

        Goose goose = new Goose(2000, 2);

        goose.layEggs();
        goose.layEggs();
        goose.numberOfEggs();

        final List<Animal> animals = new ArrayList<>();

    }
}
