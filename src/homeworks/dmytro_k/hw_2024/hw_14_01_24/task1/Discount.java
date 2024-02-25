package homeworks.dmytro_k.hw_2024.hw_14_01_24.task1;

public class Discount implements DiscountService { // неправильно

    private int getDefaultDiscountService = 0;
    private int getNewYearDiscountService = 20;
    private int getBirthdayDiscountService = 33;
    private int getBlackFridayDiscountService = 45;


    @Override
    public double getDiscount() {
        return 0;
    }
}
