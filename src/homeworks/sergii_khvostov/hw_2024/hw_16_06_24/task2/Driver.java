package homeworks.sergii_khvostov.hw_2024.hw_16_06_24.task2;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Driver {
   int id;
   String firstName;
   String lastName;
   int age;
   Qualification qualification;
   List<Truck> trucks;
}

