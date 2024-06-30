package homeworks.sergii_khvostov.hw_2024.hw_16_06_24.task2;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Driver {
    private int id;
    private String firstName;
    private String lastName;
    private int age;
    private Qualification qualification;
    private List<Truck> trucks;
}

