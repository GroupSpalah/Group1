package homeworks.sergii_khvostov.hw_2023.hw_24_09_23.task2;

import org.apache.commons.lang3.tuple.Pair;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ManGroupingVar2 {
    public static void main(String[] args) {
        List<Man> people = new LinkedList<>();
        people.add(new Man("John", "Doe", 25, 2,
                new Address("US", "New York", "Broadway", 123)));
        people.add(new Man("Alice", "Smith", 30, 1,
                new Address("Canada", "Toronto", "Maple St", 3)));
        people.add(new Man("Bob", "Johnson", 22, 0,
                new Address("Canada", "Montreal", "Oak St", 5)));

        //- Сгруппировать людей по количеству детей.
        Map<Integer, List<Man>> map1 = people.stream()
                .collect(Collectors.groupingBy(Man::getCountOfChildren));

        map1.forEach((childrenCount, manList) -> {
            System.out.println("People with " + childrenCount + " children:");
            manList.forEach(man -> System.out.println(man.getFirstName() + " " + man.getLastName()));
            System.out.println();
        });


        //- Сгруппировать людей по количеству детей и возрасту.
        Map<Pair<Integer, Integer>, List<Man>> map = people.stream()
                .collect(Collectors.groupingBy(man -> Pair.of(man.getCountOfChildren(),
                        man.getAge())));

        map.forEach((key, group) -> System.out.println("Count of children: " + key.getLeft() +
                ", Age: " + key.getRight() + " :" + group));
        System.out.println();

        //- Сгруппировать людей по городу и названию улицы.
        Map<Pair<String, String>, List<Man>> map2 = people.stream()
                .collect(Collectors.groupingBy(man -> Pair.of(man.getAddress().city(),
                        man.getAddress().street())));

        map2.forEach((key, group) -> System.out.println("City: " + key.getLeft() + ", Street: " +
                key.getRight() + " : " + group));

        //- Сгруппировать людей по городу и названию улицы и вывести количество адресов,
        //  где количество людей больше 4.
        Map<Pair<String, String>, Long> map3 = people.stream()
                .collect(Collectors.groupingBy(
                        man -> Pair.of(man.getAddress().city(), man.getAddress().street()),
                        Collectors.counting()
                ));

        map3.forEach((key, count) -> {
            if (count > 4) {
                System.out.println("City: " + key.getLeft() + ", Street: " + key.getRight() +
                        ", More 4 people: " + count);
            }
        });
    }
}
