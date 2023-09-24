package homeworks.dmytro_k.hw_2023.hw_10_09_23;

/**
 * Первая цель Службы общественного транспорта — выяснить, сколько транспортных средств определенного типа имеют
 * особый статус.
 */

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class TransportService {

    private final List<Vehicle> vehicles = new ArrayList<>();

    private final Predicate<Vehicle> vehiclesInOperation = element -> element.status.equals(Status.IN_OPERATION);
    private final Predicate<Vehicle> vehiclesNeedsRepair = element -> element.status.equals(Status.NEEDS_REPAIR);
    private final Predicate<Vehicle> vehiclesScrapped = element -> element.status.equals(Status.SCRAPPED);

    private final Predicate<Vehicle> isBus = element -> element.getFuelType().equals(Fuel.GAS);
    private final Predicate<Vehicle> isTrolleybus = element -> element.getFuelType().equals(Fuel.HYBRID);
    private final Predicate<Vehicle> isTram = element -> element.getFuelType().equals(Fuel.ELECTRIC);

    private final Consumer<Vehicle> identifierConsumer = vehicle ->
            System.out.println(vehicle.getClass().getSimpleName()
                    + " Identifier: "
                    + vehicle.getIdentifier()
                    + " " + "Numberplate "
                    + vehicle.getNumberplate());

    public void add(Vehicle vehicle) {
        vehicles.add(vehicle);
    }

    public long numberOfVehicles(Predicate<Vehicle> vehicleType, Predicate<Vehicle> vehicleStatus) {
        return vehicles
                .stream()
                .filter(vehicleType)
                .filter(vehicleStatus)
                .count();
    }

    public void vehicleInfo(Predicate<Vehicle> vehicleType, Predicate<Vehicle> vehicleStatus) {
        vehicles
                .stream()
                .filter(vehicleStatus)
                .filter(vehicleType)
                .forEach(identifierConsumer);
    }

    public void numberOfVehiclesByStatus(Status status) {

        if (status.equals(Status.IN_OPERATION)) {
            System.out.println("Bus in operation: " +
                    numberOfVehicles(isBus, vehiclesInOperation));
            vehicleInfo(isBus, vehiclesInOperation);

            System.out.println("Trolleybus in operation: " +
                    numberOfVehicles(isTrolleybus, vehiclesInOperation));
            vehicleInfo(isTrolleybus, vehiclesInOperation);

            System.out.println("Tram in operation: " +
                    numberOfVehicles(isTram, vehiclesInOperation));
            vehicleInfo(isTram, vehiclesInOperation);
        } else if (status.equals(Status.NEEDS_REPAIR)) {
            System.out.println("Bus needs repair: " +
                    numberOfVehicles(isBus, vehiclesNeedsRepair));
            vehicleInfo(isBus, vehiclesNeedsRepair);

            System.out.println("Trolleybus needs repair: " +
                    numberOfVehicles(isTrolleybus, vehiclesNeedsRepair));
            vehicleInfo(isTrolleybus, vehiclesNeedsRepair);

            System.out.println("Tram needs repair: " +
                    numberOfVehicles(isTram, vehiclesNeedsRepair));
            vehicleInfo(isTram, vehiclesNeedsRepair);
        } else if (status.equals(Status.SCRAPPED)) {
            System.out.println("Bus scrapped: " +
                    numberOfVehicles(isBus, vehiclesScrapped));
            vehicleInfo(isBus, vehiclesScrapped);

            System.out.println("Trolleybus scrapped: " +
                    numberOfVehicles(isTrolleybus, vehiclesScrapped));
            vehicleInfo(isTrolleybus, vehiclesScrapped);

            System.out.println("Tram scrapped: " +
                    numberOfVehicles(isTram, vehiclesScrapped));
            vehicleInfo(isTram, vehiclesScrapped);
        }
    }
}
