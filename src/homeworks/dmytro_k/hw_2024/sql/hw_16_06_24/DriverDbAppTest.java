package homeworks.dmytro_k.hw_2024.sql.hw_16_06_24;


import homeworks.dmytro_k.hw_2024.sql.hw_16_06_24.dao.*;
import homeworks.dmytro_k.hw_2024.sql.hw_16_06_24.dao.impl.*;
import homeworks.dmytro_k.hw_2024.sql.hw_16_06_24.domain.*;
import homeworks.dmytro_k.hw_2024.sql.hw_16_06_24.util.ConnectionUtil;

import java.time.LocalDate;

public class DriverDbAppTest {
    public static void main(String[] args) {

        TruckDao truckDao = new TruckDaoImpl();
        DriverDao driverDao = new DriverDaoImpl();

        Truck newTruck = Truck
                .builder()
                .id(67)
                .model("Truck New")
                .driverId(1)
                .modelYear(LocalDate.of(2023, 1, 25))
                .build();

        Driver newDriver = Driver
                .builder()
                .id(33)
                .firstName("New")
                .lastName("Driver")
                .age(33)
                .qualification(Qualification.MEDIUM)
                .build();

        //truckDao.add(newTruck);
        //truckDao.update(newTruck);
        //truckDao.deleteById(67);
        truckDao.getAll().forEach(System.out::println);
        System.out.println(truckDao.getById(5));
        //driverDao.add(newDriver);
        //driverDao.update(newDriver);
        //driverDao.deleteById(33);
        driverDao.getAll().forEach(System.out::println);
        System.out.println(driverDao.getById(1));
        driverDao.getTrucksForDriver(1).forEach(System.out::println);
        ConnectionUtil.disconnect();
    }
}
