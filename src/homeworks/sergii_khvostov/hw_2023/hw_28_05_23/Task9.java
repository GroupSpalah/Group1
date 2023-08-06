package homeworks.sergii_khvostov.hw_2023.hw_28_05_23;

/*Create a Map that will store Employee name and salary.
   Write a logic to retrieve an employee who gets the highest salary.
   Output should be in the below format John Smith=$100000*/

import java.util.HashMap;
import java.util.Map;

public class Task9 {
    public static void main(String[] args) {
        Task9 task9 = new Task9();

        Map<String, Integer> map = new HashMap<>();
        map.put("John Smith", 1000);
        map.put("Bill Smith", 1100);
        map.put("Will Smith", 800);

        System.out.println(task9.doSalaryEmployee(map));
    }

    public String doSalaryEmployee(Map<String, Integer> map) {
        String employee = null;
        Integer hightSalary = 0;

        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue() > hightSalary) {
                hightSalary = entry.getValue();
                employee = entry.getKey();
            }
        }return employee + "=$" + hightSalary;

    }
}
