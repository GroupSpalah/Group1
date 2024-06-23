package homeworks.vladyslav_lazin.hw_2024.hw_16_06_24.model;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Driver {
    int id;
    String firstName;
    String lastName;
    int age;
    Qualification qualification;
    List<Truck> trucks;

}
