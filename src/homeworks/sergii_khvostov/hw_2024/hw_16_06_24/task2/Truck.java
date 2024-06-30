package homeworks.sergii_khvostov.hw_2024.hw_16_06_24.task2;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Truck {
    private int id;
    private String model;
    private LocalDate modelYear;
}

