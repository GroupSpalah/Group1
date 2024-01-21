package homeworks.sergii_khvostov.hw_2024.hw_14_01_24.task1;

public class DiscountServiceTest {
    public static void main(String[] args) {
        DiscountStrategy ds = new DiscountStrategy();

        DiscountService newYearDiscount =
                ds.getDiscountServiceBySpecialEvent("NewYear", 100);
        ds.checkDiscount(newYearDiscount);

        DiscountService birthDayDiscount =
                ds.getDiscountServiceBySpecialEvent("BirthDay", 200);
        ds.checkDiscount(birthDayDiscount);

        DiscountService blackFridayDiscount =
                ds.getDiscountServiceBySpecialEvent("BlackFriday", 300);
        ds.checkDiscount(blackFridayDiscount);

        DiscountService defaultDiscount =
                ds.getDiscountServiceBySpecialEvent("default", 500);
        ds.checkDiscount(defaultDiscount);
    }
}
