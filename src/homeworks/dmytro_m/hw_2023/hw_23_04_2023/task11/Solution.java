package homeworks.dmytro_m.hw_2023.hw_23_04_2023.task11;

public class Solution {
    public static void main(String[] args) {
        Product1 product1 = new Product1();
        Product2 product2 = new Product2();
        Product3 product3 = new Product3();

        Shop shop = new Shop(product1, product2, product3);
        shop.getPrice(product1, "Jan");
        shop.getPrice(product2, "Jan");
        shop.getPrice(product3, "Jan");

    }
}
//1) Product and price tasks
//    у вас есть номера списка для заполнения таблицы цен показанным способом:

//реализовать метод java, который получает этот список и возвращает этот объект,
//        который будет удобен для поиска цены с использованием месяцев и ключей продукта
