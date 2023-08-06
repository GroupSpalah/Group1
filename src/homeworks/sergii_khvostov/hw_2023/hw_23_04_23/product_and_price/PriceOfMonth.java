package homeworks.sergii_khvostov.hw_2023.hw_23_04_23.product_and_price;

public class PriceOfMonth {
    private final String month;
    private final int price;

    public PriceOfMonth(String month, int price) {
        this.month = month;
        this.price = price;
    }

    public String getMonth() {
        return month;
    }

    public int getPrice() {
        return price;
    }
}

