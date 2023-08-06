package homeworks.dmytro_m.hw_2023.hw_23_04_2023.task11;

public class Shop {

    private Product1 product1;
    private Product2 product2;
    private Product3 product3;

    public Shop(Product1 product1, Product2 product2, Product3 product3) {
        this.product1 = product1;
        this.product2 = product2;
        this.product3 = product3;
    }

    public void getPrice(Product productInt, String month) {
        if(productInt instanceof Product1 product) {
            product.getPrice(month);
        }
        if(productInt instanceof Product2 product) {
            product.getPrice(month);
        }
        if(productInt instanceof Product3 product) {
            product.getPrice(month);
        }
    }
}
