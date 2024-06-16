package homeworks.dmytro_k.hw_2024.sql.hw_02_06_24;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

/**
 * ++ б) перегляд за id;??
 * ++ в) перегляд повного переліку;
 * ++ г) видалення за id;
 * д) видалення повного переліку;
 * е) модифікація за id;
 * ++ є) перегляд за моделлю;
 * ++ ж) перегляд за датою випуску;
 * ++ з) перегляд за об’ємом оперативної пам’яті та місткістю SSD;
 * ++ и) перегляд за процесором.
 */

public class LaptopsDataBaseAppTest {
    public static void main(String[] args) {

        Laptop newLaptop = new Laptop("Yoga Slim 10", "Lenovo",
                LocalDate.of(2022, 1, 25), 16, 1, "Intel Core i7-1185G7");

        //LaptopsDataBaseApp.addLaptopToDb(newLaptop);

        //LaptopsDataBaseApp.updateLaptop(newLaptop, 31);

        //видалення за id
        //LaptopsDataBaseApp.deleteLaptop(30);
        //видалення повного переліку
        //LaptopsDataBaseApp.deleteAllLaptops();

        LaptopsDataBaseApp.filterByValue("laptop_id", "1");

        Map<String, String> allTable = new HashMap<>();

        Map<String, String> modelFilters = new HashMap<>();
        modelFilters.put("model", "MacBook Pro");

        Map<String, String> dateFilters = new HashMap<>();
        dateFilters.put("release_date", "2021");

        Map<String, String> ramAndSsdCapacity = new HashMap<>();
        ramAndSsdCapacity.put("RAM_capacity", "16");
        ramAndSsdCapacity.put("SSD_capacity", "512");

        LaptopsDataBaseApp.filterByValue(allTable);

        LaptopsDataBaseApp.filterByValue(modelFilters);

        LaptopsDataBaseApp.filterByValue(dateFilters);

        LaptopsDataBaseApp.filterByValue(ramAndSsdCapacity);

        /*LaptopsDataBaseApp.filterByValue("RAM_capacity", "16", "SSD_capacity", "512");*/
    }
}
