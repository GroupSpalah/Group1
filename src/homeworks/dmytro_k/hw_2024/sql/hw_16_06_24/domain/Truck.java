package homeworks.dmytro_k.hw_2024.sql.hw_16_06_24.domain;

import lombok.*;

import java.time.LocalDate;

@Getter
@Builder
public class Truck {
    int id;
    String model;
    int driverId;
    LocalDate modelYear;

    @Override
    public String toString() {
        return "\nTruck " + id + " {" +
                " id = " + id + " |" +
                " model = '" + model + '\'' + "|" +
                " driverId = " + driverId + "|" +
                " modelYear = " + modelYear +
                " } "
                + "\n-----------------------------------------------------------------------"
                + "------------------------ ";
    }
}
