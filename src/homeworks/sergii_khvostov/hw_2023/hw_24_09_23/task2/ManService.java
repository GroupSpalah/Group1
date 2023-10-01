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

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

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
    }
}
