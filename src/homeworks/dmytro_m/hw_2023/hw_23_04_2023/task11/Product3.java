package homeworks.dmytro_m.hw_2023.hw_23_04_2023.task11;

import java.util.Map;
import java.util.TreeMap;

public class Product3 implements Product{
    private int price = 24;

    Map<String, Integer> map = new TreeMap<>();

    public Product3() {
        MyMonth month = new MyMonth();
        for (int i = 0, j = 1; i < 12; i++, j++) {
            map.put(month.arr[i], price + j);
        }
    }

    public void getPrice(String month) {
        System.out.println(map.get(month));
    }
}
