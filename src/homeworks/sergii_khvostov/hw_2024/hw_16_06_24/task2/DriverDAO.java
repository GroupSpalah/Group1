package homeworks.sergii_khvostov.hw_2024.hw_16_06_24.task2;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DriverDAO {
    private Connection connection;
    private TruckDAO truckDAO;

    public DriverDAO(Connection connection) {
        this.connection = connection;
        this.truckDAO = new TruckDAO(connection);
    }

    public void addDriver(Driver driver) throws SQLException {
        String query = "INSERT INTO Driver (id, firstName, lastName, age, qualification) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
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
    }

    public Driver getDriverById(int id) throws SQLException {
        String query = "SELECT * FROM Driver WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
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
        }
        return null;
    }

    public List<Driver> getAllDrivers() throws SQLException {
        List<Driver> drivers = new ArrayList<>();
        String query = "SELECT * FROM Driver";
        try (Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(query);
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
        }
        return drivers;
    }

    public void deleteDriverById(int id) throws SQLException {
        String query = "DELETE FROM Driver WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, id);
            statement.executeUpdate();
        }
    }

    public void deleteAllDrivers() throws SQLException {
        String query = "DELETE FROM Driver";
        try (Statement statement = connection.createStatement()) {
            statement.executeUpdate(query);
        }
    }

    public void updateDriver(int id, Driver newDriver) throws SQLException {
        String query = "UPDATE Driver SET firstName = ?, lastName = ?, age = ?, qualification = ? WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, newDriver.getFirstName());
            statement.setString(2, newDriver.getLastName());
            statement.setInt(3, newDriver.getAge());
            statement.setString(4, newDriver.getQualification().name());
            statement.setInt(5, id);
            statement.executeUpdate();
        }
    }
}

