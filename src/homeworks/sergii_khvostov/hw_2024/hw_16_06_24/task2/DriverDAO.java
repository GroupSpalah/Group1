package homeworks.sergii_khvostov.hw_2024.hw_16_06_24.task2;

import lombok.SneakyThrows;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DriverDAO implements DAOForDriver {
    private Connection connection;
    private TruckDAO truckDAO;

    public DriverDAO(Connection connection) {
        this.connection = connection;
        this.truckDAO = new TruckDAO(connection);
    }

    @SneakyThrows
    public void addDriver(Driver driver) {
        PreparedStatement statement = connection.prepareStatement(SQLRequests.addDriver);
            statement.setInt(1, driver.getId());
            statement.setString(2, driver.getFirstName());
            statement.setString(3, driver.getLastName());
            statement.setInt(4, driver.getAge());
            statement.setString(5, driver.getQualification().name());
            statement.executeUpdate();

            for (Truck truck : driver.getTrucks()) {
                truckDAO.addTruck(truck, driver.getId());
            }
        }

    @SneakyThrows
    public Driver getDriverById(int id) {
        PreparedStatement statement = connection.prepareStatement(SQLRequests.getDriverById);
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                Driver driver = new Driver(
                        resultSet.getInt("id"),
                        resultSet.getString("firstName"),
                        resultSet.getString("lastName"),
                        resultSet.getInt("age"),
                        Qualification.valueOf(resultSet.getString("qualification")),
                        truckDAO.getTrucksByDriverId(id)
                );
                return driver;
            }
        return null;
    }
    @SneakyThrows
    public List<Driver> getAllDrivers() {
        List<Driver> drivers = new ArrayList<>();
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
    public void deleteDriverById(int id) {
        PreparedStatement statement = connection.prepareStatement(SQLRequests.deleteDriverById);
            statement.setInt(1, id);
            statement.executeUpdate();
        }

    @SneakyThrows
    public void deleteAllDrivers() {
        Statement statement = connection.createStatement();
            statement.executeUpdate(SQLRequests.deleteAllDrivers);
    }
    @SneakyThrows
    public void updateDriver(int id, Driver newDriver) {
        PreparedStatement statement = connection.prepareStatement(SQLRequests.updateDriver);
            statement.setString(1, newDriver.getFirstName());
            statement.setString(2, newDriver.getLastName());
            statement.setInt(3, newDriver.getAge());
            statement.setString(4, newDriver.getQualification().name());
            statement.setInt(5, id);
            statement.executeUpdate();
        }
    }



