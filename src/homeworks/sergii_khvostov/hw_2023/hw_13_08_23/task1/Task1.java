package homeworks.sergii_khvostov.hw_2023.hw_13_08_23.task1;

/*В коллекции храним список стран. Вывести страны, которые начинаются на 'A'
  В коллекции храним список стран. Вывести страны, которые заканчиваются на 'A'
  В коллекции храним список стран. Вывести страны, которые содержут букву 'A'
  В коллекции храним список стран. Вывести страны, в которых больше 5 букв*/

import java.util.List;
import java.util.function.Predicate;

public class Task1 {
    public static void main(String[] args) {


        List<String> countries = List.of("USA", "Australia", "Poland", "Argentina", "India", "Ukraine");

        Predicate<String> predicate1 = country1 -> country1.startsWith("A");
        Predicate<String> predicate2 = country2 -> country2.toLowerCase().endsWith("a");
        Predicate<String> predicate3 = country3 -> country3.toLowerCase().contains("a");
        Predicate<String> predicate4 = country4 -> country4.length() > 5;

        List<String> filteredCountries1 = countries.stream()
                .filter(predicate1).toList();
        List<String> filteredCountries2 = countries.stream()
                        .filter(predicate2).toList();
        List<String> filteredCountries3 = countries.stream()
                        .filter(predicate3).toList();
        List<String> filteredCountries4 = countries.stream()
                        .filter(predicate4).toList();



        filteredCountries1.forEach(System.out::println);
        System.out.println();
        filteredCountries2.forEach(System.out::println);
        System.out.println();
        filteredCountries3.forEach(System.out::println);
        System.out.println();
        filteredCountries4.forEach(System.out::println);







    }
}


