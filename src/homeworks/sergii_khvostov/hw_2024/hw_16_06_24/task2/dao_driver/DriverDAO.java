package homeworks.sergii_khvostov.hw_2024.hw_16_06_24.task2.dao_driver;

import homeworks.sergii_khvostov.hw_2024.hw_16_06_24.task2.Qualification;
import homeworks.sergii_khvostov.hw_2024.hw_16_06_24.task2.dao.GenericDAO;
import homeworks.sergii_khvostov.hw_2024.hw_16_06_24.task2.domain.Driver;
import homeworks.sergii_khvostov.hw_2024.hw_16_06_24.task2.domain.Truck;
import homeworks.sergii_khvostov.hw_2024.hw_16_06_24.task2.db_connection.SQLRequests;
import homeworks.sergii_khvostov.hw_2024.hw_16_06_24.task2.dao_truck.TruckDAO;
import lombok.Builder;
import lombok.Cleanup;
import lombok.SneakyThrows;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Builder
public class DriverDAO implements GenericDAO<Driver> {
    private Connection connection;
    private TruckDAO truckDAO;

    public DriverDAO(Connection connection) {
        this.connection = connection;
        this.truckDAO = new TruckDAO(connection);
    }

    @SneakyThrows
    public void add(Driver driver) {
        @Cleanup
        PreparedStatement statement = connection.prepareStatement(SQLRequests.addDriver);
        statement.setInt(1, driver.getId());
        statement.setString(2, driver.getFirstName());
        statement.setString(3, driver.getLastName());
        statement.setInt(4, driver.getAge());
        statement.setString(5, driver.getQualification().name());
        statement.executeUpdate();

        driver.getTrucks().stream()
                .forEach(truck -> truckDAO.add(truck));
    }


    @SneakyThrows
    public Driver getById(int id) {
        @Cleanup
        PreparedStatement statement = connection.prepareStatement(SQLRequests.getDriverById);
        statement.setInt(1, id);
        @Cleanup
        ResultSet resultSet = statement.executeQuery();
        return new Driver(
                resultSet.getInt("id"),
                resultSet.getString("firstName"),
                resultSet.getString("lastName"),
                resultSet.getInt("age"),
                Qualification.valueOf(resultSet.getString("qualification")),
                truckDAO.getTrucksByDriverId(id)
        );
    }


    @SneakyThrows
    public List<Driver> getAll() {
        List<Driver> drivers = new ArrayList<>();
        @Cleanup
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(SQLRequests.getAllDrivers);
        while (resultSet.next()) {
            drivers.add(new Driver(
                    resultSet.getInt("id"),
                    resultSet.getString("firstName"),
                    resultSet.getString("lastName"),
                    resultSet.getInt("age"),
                    Qualification.valueOf(resultSet.getString("qualification")),
                    truckDAO.getTrucksByDriverId(resultSet.getInt("id"))
            ));
        }
        return drivers;
    }


    @SneakyThrows
    public void deleteById(int id) {
        @Cleanup
        PreparedStatement statement = connection.prepareStatement(SQLRequests.deleteDriverById);
            statement.setInt(1, id);
            statement.executeUpdate();
        }


    @SneakyThrows
    public void deleteAll() {
        @Cleanup
        Statement statement = connection.createStatement();
            statement.executeUpdate(SQLRequests.deleteAllDrivers);
        }


    @SneakyThrows
    public void update(int id, Driver newDriver) {
        @Cleanup
        PreparedStatement statement = connection.prepareStatement(SQLRequests.updateDriver);
            statement.setString(1, newDriver.getFirstName());
            statement.setString(2, newDriver.getLastName());
            statement.setInt(3, newDriver.getAge());
            statement.setString(4, newDriver.getQualification().name());
            statement.setInt(5, id);
            statement.executeUpdate();
        }
    }


