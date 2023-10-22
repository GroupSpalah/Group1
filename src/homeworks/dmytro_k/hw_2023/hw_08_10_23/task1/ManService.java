package homeworks.dmytro_k.hw_2023.hw_08_10_23.task1;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 1) Since 24/09/23
 * ++- Сгруппировать людей по количеству детей.
 * ++- Сгруппировать людей по количеству детей и возрасту.
 * ++- Сгруппировать людей по городу и названию улицы.
 * ++- Сгруппировать людей по городу и названию улицы и вывести количество адресов, где количество людей больше 4.
 */

public class ManService {

    List<Man> people = new LinkedList<>();

    public void add(Man man) {
        people.add(man);
    }

    public void groupingByCountOfChildren() {
        Map<Integer, List<Man>> map = people
                .stream()
                .collect(Collectors.groupingBy(Man::getCountOfChildren));
    }

    public void groupingByCountOfChildrenAndAge() {
        Map<ManGroupByAgeAndChildren, List<Man>> map = people
                .stream()
                .collect(Collectors
                        .groupingBy(man -> new ManGroupByAgeAndChildren(//возможно без создания рекорда. Посмотреть Серегину работу
                                man.getAge(),
                                man.getCountOfChildren())));
    }

    public void groupingByCityAndStreet() {
        Map<ManGroupByCityAndStreet, List<Man>> map = people
                .stream()
                .collect(Collectors
                        .groupingBy(man -> new ManGroupByCityAndStreet(
                                man
                                        .getADDRESS()
                                        .getCity(),
                                man
                                        .getADDRESS()
                                        .getStreet())));

        System.out.println(map);//для наглядности
    }

    public void groupingByCityAndStreetMore4() {
        people
                .stream()
                .collect(Collectors
                        .groupingBy(man -> new ManGroupByCityAndStreet(
                                        man
                                                .getADDRESS()
                                                .getCity(),
                                        man
                                                .getADDRESS()
                                                .getStreet()),
                                Collectors.counting()))
                .entrySet()
                .stream()
                .filter(entry -> entry.getValue() > 4)
                .forEach(System.out::println);
    }

    public void groupingByCityAndStreetMore4V2() {//отдельно для наглядности
        Map<ManGroupByCityAndStreet, Long> map =
                people
                        .stream()
                        .collect(Collectors
                                .groupingBy(man -> new ManGroupByCityAndStreet(
                                                man
                                                        .getADDRESS()
                                                        .getCity(),
                                                man
                                                        .getADDRESS()
                                                        .getStreet()),
                                        Collectors.counting()));
        map
                .entrySet()
                .stream()
                .filter(entry -> entry.getValue() > 4)
                .forEach(System.out::println);
    }
}
