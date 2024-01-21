package homeworks.sergii_khvostov.hw_2024.hw_14_01_24.task1;

public class BlackFridayDiscountService implements DiscountService {
    private double price;

    public BlackFridayDiscountService(double price) {
        this.price = price;
    }

    @Override
    public double getDiscount() {
        return price * 0.45;
    }
}
