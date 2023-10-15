package homeworks.sergii_khvostov.hw_2023.hw_24_09_23.task2;

/*Сущность Man(имя, фамилия, возраст, количество детей, Адрес), Адрес(страна, город, улица, номер дома)
  Использовать коллекцию LinkedList. Действия для класса Адрес делать из класса Man.
  - Вывести информацию о всех людях.
  - Вывести информацию о всех адресах.
  - Вывести firstName, lastName, countOfChildren, когда возраст более или равно 20
  и отсортировать по firstName.
  - Изменить firstName = 'John', lastName = 'Kennedi', countOfChildren = 3,
   когда country == 'US' (or another country).
  - Вывести firstName, lastName, nameOfStreet, когда country == 'Canada'
   и numberOfHome == 3 или age >= 25";*/

import org.apache.commons.lang3.tuple.Pair;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ManService {
    public static void main(String[] args) {
        List<Man> people = new LinkedList<>();
        people.add(new Man("John", "Doe", 25, 2,
                new Address("US", "New York", "Broadway", 123)));
        people.add(new Man("Alice", "Smith", 30, 1,
                new Address("Canada", "Toronto", "Maple St", 3)));
        people.add(new Man("Bob", "Johnson", 22, 0,
                new Address("Canada", "Montreal", "Oak St", 5)));

        people.forEach(man -> System.out.println(man.getFirstName() + " " + man.getLastName() + "\n" +
                " (Age: " + man.getAge() + ", Children: " + man.getCountOfChildren() + ")"));

        people.stream()
                .map(Man::getAddress)
                .forEach(address -> System.out.println(address.country() + ", " + address.city() + ", " +
                        address.street() + ", " + address.numberOfHome()));

        people.stream()
                .filter(man -> man.getAge() >= 20)
                .sorted(Comparator.comparing(Man::getFirstName))
                .forEach(man -> System.out.println(man.getFirstName() + " " + man.getLastName() + ", " +
                        man.getCountOfChildren()));

        people.stream()
                .filter(man -> man.getAddress().country().equals("US"))
                .forEach(man -> {
                    man = new Man("John", "Kennedy", man.getAge(), 3,
                            man.getAddress());
                    System.out.println(man.getFirstName() + " " + man.getLastName() + " ,"
                            + man.getCountOfChildren());
                });

        people.stream()
                .filter(man -> man.getAddress().country().equals("Canada") &&
                        man.getAddress().numberOfHome() == 3 || man.getAge() >= 25)
                .forEach(man -> System.out.println(man.getFirstName() + " " + man.getLastName() +
                        " ," + man.getAddress().street()));

        //2
        //- Сгруппировать людей по количеству детей.
        Map<Integer, List<Man>> map1 = people.stream()
                .collect(Collectors.groupingBy(Man::getCountOfChildren));

        map1.forEach((childrenCount, manList) -> {
            System.out.println("People with " + childrenCount + " children:");
            manList.forEach(man -> System.out.println(man.getFirstName() + " " + man.getLastName()));
            System.out.println();
        });

        //- Сгруппировать людей по количеству детей и возрасту.
        Map<Integer, Map<Integer, List<Man>>> map2 = people.stream()
                .collect(Collectors.groupingBy(Man::getCountOfChildren,
                        Collectors.groupingBy(Man::getAge)));

        map2.forEach((childrenCount, ageMap) -> {
            System.out.println("People with " + childrenCount + " children:");
            ageMap.forEach((age, manList) -> {
                System.out.println("  Age " + age + ":");
                manList.forEach(man -> System.out.println("    " + man.getFirstName() +
                        " " + man.getLastName()));
            });
            System.out.println();
        });



        //- Сгруппировать людей по городу и названию улицы.
        Map<String, Map<String, List<Man>>> map3 = people.stream()
                .collect(Collectors.groupingBy(man -> man.getAddress().city(),
                        Collectors.groupingBy(man -> man.getAddress().street())));

        map3.forEach((city, streetMap) -> {
            System.out.println("City: " + city);
            streetMap.forEach((street, manList) -> {
                System.out.println("  Street: " + street);
                manList.forEach(man -> System.out.println("    " + man.getFirstName() +
                        " " + man.getLastName()));
            });
        });

        //- Сгруппировать людей по городу и названию улицы и вывести количество адресов,
        //  где количество людей больше 4.
        Map<String, Map<String, Long>> map4 = people.stream()
                .collect(Collectors.groupingBy(man -> man.getAddress().city(),
                        Collectors.groupingBy(man -> man.getAddress().street(),
                                Collectors.counting()
                        )
                ));

        map4.forEach((city, streetMap) -> {
            System.out.println("City: " + city);
            streetMap.forEach((street, count) -> {
                if (count > 4) {
                    System.out.println("  Street: " + street +
                            ", Address Count with More than 4 People: " + count);
                }
            });
        });

    }
}
