package homeworks.sergii_khvostov.hw_2024.hw_14_01_24.task1;

public class DefaultDiscountService implements DiscountService {
    private double price;

    public DefaultDiscountService(double price) {
        this.price = price;
    }

    @Override
    public double getDiscount() {
        return price;
    }
}
