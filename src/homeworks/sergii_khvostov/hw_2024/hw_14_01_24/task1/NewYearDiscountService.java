package homeworks.sergii_khvostov.hw_2024.hw_14_01_24.task1;

public class NewYearDiscountService implements DiscountService {
    private double price;

    public NewYearDiscountService(double price) {
        this.price = price;
    }

    @Override
    public double getDiscount() {
        return price * 0.2;
    }
}
