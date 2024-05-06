package homeworks.dmytro_k.hw_2024.sql.hw_28_04_24;

public class GoodsTest {
    public static void main(String[] args) {
        //вся таблица
        GoodsService.printTable();
        // хрупкие(boolean)
        GoodsService.filterByValue("item", "fragility", "1");
        //Одного производителя(любое название),
        GoodsService.filterByValue("producer", "product_producer", "Samsung");
        //Товары, произведенные в разных странах Канада и Украина и одинаковые производители
        //GoodsService.printDistinctCountry("producer", "country_of_production", "Apple");
        GoodsService.printDistinctColumnContent("producer", "country_of_production");
    }
}
