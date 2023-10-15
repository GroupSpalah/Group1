package homeworks.vladyslav_lazin.hw_2023.hw_24_09_23;

import homeworks.vladyslav_lazin.hw_2023.hw_24_09_23.entity.Address;
import homeworks.vladyslav_lazin.hw_2023.hw_24_09_23.entity.Man;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class GroupingTest {
    private static final ManService manService = new ManService();
    public static void main(String[] args) {
        Stream<Man> menStream = Stream.of(
                new Man("Jean", "Jarre", 23, 1, new Address("Canada", "Quebec", "Rue Flaubert",4)),
                new Man("John", "Doe", 19, 0, new Address("Canada", "Toronto", "Abbey Road", 3)),
                new Man("Jack", "Furnier", 52, 2, new Address("Canada", "Quebec", "Rue Flaubert",12)),
                new Man("Ben", "Smith", 32, 2, new Address("USA", "New York", "Washington street", 12)),
                new Man("Frank", "Bacon", 38, 1, new Address("Canada", "Quebec", "Rue Flaubert",21)),
                new Man("Vasya", "Pupkin", 23, 1, new Address("Russia", "Moscow", "Lenina street", 45)),
                new Man("Enzo", "Carlucci", 31, 0, new Address("Canada", "Quebec", "Rue Flaubert",5)),
                new Man("Mario", "Cipolini", 55, 6, new Address("Italy", "Milan", "Fortunato street", 17)),
                new Man("Paul", "Carpenter", 43, 5, new Address("Great Britain", "Leeds", "Craven road", 23)),
                new Man("Taras", "Chornyi", 23, 1, new Address("Ukraine", "Chernihiv", "Prospect Peremohy", 10)),
                new Man("Stevie", "Ray", 52, 4, new Address("Australia", "Melburn", "Kings road", 32)),
                new Man("Vincent", "Furnier", 25, 2, new Address("Canada", "Quebec", "Rue Flaubert",45))
        );
        manService.getAddressNumberMoreThanFour(menStream);
    }
}
