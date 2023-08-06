package homeworks.sergii_khvostov.hw_2023.hw_28_05_23;

/*Create a map of Best Buy store.
  Place item id and item name into it. Example (7664847 = Printer, 7879885= TV etc)
  Retrieve all keys and values from a Best Buy map using EntrySet.*/

import java.util.HashMap;
import java.util.Map;

public class Task10 {
    public static void main(String[] args) {
        Map<Integer, String> map = new HashMap<>();
        map.put(745223562, "printer");
        map.put(165416161, "tv");
        map.put(651651661, "audio");
        map.put(915125122, "fax");

        System.out.println(map.entrySet());
    }
}
