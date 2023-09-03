package homeworks.dmytro_k.hw_2023.hw_13_08_23.task2;

import java.time.LocalDate;

public record Product(String name, LocalDate manufactureDate, Manufacturer manufacturer,
                      boolean fragility, double price) {
}
