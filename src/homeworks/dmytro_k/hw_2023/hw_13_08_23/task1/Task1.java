package homeworks.dmytro_k.hw_2023.hw_13_08_23.task1;

/**
 * ++В коллекции храним список стран. Вывести страны, которые начинаются на 'A', startWith
 * <p>
 * ++В коллекции храним список стран. Вывести страны, которые заканчиваются на 'A', endsWith
 * <p>
 * ++В коллекции храним список стран. Вывести страны, которые содержут букву 'A'
 * <p>
 * ++В коллекции храним список стран. Вывести страны, в которых больше 5 букв
 * <p>
 * ++В коллекции храним числа. Увеличить каждый элемент на 5
 */

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class Task1 {
    public static void main(String[] args) {

        List<String> countries = new ArrayList<>();

        countries.add("Austria");
        countries.add("France");
        countries.add("Germany");
        countries.add("Netherlands");
        countries.add("Albania");
        countries.add("Italy");
        countries.add("Armenia");
        countries.add("Georgia");
        countries.add("Ukraine");
        countries.add("China");
        countries.add("USA");

        Predicate<String> predicate1 = element -> element.startsWith("A");
        Predicate<String> predicate2 = element -> element.endsWith("a");
        Predicate<String> predicate3 = element -> element.contains("A") || element.contains("a");
        Predicate<String> predicate4 = element -> element.length() > 5;

        Consumer<String> consumer1 = System.out::println;

        //1
        System.out.println("-1-");
        countries
                .stream()
                .filter(predicate1)
                .forEach(consumer1);
        //2
        System.out.println("-2-");
        countries
                .stream()
                .filter(predicate2)
                .forEach(consumer1);
        //3
        System.out.println("-3-");
        countries
                .stream()
                .filter(predicate3)
                .forEach(consumer1);
        //4
        System.out.println("-4-");
        countries
                .stream()
                .filter(predicate4)
                .forEach(consumer1);
    }
}
