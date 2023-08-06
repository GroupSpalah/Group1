package homeworks.dmytro_k.hw_2023.hw_23_04_23.task1;

import java.time.Month;

public class ProductListTest {
    public static void main(String[] args) {
        Product product1 = new Product("A");
        Product product2 = new Product("B");
        Product product3 = new Product("C");
        Product product4 = new Product("D");

        MonthPrice aprilPrice = new MonthPrice(Month.APRIL, 100);
        MonthPrice marchPrice = new MonthPrice(Month.MARCH, 3500);
        MonthPrice augustPrice = new MonthPrice(Month.AUGUST, 250);
        MonthPrice decemberPrice = new MonthPrice(Month.DECEMBER, 2500);
        MonthPrice januaryPrice = new MonthPrice(Month.JANUARY, 10000);
        MonthPrice februaryPrice = new MonthPrice(Month.FEBRUARY, 11000);
        MonthPrice junePrice = new MonthPrice(Month.JUNE, 170);
        MonthPrice julyPrice = new MonthPrice(Month.JULY, 1300);
        MonthPrice novemberPrice = new MonthPrice(Month.NOVEMBER, 10500);
        MonthPrice mayPrice = new MonthPrice(Month.MAY, 1090);

        product1.addPrice(aprilPrice);
        product1.addPrice(augustPrice);
        product1.addPrice(junePrice);

        product2.addPrice(marchPrice);
        product2.addPrice(decemberPrice);

        product3.addPrice(mayPrice);
        product3.addPrice(julyPrice);

        product4.addPrice(novemberPrice);
        product4.addPrice(januaryPrice);
        product4.addPrice(februaryPrice);

        ProductList productList = new ProductList();

        productList.addProduct(product1);
        productList.addProduct(product2);
        productList.addProduct(product3);
        productList.addProduct(product4);

        float aPrice = productList.getPrice("A", Month.APRIL);
        float bPrice = productList.getPrice("B", Month.DECEMBER);
        float cPrice = productList.getPrice("C", Month.MAY);
        float dPrice = productList.getPrice("D", Month.JANUARY);

        System.out.println(aPrice);
        System.out.println(bPrice);
        System.out.println(cPrice);
        System.out.println(dPrice);
    }
}
