package homeworks.dmytro_k.hw_2023.hw_23_04_23.task1;

import java.time.Month;

public class MonthPrice {
    private Month month;
    private float price;

    public MonthPrice(Month month, float price) {
        this.month = month;
        this.price = price;
    }

    public Month getMonth() {
        return month;
    }

    public float getPrice() {
        return price;
    }
}
