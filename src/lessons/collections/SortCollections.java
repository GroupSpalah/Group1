package lessons.collections;

import java.util.*;

public class SortCollections {
    public static void main(String[] args) {
        List<Integer> aList = new LinkedList<>();

        aList.add(5);
        aList.add(8);
        aList.add(9);
        aList.add(6);

        Collections.sort(aList);

//        System.out.println(aList);

        List<String> strings = new LinkedList<>(List.of("John", "Jodrey", "Ben"));

        Collections.sort(strings);

//        System.out.println(strings);

        List<SortMan> men = new LinkedList<>(List.of(
                new SortMan("Jahn", 25),
                new SortMan("Jack", 25),
                new SortMan("Ben", 30)
        ));


        Comparator<SortMan> comparatorAge = (m1, m2) -> Integer.compare(m1.age(), m2.age());
        Comparator<SortMan> comparatorName = (m1, m2) -> m1.name().compareTo(m2.name());

//        Collections.sort(men, comparatorAge.reversed());
        Collections.sort(men, comparatorAge.thenComparing(comparatorName));

        System.out.println(men);
    }
}

record SortMan(String name, int age) implements Comparable<SortMan> {
    @Override
    public int compareTo(SortMan o) {
        return Integer.compare(o.age, this.age);
    }
}