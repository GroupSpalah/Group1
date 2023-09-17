package homeworks.dmytro_k.hw_2023.hw_10_09_23;

/**
 * Первая цель Службы общественного транспорта — выяснить, сколько транспортных средств определенного типа имеют
 * особый статус.
 */

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class TransportService {

    private List<Vehicle> vehicles = new ArrayList<>();

    Predicate<Vehicle> vehiclesInOperation = element -> element.status.equals(Status.INOPERATION);
    Predicate<Vehicle> vehiclesNeedsRepair = element -> element.status.equals(Status.NEEDSREPAIR);
    Predicate<Vehicle> vehiclesScrapped = element -> element.status.equals(Status.SCRAPPED);


    public void add() {

    }

    public void numberOfVehiclesByStatus() {

    }
}
