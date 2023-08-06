package homeworks.dmytro_k.hw_2023.hw_04_05_23_v2;

public class OnlineStoreTest {
    public static void main(String[] args) {

        /** Создаем товары **/

        Product iphone14 = new Product("Iphone 14 4/256", "Apple", "25.05.2022",
                Category.PHONE, SubCategory.SMARTPHONE, 49999, 15);

        Product xiaomiRedmi12Pro = new Product("Xiaomi Redmi 12 Pro 4/256", "Xiaomi",
                "21.10.2022", Category.PHONE, SubCategory.SMARTPHONE, 49999, 50);

        Product iphone13 = new Product("Iphone 13 3/256", "Apple", "25.05.2021",
                Category.PHONE, SubCategory.SMARTPHONE, 38999, 25);

        Product iphone11 = new Product("Iphone 11 4/128", "Apple", "25.05.2020",
                Category.PHONE, SubCategory.SMARTPHONE, 20999, 30);

        Product charger10W = new Product("Xiaomi Charger 10W", "Xiaomi", "25.05.2021",
                Category.CHARGER, SubCategory.QUICKCHARGER, 400, 100);

        Product charger33W = new Product("Samsung Charger 33W", "Samsung", "27.08.2022",
                Category.CHARGER, SubCategory.QUICKCHARGER, 750, 30);

        Product charger67W = new Product("Xiaomi Charger 67W", "Xiaomi", "20.02.2023",
                Category.CHARGER, SubCategory.QUICKCHARGER, 1500, 20);

        /** Создаем список и наполняем его товарами **/

        ProductService productRange = new ProductService();

        productRange.addProduct(iphone11);
        productRange.addProduct(iphone13);
        productRange.addProduct(iphone14);
        productRange.addProduct(xiaomiRedmi12Pro);

        productRange.addProduct(charger33W);
        productRange.addProduct(charger67W);
        productRange.addProduct(charger10W);

        productRange.removeProduct(iphone13);


        //productRange.getProductByNameFor("Iphone 13 3/256");
        System.out.println("-------");

        //productRange.printProduct();
        productRange.printProduct(SubCategory.QUICKCHARGER);


        /** Создаем клиента **/

        Client Jack = new Client("Jack111");

        /** наполняем корзину **/

        Jack.addItem(charger10W, productRange);
        Jack.addItem(iphone11, productRange);
        Jack.addItem(iphone11, productRange);
        Jack.addItem(iphone11, productRange);
        Jack.addItem(charger67W, productRange);//20 + 1 количество товаров в корзине
        Jack.addItem(charger67W, productRange);//20 + 1 количество товаров в корзине
        Jack.addItem(charger67W, productRange);//20 + 1 количество товаров в корзине
        Jack.addItem(charger67W, productRange);//20 + 1 количество товаров в корзине

        //productRange.getProductByNameFor("Xiaomi Charger 10W");

        System.out.println("===");

        Jack.getBasketContents();

        /** покупаем товар **/

        Jack.buy();

    }
}
