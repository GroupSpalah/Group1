package homeworks.sergii_khvostov.hw_2024.hw_16_06_24.task2;

import lombok.Builder;
import lombok.SneakyThrows;

import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;


@Builder
public class DriverTruckService {
    @SneakyThrows
    public static void main(String[] args) throws SQLException {
        Connection connection = DatabaseConnection.getConnection();
            TruckDAO truckDAO = new TruckDAO(connection);
            DriverDAO driverDAO = new DriverDAO(connection);

            // Создание грузовиков
            Truck truck1 = Truck.builder()
                    .id(1)
                    .model("Volvo FH")
                    .modelYear(LocalDate.ofEpochDay(2020))
                    .build();
            Truck truck2 = Truck.builder()
                    .id(2)
                    .model("Scania R450")
                    .modelYear(LocalDate.ofEpochDay(2020))
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
            driverDAO.addDriver(driver);

            // Получение водителя по id
            Driver getDriver = driverDAO.getDriverById(1);
            System.out.println("Driver: " + getDriver);
        }
    }

