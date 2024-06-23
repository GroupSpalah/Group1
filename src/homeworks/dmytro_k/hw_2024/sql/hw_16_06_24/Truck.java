package homeworks.dmytro_k.hw_2024.sql.hw_16_06_24;

import lombok.*;

import java.time.LocalDate;

@Setter
@Getter
@AllArgsConstructor

public class Truck {
    int truckId;
    String model;
    int driverId;
    LocalDate modelYear;

    public Truck(String model, int driverId, LocalDate modelYear) {
        this.model = model;
        this.driverId = driverId;
        this.modelYear = modelYear;
    }


    @Override
    public String toString() {
        return "Truck " + truckId + " {" +
                " truckId = " + truckId + " |" +
                " model = '" + model + '\'' + "|" +
                " driverId = " + driverId + "|" +
                " modelYear = " + modelYear +
                "} "
                + "\n-----------------------------------------------------------------------"
                + "-----------------------------";
    }
}
