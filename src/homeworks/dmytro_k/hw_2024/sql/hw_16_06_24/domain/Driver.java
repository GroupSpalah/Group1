package homeworks.dmytro_k.hw_2024.sql.hw_16_06_24.domain;

import homeworks.dmytro_k.hw_2024.sql.hw_16_06_24.Qualification;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Getter
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Driver {
    int id;
    String firstName;
    String lastName;
    int age;
    Qualification qualification;
    List<Truck> truckList;

    @Override
    public String toString() {
        return "Driver " + id + " {" +
                " id = " + id +
                "| firstName = '" + firstName + '\'' +
                "| lastName = '" + lastName + '\'' +
                "| age = " + age +
                "| qualification = " + qualification +
                "| \ntruckList = " + truckList +
                "}\n" + "\n------------------------------------------------------------------------"
                + "------------------------------";
    }
}




