package homeworks.vladyslav_lazin.hw_2023.hw_24_09_23;

import homeworks.vladyslav_lazin.hw_2023.hw_24_09_23.entity.Man;
import homeworks.vladyslav_lazin.hw_2023.hw_24_09_23.group.GroupByChildrenNuber;
import homeworks.vladyslav_lazin.hw_2023.hw_24_09_23.group.GroupByChildrenNumbeAndAge;
import homeworks.vladyslav_lazin.hw_2023.hw_24_09_23.group.GroupByCityAndStreet;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ManService {
    private void printGroupinResult(Map<?, List<Man>> groupedMen) {
        groupedMen.forEach((groupOject, menList) -> {
            System.out.println(groupOject);
            menList.forEach(System.out::println);
        });
    }

    public void groupByChildrenNumber(Stream<Man> menStream) {
        // Сгруппировать людей по количеству детей.
        Map<GroupByChildrenNuber, List<Man>> menByCildren = menStream
                .collect(Collectors.groupingBy(man -> new GroupByChildrenNuber(man.getChildrenNumber())));
        printGroupinResult(menByCildren);
    }

    public void groupByCildrenNumberAndAge(Stream<Man> menStream) {
        //Сгруппировать людей по количеству детей и возрасту.
        Map<GroupByChildrenNumbeAndAge, List<Man>> menByChildrenNumberAndAge = menStream
                .collect(Collectors.groupingBy(man -> new GroupByChildrenNumbeAndAge(man.getChildrenNumber(), man.getAge())));
        printGroupinResult(menByChildrenNumberAndAge);
    }
    public void groupByCityAndStreet(Stream<Man> menStream) {
        //Сгруппировать людей по городу и названию улицы.
        Map<GroupByCityAndStreet, List<Man>> menByCityAndStreet = menStream
                .collect(Collectors.groupingBy(man -> new GroupByCityAndStreet(man.getAddress().getCity(), man.getAddress().getStreet())));
        printGroupinResult(menByCityAndStreet);
    }
    public void getAddressNumberMoreThanFour(Stream<Man> menStream) {
        //Сгруппировать людей по городу и названию улицы и вывести количество адресов,где количество людей больше 4.
        Map<GroupByCityAndStreet, Long> menByCityAndStreet = menStream
                .collect(Collectors.groupingBy(man -> new GroupByCityAndStreet(man.getAddress().getCity(), man.getAddress().getStreet()),
                        Collectors.counting()));
        menByCityAndStreet
                .entrySet()
                .stream()
                .filter(entry -> entry.getValue() > 4)
                .forEach(System.out::println);
    }
}
