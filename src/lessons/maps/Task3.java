package lessons.maps;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * Modify and return the given map as follows: if
 * the key "a" has a value, set the key "b"
 * to have that value, and set the key "a" to have the value "".
 */
public class Task3 {
    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();

        String valueA = map.get("a");

        if (Objects.nonNull(valueA)) {
            map.put("b", valueA);
            map.put("a", "");
        }
    }
}
