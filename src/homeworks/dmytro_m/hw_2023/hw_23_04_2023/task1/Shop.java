package homeworks.dmytro_m.hw_2023.hw_23_04_2023.task1;

import java.time.Month;

public class Shop {

    private Product1 product1;
    private Product2 product2;
    private Product3 product3;

    public Shop(Product1 product1, Product2 product2, Product3 product3) {
        this.product1 = product1;
        this.product2 = product2;
        this.product3 = product3;
    }

    public int getPrice(Month month, Products product) {
        return product.getSalary(month.getValue());
    }
}
