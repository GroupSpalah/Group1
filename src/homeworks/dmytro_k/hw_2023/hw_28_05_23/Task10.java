package homeworks.dmytro_k.hw_2023.hw_28_05_23;

import java.util.HashMap;
import java.util.Map;

/**
 * ++
 * 10) Create a map of Best Buy store.
 * Place item id and item name into it. Example (7664847 = Printer, 7879885= TV etc)
 * Retrieve all keys and values from a Best Buy map using EntrySet.
 */

public class Task10 {
    public static void main(String[] args) {
        Map<Integer, String> map = new HashMap<>();
        map.put(7664847, "printer");
        map.put(7879885, "TV");
        map.put(7825698, "audio player");
        map.put(5569856, "PC");

        System.out.println(map.entrySet());
    }
}
