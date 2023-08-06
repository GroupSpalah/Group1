package homeworks.dmytro_k.hw_2023.hw_28_05_23;

import java.util.Map;

/** ++
 * 2) Given a map of food keys and topping values,
 * modify and return the map as follows: if the
 * key "ice cream" is present, set its value to "cherry". In all cases,
 * set the key "bread" to have the value "butter".
 */

public class Task2 {
    public void topping1(Map<String, String> map) {

        if (map.containsKey("ice cream")) {
            map.replace("ice cream", "cherry");
        }

        map.put("bread", "butter");
    }
}
