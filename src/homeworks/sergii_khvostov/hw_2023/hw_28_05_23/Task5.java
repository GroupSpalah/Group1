package homeworks.sergii_khvostov.hw_2023.hw_28_05_23;

/*Given a map of food keys and their topping values, modify
and return the map as follows: if the key "ice cream" has a value,
set that as the value for the key "yogurt" also. If the key "spinach"
has a value, change that value to "nuts"*/

import java.util.HashMap;
import java.util.Map;

public class Task5 {
    public static void main(String[] args) {
        Task5 task5 = new Task5();

        Map<String, String> map = new HashMap<>();
        map.put("ice cream", "cherry");
        map.put("yogurt", "orange");
        map.put("spinach", "meat");

        System.out.println(task5.doCheckDish(map));
    }

    public Map<String, String> doCheckDish(Map<String, String> map) {
        if (map.containsKey("ice cream") && map.get("ice cream") != null) {
            map.put("yogurt", map.get("ice cream"));
        }

        if (map.containsKey("spinach") && map.get("spinach") != null) {
            map.put("spinach", "nuts");
        }

        return map;
    }
}
