package homeworks.dmytro_k.hw_2023.hw_28_05_23;

import java.util.HashMap;
import java.util.Map;

/**
 * ++
 * 9) Create a Map that will store Employee name and salary.
 * Write a logic to retrieve an employee who gets the highest salary.
 * Output should be in the below format John Smith=$100000
 */

public class Task9 {

    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();
        map.put("John Smith", 1000);
        map.put("John Doe", 1100);
        map.put("Jack Nicholson", 800);

        System.out.println(maxSalary(map));
    }

    public static String maxSalary(Map<String, Integer> map) {

        String employee = "";
        int maxSalary = 0;

        for (Map.Entry<String, Integer> entry : map.entrySet())
            if (entry.getValue() > maxSalary) {
                maxSalary = entry.getValue();
                employee = entry.getKey();
            }

        return employee + "=$" + maxSalary;
    }
}
