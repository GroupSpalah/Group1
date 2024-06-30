package homeworks.sergii_khvostov.hw_2024.hw_16_06_24.task2;

import lombok.Builder;
import lombok.SneakyThrows;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Builder

public class TruckDAO implements DAOForTruck {
    private Connection connection;

    public TruckDAO(Connection connection) {
        this.connection = connection;
    }

    @SneakyThrows
    public void addTruck(Truck truck, int driverId) {
        PreparedStatement statement = connection.prepareStatement(SQLRequests.addTruck);
        statement.setInt(1, truck.getId());
        statement.setString(2, truck.getModel());
        statement.setDate(3, java.sql.Date.valueOf(truck.getModelYear()));
        statement.setInt(4, driverId);
        statement.executeUpdate();
    }

    @SneakyThrows
    public Truck getTruckById(int id) {
        PreparedStatement statement = connection.prepareStatement(SQLRequests.getTruckById);
        statement.setInt(1, id);
        ResultSet resultSet = statement.executeQuery();
        return new Truck(
                resultSet.getInt("id"),
                resultSet.getString("model"),
                resultSet.getDate("modelYear").toLocalDate()
        );
    }
    @SneakyThrows
    public List<Truck> getAllTrucks() {
        List<Truck> trucks = new ArrayList<>();
        Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(SQLRequests.getAllTrucks);
            while (resultSet.next()) {
                trucks.add(new Truck(
                        resultSet.getInt("id"),
                        resultSet.getString("model"),
                        resultSet.getDate("modelYear").toLocalDate()
                ));
            }
        return trucks;
    }
    @SneakyThrows
    public void deleteTruckById(int id) {
        PreparedStatement statement = connection.prepareStatement(SQLRequests.deleteTruckById);
            statement.setInt(1, id);
            statement.executeUpdate();
        }

    @SneakyThrows
    public void deleteAllTrucks() {
        Statement statement = connection.createStatement();
            statement.executeUpdate(SQLRequests.deleteAllTrucks);
        }

    @SneakyThrows
    public void updateTruck(int id, Truck newTruck) {
        PreparedStatement statement = connection.prepareStatement(SQLRequests.updateTruck);
            statement.setString(1, newTruck.getModel());
            statement.setDate(2, java.sql.Date.valueOf(newTruck.getModelYear()));
            statement.setInt(3, id);
            statement.setInt(4, id);
            statement.executeUpdate();
        }

   @SneakyThrows
    public List<Truck> getTrucksByDriverId(int driverId) {
        List<Truck> trucks = new ArrayList<>();
        String query = "SELECT * FROM Truck WHERE driver_id = ?";
        PreparedStatement statement = connection.prepareStatement(SQLRequests.getTrucksByDriverId);
            statement.setInt(1, driverId);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                trucks.add(new Truck(
                        resultSet.getInt("id"),
                        resultSet.getString("model"),
                        resultSet.getDate("modelYear").toLocalDate()
                ));
            }

        return trucks;
    }
}

