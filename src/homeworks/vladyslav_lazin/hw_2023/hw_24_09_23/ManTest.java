package homeworks.vladyslav_lazin.hw_2023.hw_24_09_23;

import homeworks.vladyslav_lazin.hw_2023.hw_24_09_23.entity.Address;
import homeworks.vladyslav_lazin.hw_2023.hw_24_09_23.entity.Man;

import java.util.LinkedList;
import java.util.List;

public class ManTest {
    public static void main(String[] args) {
        List<Man> menList = new LinkedList<>();

        menList.add(new Man("John", "Doe", 19, 0, new Address("Canada", "Toronto", "Abbey Road", 3)));
        menList.add(new Man("Ben", "Smith", 32, 2, new Address("USA", "New York", "Washington street", 12)));
        menList.add(new Man("Vasya", "Pupkin", 23, 1, new Address("Russia", "Moscow", "Lenina street", 45)));
        menList.add(new Man("Mario", "Cipolini", 55, 6, new Address("Italy", "Milan", "Fortunato street", 17)));
        menList.add(new Man("Paul", "Carpenter", 43, 5, new Address("Great Britain", "Lids", "Craven road", 23)));
        menList.add(new Man("Taras", "Chornyi", 23, 1, new Address("Ukraine", "Chernihiv", "Prospect Peremohy", 10)));menList.add(new Man("John", "Doe", 21, 0, new Address("Canad", "Toronto", "Abbey Road", 5)));
        menList.add(new Man("Stiev", "Ray", 52, 4, new Address("Australia", "Melburn", "Kings road", 32)));
        menList.add(new Man("Vincent", "Furnier", 25, 2, new Address("Canada", "Quebec", "Rue Flaubert",45)));

        //Вывести информацию о всех людях.
        menList.stream().forEach(System.out::println);

        //Вывести информацию о всех адресах.
        menList.stream().forEach(element -> System.out.println(element.getAddress()));

        //Вывести firstName, lastName, countOfChildren, когда возраст более или равно 20 и отсортировать по firstName.
        menList.stream().filter(element -> element.getAge() > 20)
            .sorted((x,y) -> x.getName().compareTo(y.getName()))
            .forEach(element -> System.out.println(element.getName() + " " + element.getSurname() + " " + element.getChildrenNumber()));
        
        //Изменить firstName = 'John', lastName = 'Kennedi', countOfChildren = 3, когда country == 'US' (or another country).
        menList.stream().map(man -> {
            if ("USA".equals(man.getAddress().getCountry())) {
                man.setName("John");
                man.setSurname("Kennedy");
                man.setChildrenNumber(3);
            }
            return man;
        }).forEach(System.out::println);

        //Вывести firstName, lastName, nameOfStreet, когда country == 'Canada' AND numberOfHome == 3 OR age >= 25"
        menList.stream()
            .filter(man -> man.getAddress().getCountry().equals("Canada") 
                && man.getAddress().getHouseNumber() == 3
                || man.getAge() == 25)
            .forEach(man -> System.out.println(man.getName() + " " + man.getSurname() + " " + man.getAddress().getStreet()));

    }
}
