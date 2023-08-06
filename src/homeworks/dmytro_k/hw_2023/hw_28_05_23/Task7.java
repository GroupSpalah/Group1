package homeworks.dmytro_k.hw_2023.hw_28_05_23;

import java.util.Map;

/**
 * ++
 * 7) Given a map of food keys and topping values, modify
 * and return the map as follows: if the key "potato" has a value,
 * set that as the value for the key "fries". If the key "salad" has a
 * value, set that as the value for the key "spinach".
 */

public class Task7 {

    public Map<String, String> topping3(Map<String, String> map) {

        if (map.containsKey("potato")) {

            String potato = map.get("potato");

            if (!potato.isEmpty()) {
                map.put("fries", potato);
            }
        }

        if (map.containsKey("salad")) {

            String salad = map.get("salad");

            if (!salad.isEmpty()) {
                map.put("spinach", salad);
            }
        }

        return map;
    }
}
