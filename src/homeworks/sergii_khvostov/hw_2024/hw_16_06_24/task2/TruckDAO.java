package homeworks.sergii_khvostov.hw_2024.hw_16_06_24.task2;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TruckDAO {
    private Connection connection;

    public TruckDAO(Connection connection) {
        this.connection = connection;
    }

    public void addTruck(Truck truck, int driverId) throws SQLException {
        String query = "INSERT INTO Truck (id, model, modelYear, driver_id) VALUES (?, ?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, truck.getId());
            statement.setString(2, truck.getModel());
            statement.setInt(3, truck.getModelYear());
            statement.setInt(4, driverId);
            statement.executeUpdate();
        }
    }

    public Truck getTruckById(int id) throws SQLException {
        String query = "SELECT * FROM Truck WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return new Truck(
                        resultSet.getInt("id"),
                        resultSet.getString("model"),
                        resultSet.getInt("modelYear")
                );
            }
        }
        return null;
    }

    public List<Truck> getAllTrucks() throws SQLException {
        List<Truck> trucks = new ArrayList<>();
        String query = "SELECT * FROM Truck";
        try (Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                trucks.add(new Truck(
                        resultSet.getInt("id"),
                        resultSet.getString("model"),
                        resultSet.getInt("modelYear")
                ));
            }
        }
        return trucks;
    }

    public void deleteTruckById(int id) throws SQLException {
        String query = "DELETE FROM Truck WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, id);
            statement.executeUpdate();
        }
    }

    public void deleteAllTrucks() throws SQLException {
        String query = "DELETE FROM Truck";
        try (Statement statement = connection.createStatement()) {
            statement.executeUpdate(query);
        }
    }

    public void updateTruck(int id, Truck newTruck) throws SQLException {
        String query = "UPDATE Truck SET model = ?, modelYear = ?, driver_id = ? WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, newTruck.getModel());
            statement.setInt(2, newTruck.getModelYear());
            statement.setInt(3, id);
            statement.setInt(4, id);
            statement.executeUpdate();
        }
    }

    public List<Truck> getTrucksByDriverId(int driverId) throws SQLException {
        List<Truck> trucks = new ArrayList<>();
        String query = "SELECT * FROM Truck WHERE driver_id = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, driverId);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                trucks.add(new Truck(
                        resultSet.getInt("id"),
                        resultSet.getString("model"),
                        resultSet.getInt("modelYear")
                ));
            }
        }
        return trucks;
    }
}

