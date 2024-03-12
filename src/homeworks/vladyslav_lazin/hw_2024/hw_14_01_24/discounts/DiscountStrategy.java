package homeworks.vladyslav_lazin.hw_2024.hw_14_01_24.discounts;

public class DiscountStrategy {
    public DiscountService getDiscountServiceBySpecialEvent(String specialEvent) {
        return switch (specialEvent) {
            case "New Year" -> new NewYearDiscountService();
            case "Birthday" -> new BirthdayDiscountService();
            case "Black Friday" -> new BlackFridayDiscountService();
            default -> new DefaultDiscountService();
        };
    }
}
