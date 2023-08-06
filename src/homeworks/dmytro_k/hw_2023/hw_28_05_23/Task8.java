package homeworks.dmytro_k.hw_2023.hw_28_05_23;

import java.util.Map;

/**
 * ++
 * 8) Modify and return the given map as follows: if the keys "a" and "b"
 * have values that have different lengths, then set
 * "c" to have the longer value. If the values exist and have the same length,
 * change them both to the empty string in the map.
 * Тернарник?
 */

public class Task8 {

    public Map<String, String> mapAB4(Map<String, String> map) {

        if (map.containsKey("a") && map.containsKey("b")) {
            String a = map.get("a");
            String b = map.get("b");

            int aLength = a.length();
            int bLength = b.length();

            if (aLength > bLength) {
                map.put("c", a);
            } else if (bLength > aLength) {
                map.put("c", b);
            } else if (aLength == bLength) {
                map.put("a", "");
                map.put("b", "");
            }
        }
        return map;
    }
}
