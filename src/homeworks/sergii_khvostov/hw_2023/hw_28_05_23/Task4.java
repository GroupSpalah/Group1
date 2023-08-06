package homeworks.sergii_khvostov.hw_2023.hw_28_05_23;

/*Modify and return the given map as follows: if the key "a" has a value, set the key "b" to have
that same value. In all cases remove the key "c", leaving the rest of the map unchanged.*/

import java.util.HashMap;
import java.util.Map;

public class Task4 {
    public static void main(String[] args) {
        Task4 task4 = new Task4();

        Map<String, Integer> map = new HashMap<>();
        map.put("a", 5);
        map.put("b", 2);
        map.put("c", 1);
        map.put("d", 1);

        System.out.println(task4.doModifyMap(map));
    }

    public Map<String, Integer> doModifyMap(Map<String, Integer> map) {
        if (map.containsKey("a") && map.containsKey("b") && map.get("a") != null) {
            map.put("b", map.get("a"));
        }
        map.remove("c");

        return map;
    }
}
