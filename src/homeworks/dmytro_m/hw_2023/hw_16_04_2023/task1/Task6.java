package homeworks.dmytro_m.hw_2023.hw_16_04_2023.task1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Task6 {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(Arrays.asList(10, 20, 30, 40));
        list.replaceAll(integer -> integer + 10);
        list.forEach(s -> System.out.println(s));
        list.forEach(System.out::println);
    }
}
