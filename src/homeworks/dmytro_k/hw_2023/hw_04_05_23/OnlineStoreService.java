package homeworks.dmytro_k.hw_2023.hw_04_05_23;

public class OnlineStoreService {
    public static void main(String[] args) {

        /** Создаем товары **/

        Product Iphone14 = new Product("Iphone 14 4/256", "Apple", "25.05.2022",
                Category.PHONE, SubCategory.CHARGER, 49999);

        Product Iphone13 = new Product("Iphone 13 3/256", "Apple", "25.05.2021",
                Category.PHONE, SubCategory.CHARGER, 38999);

        Product Iphone11 = new Product("Iphone 11 4/128", "Apple", "25.05.2020",
                Category.PHONE, SubCategory.CHARGER, 20999);

        Product Charger10W = new Product("Xiaomi Charger 10W", "Xiaomi", "25.05.2021",
                Category.CHARGER, SubCategory.PHONE, 400);

        Product Charger33W = new Product("Samsung Charger 33W", "Samsung", "27.08.2022",
                Category.CHARGER, SubCategory.PHONE, 750);

        Product Charger67W = new Product("Xiaomi Charger 10W", "Xiaomi", "20.02.2023",
                Category.CHARGER, SubCategory.PHONE, 1500);

        /** Создаем списки и наполняем их товарами **/

        ProductList phone = new ProductList();

        phone.addProduct(Iphone11);
        phone.addProduct(Iphone13);
        phone.addProduct(Iphone14);

        ProductList charger = new ProductList();

        charger.addProduct(Charger33W);
        charger.addProduct(Charger67W);
        charger.addProduct(Charger10W);

        /** Добавляем списки товаров в общий ассортимент **/

        Range range = new Range();

        range.addProducts(charger);
        range.addProducts(phone);


        /** Создаем клиента **/

        //Basket basket1 = new Basket();//не нужна, создана по умолчанию
        Client Jack = new Client("Jack111", "123456789");

        /** наполняем корзину **/

        Jack.addItem(Charger10W);
        Jack.addItem(Iphone11);
        Jack.addItem(Charger67W);

        /** покупаем товар **/

        Jack.buy();

        /** наполняем корзину **/

        Jack.addItem(Charger10W);

        /** покупаем товар **/

        Jack.buy();

    }
}
