package homeworks.sergii_khvostov.hw_2023.hw_28_05_23;

/*Modify and return the given map as follows: if the keys "a" and "b"
have values that have different lengths, then set
"c" to have the longer value. If the values exist and have the same length,
change them both to the empty string in the map.*/

import java.util.HashMap;
import java.util.Map;

public class Task8 {
    public static void main(String[] args) {
        Task8 task8 = new Task8();

        Map<String, String> map = new HashMap<>();
        map.put("a", "aaaa");
        map.put("b", "bbb");

        System.out.println(task8.doModifyMap(map));
    }
    public Map<String, String> doModifyMap(Map<String, String> map) {
        String valueA = map.get("a");
        String valueB = map.get("b");

        if (valueA != null && valueB != null) {
            if (valueA.length() != valueB.length()) {
                String valueC = (valueA.length() > valueB.length()) ? valueA : valueB;
                map.put("c", valueC);
            } else {
                map.put("a", "");
                map.put("b", "");
            }
        }
        return map;
    }
}
