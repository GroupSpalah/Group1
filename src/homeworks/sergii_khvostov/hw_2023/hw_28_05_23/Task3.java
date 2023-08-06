package homeworks.sergii_khvostov.hw_2023.hw_28_05_23;

/*Modify and return the given map as follows:
if the keys "a" and "b" are both in the map and have equal values, remove them both.*/

import java.util.HashMap;
import java.util.Map;

public class Task3 {
    public static void main(String[] args) {
        Task3 task3 = new Task3();
        Map<String, Integer> map = new HashMap<>();
        map.put("a", 1);
        map.put("b", 1);
        map.put("c", 2);

        Map<String, Integer> result = task3.doDeleteSameValue(map);

        System.out.println(result);
    }

    public Map<String, Integer> doDeleteSameValue(Map<String, Integer> map) {
        if (map.containsKey("a") && map.containsKey("b") && map.get("a").equals(map.get("b"))) {
            map.remove("a");
            map.remove("b");
        }
        return map;
    }
}
