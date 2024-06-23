package homeworks.dmytro_k.hw_2024.sql.hw_16_06_24;

import lombok.*;

import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@Builder

public class Driver {
    int driverId;
    String firstName;
    String lastName;
    int age;
    Qualification qualification;
    List<Truck> truckList;

    public Driver(String firstName, String lastName, int age, Qualification qualification) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.qualification = qualification;
        //truckList = null

    }

    @Override
    public String toString() {
        return "Driver " + driverId + " {" +
                "driverId = " + driverId +
                "| firstName = '" + firstName + '\'' +
                "| lastName = '" + lastName + '\'' +
                "| age = " + age +
                "| qualification = " + qualification +
                "| truckList = " + truckList +
                '}' + "\n------------------------------------------------------------------------"
                + "--------------------------------------------------";
    }
}




