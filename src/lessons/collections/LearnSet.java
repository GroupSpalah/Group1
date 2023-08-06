package lessons.collections;

import java.util.*;

public class LearnSet {
    public static void main(String[] args) {
//        Set<Integer> set = new HashSet<>();
        Set<Integer> set = new LinkedHashSet<>();

        set.add(8);
        set.add(5);
        set.add(7);
        set.add(3);
        set.add(5);

//        System.out.println(set);

        List<Integer> integers2 = List.of(4, 7, 8, 2, 4);

        List<Integer> integers = new ArrayList<>(integers2);

        Set<Integer> set1 = new HashSet<>(integers);

        List<Integer> integers1 = new ArrayList<>(set1);

    }
}
