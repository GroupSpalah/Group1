package homeworks.sergii_khvostov.hw_2023.hw_28_05_23;

/*Given a map of food keys and topping values, modify and return the map as follows: if the
   key "ice cream" is present, set its value to "cherry". In all cases,
   set the key "bread" to have the value "butter".*/

import java.util.HashMap;
import java.util.Map;

public class Task2 {
    public static void main(String[] args) {
        Task2 task2 = new Task2();

        Map<String, String> map = new HashMap<>();
        map.put("ice cream", "peanuts");
        map.put("bread", "meat");
        map.put("pancake", "syrup");

        Map<String, String> result = task2.doCheckDish(map);

        System.out.println(result);

    }

    public Map<String, String> doCheckDish(Map<String, String> map) {
        if (map.containsKey("ice cream")) {
            map.put("ice cream", "cherry");
        }

        map.put("bread", "butter");

        return map;
    }
}




