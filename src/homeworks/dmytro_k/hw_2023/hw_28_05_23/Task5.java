package homeworks.dmytro_k.hw_2023.hw_28_05_23;

import java.util.Map;

/** ++
 * 5) Given a map of food keys and their topping values, modify
 * and return the map as follows: if the key "ice cream" has a value,
 * set that as the value for the key "yogurt" also. If the key "spinach"
 * has a value, change that value to "nuts".
 */

public class Task5 {
    public Map<String, String> topping2(Map<String, String> map) {

        if (map.containsKey("ice cream")) {

            String iceCream = map.get("ice cream");

            if (!iceCream.isEmpty()) {
                map.put("yogurt", iceCream);
            }
        }

        if (map.containsKey("spinach")) {

            if (!map.get("spinach").isEmpty()) {
                map.replace("spinach", "nuts");
            }
        }

        return map;
    }
}
