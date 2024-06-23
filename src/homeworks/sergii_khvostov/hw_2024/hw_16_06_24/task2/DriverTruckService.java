package homeworks.sergii_khvostov.hw_2024.hw_16_06_24.task2;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

public class DriverTruckService {
    public static void main(String[] args) throws SQLException {
        try (Connection connection = DatabaseConnection.getConnection()) {
            TruckDAO truckDAO = new TruckDAO(connection);
            DriverDAO driverDAO = new DriverDAO(connection);

            // Создание грузовиков
            Truck truck1 = new Truck(1, "Volvo FH", 2021);
            Truck truck2 = new Truck(2, "Scania R450", 2020);

            // Создание водителя
            List<Truck> trucks = Arrays.asList(truck1, truck2);
            Driver driver = new Driver(1, "John", "Doe", 35,
                    Qualification.ADVANCED, trucks);

            // Добавление водителя и грузовиков в базу данных
            driverDAO.addDriver(driver);

            // Получение водителя по id
            Driver getDriver = driverDAO.getDriverById(1);
            System.out.println("Driver: " + getDriver);
        }
    }
}
