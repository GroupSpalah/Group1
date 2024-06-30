package homeworks.dmytro_k.hw_2024.sql.hw_16_06_24;

import homeworks.dmytro_k.hw_2024.sql.hw_16_06_24.dao.CrudDao;
import homeworks.dmytro_k.hw_2024.sql.hw_16_06_24.dao.TruckDao;
import homeworks.dmytro_k.hw_2024.sql.hw_16_06_24.dao.impl.DriverDaoImpl;
import homeworks.dmytro_k.hw_2024.sql.hw_16_06_24.dao.impl.TruckDaoImpl;
import homeworks.dmytro_k.hw_2024.sql.hw_16_06_24.domain.Driver;
import homeworks.dmytro_k.hw_2024.sql.hw_16_06_24.domain.Truck;


import java.time.LocalDate;

public class DriverDbAppTest {
    public static void main(String[] args) {

        CrudDao<Driver> driverDAO = new DriverDaoImpl();

        TruckDao truckDAO = new TruckDaoImpl();

        Truck newTruck = Truck
                .builder()
                .model("Truck Y")
                .driverId(1)
                .modelYear(LocalDate.of(2023, 1, 25))
                .build();

        Driver newDriver = Driver
                .builder()
                .firstName("New")
                .lastName("Driver")
                .age(30)
                .qualification(Qualification.MEDIUM)
                .build();

        //truckDAO.addTruck(newTruck);
        //truckDAO.updateTruck(newTruck, 67);
        //truckDAO.deleteTruck(66);
       /* truckDAO.getAllTrucks().forEach(System.out::println);
        System.out.println(truckDAO.getTruckById(5));*/

        //driverDAO.addDriver(newDriver);
        //driverDAO.updateDriver(newDriver, 1);
        //driverDAO.deleteDriver(32);
     /*   driverDAO.getAllDrivers().forEach(System.out::println);
        System.out.println(driverDAO.getDriverById(1));

        driverDAO.getTrucksForDriver(1).forEach(System.out::println);*/
    }
}
