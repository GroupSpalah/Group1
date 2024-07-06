package homeworks.sergii_khvostov.hw_2024.hw_16_06_24.task2;

import homeworks.sergii_khvostov.hw_2024.hw_16_06_24.task2.dao_driver.DriverDAO;
import homeworks.sergii_khvostov.hw_2024.hw_16_06_24.task2.dao_truck.TruckDAO;
import homeworks.sergii_khvostov.hw_2024.hw_16_06_24.task2.db_connection.DatabaseConnection;
import homeworks.sergii_khvostov.hw_2024.hw_16_06_24.task2.domain.Driver;
import homeworks.sergii_khvostov.hw_2024.hw_16_06_24.task2.domain.Truck;
import homeworks.sergii_khvostov.hw_2024.hw_16_06_24.task2.service.DriverService;
import homeworks.sergii_khvostov.hw_2024.hw_16_06_24.task2.service.TruckService;
import homeworks.sergii_khvostov.hw_2024.hw_16_06_24.task2.service.impl.DriverServiceImpl;
import homeworks.sergii_khvostov.hw_2024.hw_16_06_24.task2.service.impl.TruckServiceImpl;
import lombok.SneakyThrows;

import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

public class DriverTruckService {

    @SneakyThrows
    public static void main(String[] args) throws SQLException {
        Connection connection = DatabaseConnection.getConnection();
        TruckDAO truckDAO = new TruckDAO(connection);
        DriverDAO driverDAO = new DriverDAO(connection);

        TruckService truckService = new TruckServiceImpl(truckDAO);
        DriverService driverService = new DriverServiceImpl(driverDAO);

        // Создание грузовиков
        Truck truck1 = Truck.builder()
                .id(1)
                .model("Volvo FH")
                .modelYear(LocalDate.of(2020, 1, 1))
                .build();
        Truck truck2 = Truck.builder()
                .id(2)
                .model("Scania R450")
                .modelYear(LocalDate.of(2020, 1, 1))
                .build();

        List<Truck> trucks = Arrays.asList(truck1, truck2);

        // Создание водителя
        Driver driver = Driver.builder()
                .id(1)
                .firstName("John")
                .lastName("Doe")
                .age(35)
                .qualification(Qualification.ADVANCED)
                .trucks(trucks)
                .build();

        // Добавление водителя и грузовиков в базу данных
        driverService.addDriver(driver);

        // Получение водителя по id
        Driver getDriver = driverService.getDriverById(1);
        System.out.println("Driver: " + getDriver);
    }
}
