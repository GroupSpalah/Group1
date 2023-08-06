package homeworks.dmytro_k.hw_2023.hw_28_05_23;

import java.util.Map;

/** ++
 * 4) Modify and return the given map as follows: if the key "a" has
 * a value, set the key "b" to have that same value. In all cases
 * remove the key "c", leaving the rest of the map unchanged.*/

public class Task4 {

    public Map<String, String> mapShare(Map<String, String> map) {

        map.remove("c");

        if (!map.containsKey("b")) {
            map.put("b", "");
        }

            String a = map.get("a");
            String b = map.get("b");
            if (!a.isEmpty()){
                map.replace("b", a);
            }

        return map;
    }
}
