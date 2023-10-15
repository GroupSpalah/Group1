package homeworks.dmytro_k.hw_2023.hw_08_10_23.task1;

/**
 * ++ Использовать коллекцию LinkedList.
 * ++ Действия для класса Адрес делать из класса Man.
 * ++ - Вывести информацию о всех людях.
 * ++ - Вывести информацию о всех адресах.
 * ++ - Вывести firstName, lastName, countOfChildren, когда возраст более или равно 20 и отсортировать по firstName.
 * ++ - Изменить firstName = 'John', lastName = 'Kennedi', countOfChildren = 3, когда country == 'US' (or another country).
 * ++ - Вывести firstName, lastName, nameOfStreet, когда country == 'Canada' AND numberOfHome == 3 OR age >= 25";
 *
 * 1) Since 24/09/23
 * - Сгруппировать людей по количеству детей.
 * - Сгруппировать людей по количеству детей и возрасту.
 * - Сгруппировать людей по городу и названию улицы.
 * - Сгруппировать людей по городу и названию улицы и вывести количество адресов,
 * где количество людей больше 4.
 */

import lessons.streams.ManMap;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class ManTest {
    public static void main(String[] args) {
        List<Man> people = new LinkedList<>();

        Address addressMan1 = new Address("US", "New York", "45", 135);
        Address addressMan2 = new Address("US", "New York", "20", 40);
        Address addressMan3 = new Address("Canada", "Toronto", "Colgate Ave", 50);

        Man man1 = new Man("John", "Kennedi", 30, 3, addressMan1);
        Man man2 = new Man("Elvis", "Presley", 40, 5, addressMan2);
        Man man3 = new Man("Justin", "Trudeau", 50, 3, addressMan3);

        people.add(man1);
        people.add(man2);
        people.add(man3);

        Predicate<Man> predicate1 = element -> element.getAge() >= 20;

        Predicate<Man> predicate2 = element ->
                element
                        .getADDRESS()
                        .getCountry()
                        .equalsIgnoreCase("Canada") &&
                        element
                                .getADDRESS()
                                .getHouseNumber() == 3 ||
                        element.getAge() >= 25;


        Predicate<Man> predicate3 = element ->
                element
                        .getADDRESS()
                        .getCountry()
                        .equalsIgnoreCase("Canada");

        Comparator<Man> comparatorName = (m1, m2) -> m1.getFirstName().compareTo(m2.getFirstName());

        Consumer<Man> filteredMan1 = man ->
                System.out.println(man.getFirstName() + " " +
                        man.getLastName() + " " +
                        man.getCountOfChildren());

        Consumer<Man> filteredMan2 = man ->
                System.out.println(man.getFirstName() + " " +
                        man.getLastName() + " " +
                        man
                                .getADDRESS()
                                .getStreet());

        Consumer<Man> address = man ->
                System.out.println(man.getADDRESS());

        people.forEach(System.out::println);

        people.forEach(address);

        people
                .stream()
                .filter(predicate1)
                .sorted(comparatorName)
                .forEach(filteredMan1);

        for (Man man : people) {
            if (predicate3.test(man)) {
                man.setFirstName("John");
                man.setLastName("Kennedi");
                man.setCountOfChildren(3);
            }
        }

        people
                .stream()
                .filter(predicate3)
                        .forEach(man -> {
                            man.setFirstName("John");
                            man.setLastName("Kennedi");
                            man.setCountOfChildren(3);
                        });

        people
                .stream()
                .filter(predicate2)
                .forEach(filteredMan2);


// Grouping

        ManService manService = new ManService();
        manService.groupingByCountOfChildren(people);
        manService.groupingByCountOfChildrenAndAge(people);
    }
}
