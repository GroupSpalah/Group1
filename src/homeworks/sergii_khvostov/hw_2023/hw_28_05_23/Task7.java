package homeworks.sergii_khvostov.hw_2023.hw_28_05_23;

/*Given a map of food keys and topping values, modify
and return the map as follows: if the key "potato" has a value,
set that as the value for the key "fries". If the key "salad" has a
value, set that as the value for the key "spinach"*/

import java.util.HashMap;
import java.util.Map;

public class Task7 {
    public static void main(String[] args) {
        Task7 task7 = new Task7();

        Map<String, String> map = new HashMap<>();
        map.put("potato", "sauce");
        map.put("fries", "mayonnaise");
        map.put("salad", "salt");
        map.put("spinach", "pepper");

        System.out.println(task7.doModifyMap(map));
    }

    public Map<String, String> doModifyMap(Map<String, String> map) {
        if (map.containsKey("potato") && map.get("potato") != null) {
            map.put("fries", map.get("potato"));
        }
        if (map.containsKey("salad") && map.get("salad") != null) {
            map.put("spinach", map.get("salad"));
        }
        return map;
    }
}
