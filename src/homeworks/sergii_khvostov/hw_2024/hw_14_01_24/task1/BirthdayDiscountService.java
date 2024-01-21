package homeworks.sergii_khvostov.hw_2024.hw_14_01_24.task1;

public class BirthdayDiscountService implements DiscountService {
    private double price;

    public BirthdayDiscountService(double price) {
        this.price = price;
    }

    @Override
    public double getDiscount() {
        return price * 0.33;
    }
}
