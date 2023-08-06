package homeworks.dmytro_m.hw_2023.hw_16_04_2023.task1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Task3 {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        Collections.addAll(list, "Ukraine", "United Kingdom", "Australia", "USA");
        for (String s : list) {
            if (s.toUpperCase().endsWith("A")) {
                System.out.println(s);
            }
        }
    }
}
