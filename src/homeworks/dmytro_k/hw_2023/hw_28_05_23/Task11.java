package homeworks.dmytro_k.hw_2023.hw_28_05_23;

import java.util.HashMap;
import java.util.Map;

/**
 * 11) Create a map of a building. Store floor number and it is associated company name.
 * (Example: 1= Google, 2=Syntax etc..).
 * Insert 7 entries with duplicate keys and values.++
 * Check how many entries you have? Update company on a 4th floor++
 * Remove company on the 7th floor++
 * Print your map++
 */

public class Task11 {
    public static void main(String[] args) {
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "Google");
        map.put(2, "Syntax");
        map.put(3, "Microsoft");
        map.put(4, "Apple");
        map.put(5, "Intel");
        map.put(6, "Amazon");
        map.put(7, "Microsoft");
        map.put(1, "Google");
        map.put(2, "Syntax");
        map.put(3, "Microsoft");
        map.put(4, "Apple");
        map.put(5, "Intel");
        map.put(6, "Amazon");
        map.put(7, "Microsoft");

        System.out.println(map.size());

        map.put(4, "Oracle");

        map.remove(7);

        System.out.println(map);
    }
}
