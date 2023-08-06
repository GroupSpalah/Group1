package homeworks.dmytro_k.hw_2023.hw_28_05_23;

import java.util.Map;

/** ++
 * 6) Modify and return the given map as follows: if exactly one of
 * the keys "a" or "b" has a value in the map (but not both),
 * set the other to have that same value in the map.
 */

public class Task6 {

    public Map<String, String> mapAB3(Map<String, String> map) {

        if (!map.containsKey("a") && map.containsKey("b")) {
            map.put("a", "");
        }

        if (!map.containsKey("b") && map.containsKey("a")) {
            map.put("b", "");
        }

        if (map.containsKey("a") && map.containsKey("b")) {

            String a = map.get("a");
            String b = map.get("b");

            if (!a.isEmpty() && !b.isEmpty()) {
                return map;
            }

            if (!a.isEmpty()) {
                map.put("b", a);
            }

            if (!b.isEmpty()) {
                map.put("a", b);
            }
        }

        return map;
    }
}
