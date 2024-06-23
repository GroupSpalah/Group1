package homeworks.sergii_khvostov.hw_2024.hw_16_06_24;

import lombok.Data;
import lombok.AllArgsConstructor;
import java.time.LocalDate;

@Data
@AllArgsConstructor
public class LaptopLombok {
    private String model;
    private String manufacturer;
    private LocalDate releaseDate;
    private int ramSize;
    private int ssdCapacity;
    private String processor;
    private int id;

    public void displayInfo() {
        System.out.println("Laptop ID: " + id);
        System.out.println("Model: " + model);
        System.out.println("Manufacturer: " + manufacturer);
        System.out.println("Release Date: " + releaseDate);
        System.out.println("RAM Size: " + ramSize + " GB");
        System.out.println("SSD Capacity: " + ssdCapacity + " GB");
        System.out.println("Processor: " + processor);
    }
}

/*Lombok предлагает аннотацию @SneakyThrows, которая может скрыть проверяемые
исключения (checked exceptions). Тем не менее, это не рекомендуется использовать
для работы с JDBC и другими критически важными операциями ввода-вывода,
так как это может привести к нежелательным последствиям и усложнить отладку.*/

