package homeworks.dmytro_k.hw_2023.hw_16_04_23.task2;

import java.util.ArrayList;
import java.util.List;

/**
 * Есть Лист со строками
 * Допустим 3 строки - "qwe" "qsd" "qxc"
 * ++Нам нужно в этом листе, не создавая новый лист, заменить букву q на букву i например
 * <p>
 * ++В коллекции храним список стран. Вывести страны, которые начинаются на 'A', startWith
 * <p>
 * ++В коллекции храним список стран. Вывести страны, которые заканчиваются на 'A', endsWith
 * <p>
 * ++В коллекции храним список стран. Вывести страны, которые содержут букву 'A'
 * <p>
 * ++В коллекции храним список стран. Вывести страны, в которых больше 5 букв
 * <p>
 * ++В коллекции храним числа. Увеличить каждый элемент на 5
 **/

public class Task2 {
    public static void main(String[] args) {

        //1
        List<String> aList = new ArrayList<>();

        aList.add("qwe");
        aList.add("qsd");
        aList.add("qxc");

        System.out.println(aList);

        aList.replaceAll(s -> s.replaceFirst("q", "i"));

        System.out.println(aList);

        //2

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

        for (String country : countries) {
            if (country.startsWith("A")) {
                System.out.println(country);
            }
        }

        //3

        System.out.println("------------");

        for (String country : countries) {
            if (country.endsWith("a")) {
                System.out.println(country);
            }
        }

        //4

        System.out.println("------------");

        for (String country : countries) {
            if (country.contains("A") || country.contains("a")) {
                System.out.println(country);
            }
        }

        //5

        System.out.println("------------");

        for (String country : countries) {
            if (country.length() > 5) {
                System.out.println(country);
            }
        }

        //6

        System.out.println("------------");

        List<Integer> aList2 = new ArrayList<>();

        aList2.add(3);
        aList2.add(7);
        aList2.add(6);
        aList2.add(8);

        System.out.println(aList2);

        aList2.replaceAll(integer -> integer + 5);

        System.out.println(aList2);
    }
}
