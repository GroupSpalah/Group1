package lessons.streams;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Grouping {
    public static void main(String[] args) {
        List<ManMap> list = List.of(
                new ManMap("John", 31),
                new ManMap("John", 31),
                new ManMap("Ben", 28),
                new ManMap("Tom", 29)
        );

        Map<Integer, List<ManMap>> map = list
                .stream()
                .collect(Collectors.groupingBy(man -> man.age() % 2));

        Map<Integer, Long> map1 = list
                .stream()
                .collect(Collectors.groupingBy(man -> man.age() % 2, Collectors.counting()));

        Map<GroupByTwo, List<ManMap>> map2 = list
                .stream()
                .collect(Collectors.groupingBy(man -> new GroupByTwo(man.name(), man.age())));

        list
                .stream()
                .collect(Collectors.groupingBy(man -> new GroupByTwo(man.name(), man.age()),
                        Collectors.counting()))
                .entrySet()
                .stream()
                .filter(entry -> entry.getValue() == 2)
                .forEach(System.out::println);

        System.out.println();

    }
}

record GroupByTwo(String name, int age) {
}
