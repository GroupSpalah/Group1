package homeworks.dmytro_k.hw_2024.sql.hw_16_06_24;

import java.time.LocalDate;

public class DriverDbAppTest {
    public static void main(String[] args) {

        Truck newTruck = new Truck("Truck Y", 1, LocalDate.of(2023, 1, 25));

        Truck
                .builder()
                .model("")
                .build();

        Driver newDriver = new Driver("New", " Driver", 30, Qualification.MEDIUM.getShortName());

/*        TruckDAO.addTruck(newTruck);

        TruckDAO.updateTruck(newTruck, 67);

        TruckDAO.deleteTruck(66);*/

        TruckDAO.getAllTrucks();

        TruckDAO.getTruckById(5);


        //DriverDAO.getAllDrivers();
        //DriverDAO.getDriverById(1);
        //DriverDAO.deleteDriver(1);
        //DriverDAO.updateDriver(newDriver, 1);
        //DriverDAO.addDriver(newDriver, 1);

        DriverDAO.getTrucksForDriver(1);
    }
}
