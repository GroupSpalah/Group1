package homeworks.dmytro_k.hw_2023.hw_13_08_23.task2;

/**
 * ++Товар(название, дата производства, производитель, хрупкость, цена),
 * ++Производитель товара(название фирмы, страна производства).
 * <p>
 * Выбрать товары:
 * 1) Одного производителя по названию, хрупкие
 * 2) Хрупкие
 * 3) Товары, цена которых лежит в определенном промежутке.
 */

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class ProductTest {
    public static void main(String[] args) {

        Manufacturer Apple = new Manufacturer("Apple", "USA");
        Manufacturer Xiaomi = new Manufacturer("Xiaomi", "China");
        Manufacturer Nillkin = new Manufacturer("Nillkin", "China");
        Manufacturer Samsung = new Manufacturer("Samsung", "Korea");

        Product iphone14 = new Product("Iphone 14 4/256", LocalDate.of(2021, 12, 2),
                Apple, true, 30000);
        Product iphone13 = new Product("Iphone 13 3/256", LocalDate.of(2020, 9, 5),
                Apple, true, 20000);
        Product iphone11 = new Product("Iphone 11 4/128", LocalDate.of(2019, 11, 25),
                Apple, true, 15000);
        Product pocoF5 = new Product("Xiaomi Poco F5", LocalDate.of(2021, 10, 20),
                Xiaomi, true, 18000);
        Product redmi11T = new Product("Xiaomi Redmi 11T", LocalDate.of(2022, 5, 30),
                Xiaomi, true, 19000);
        Product galaxyA24 = new Product("Samsung Galaxy A24", LocalDate.of(2022, 9, 19),
                Samsung, true, 10000);
        Product mattePro = new Product("Nillkin Matte Pro", LocalDate.of(2023, 5, 10),
                Nillkin, false, 350);
        Product tpuEpikBlack = new Product("Nillkin TPU Epik Black",
                LocalDate.of(2023, 5, 10), Nillkin, false, 400);

        List<Product> products = new ArrayList<>();

        products.add(iphone11);
        products.add(iphone13);
        products.add(iphone14);
        products.add(pocoF5);
        products.add(redmi11T);
        products.add(galaxyA24);
        products.add(mattePro);
        products.add(tpuEpikBlack);

        Predicate<Product> predicate1 = element -> element.manufacturer().name().equals("Apple") && element.fragility();
        Predicate<Product> predicate2 = Product::fragility;
        Predicate<Product> predicate3 = element -> element.price() > 1000 && element.price() < 20000;

        Consumer<Product> consumer = System.out::println;

        //1
        System.out.println("-1-");
        products
                .stream()
                .filter(predicate1)
                .forEach(consumer);
        //2
        System.out.println("-2-");
        products
                .stream()
                .filter(predicate2)
                .forEach(consumer);
        //3
        System.out.println("-3-");
        products
                .stream()
                .filter(predicate3)
                .forEach(consumer);
    }
}
