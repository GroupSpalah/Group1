package homeworks.sergii_khvostov.hw_2024.hw_14_01_24.task1;

public class DiscountStrategy {
    private DiscountService discountService;


    public DiscountService getDiscountServiceBySpecialEvent(String specialEvent, double price) {
        switch (specialEvent) {
            case "NewYear":
                discountService = new NewYearDiscountService(price);
                break;
            case "BirthDay":
                discountService = new BirthdayDiscountService(price);
                break;
            case "BlackFriday":
                discountService = new BlackFridayDiscountService(price);
                break;
            default:
                discountService = new DefaultDiscountService(price);
        }
        return discountService;
    }

    public void checkDiscount(DiscountService discountService) {
        double result = discountService.getDiscount();
        System.out.println(result);
    }
}
