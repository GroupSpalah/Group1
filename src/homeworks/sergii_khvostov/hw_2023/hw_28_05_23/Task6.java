package homeworks.sergii_khvostov.hw_2023.hw_28_05_23;

/*Modify and return the given map as follows: if exactly one of
the keys "a" or "b" has a value in the map (but not both),
set the other to have that same value in the map.*/

import java.util.HashMap;
import java.util.Map;

public class Task6 {
    public static void main(String[] args) {
        Task6 task6 = new Task6();

        Map<String, String> map = new HashMap<>();
        map.put("a", null);
        map.put("b", "bbb");
        map.put("c", "ccc");
        map.put("d", "ddd");

        System.out.println(task6.doCheckDish(map));
    }

    public Map<String, String> doCheckDish(Map<String, String> map) {
        if (map.get("a") != null && map.get("b") == null) {
            map.put("b", map.get("a"));
        }
        if (map.get("a") == null && map.get("b") != null) {
            map.put("a", map.get("b"));
        }

        return map;
    }
}
