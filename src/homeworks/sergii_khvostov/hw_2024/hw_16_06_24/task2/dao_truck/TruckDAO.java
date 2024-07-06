package homeworks.sergii_khvostov.hw_2024.hw_16_06_24.task2.dao_truck;

import homeworks.sergii_khvostov.hw_2024.hw_16_06_24.task2.dao.GenericDAO;
import homeworks.sergii_khvostov.hw_2024.hw_16_06_24.task2.db_connection.SQLRequests;
import homeworks.sergii_khvostov.hw_2024.hw_16_06_24.task2.domain.Truck;
import lombok.Builder;
import lombok.Cleanup;
import lombok.SneakyThrows;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Builder
public class TruckDAO implements GenericDAO<Truck> {
    private Connection connection;

    public TruckDAO(Connection connection) {
        this.connection = connection;
    }

    @SneakyThrows
    public void add(Truck truck) {
        @Cleanup
        PreparedStatement statement = connection.prepareStatement(SQLRequests.addTruck);
        statement.setInt(1, truck.getId());
        statement.setString(2, truck.getModel());
        statement.setDate(3, java.sql.Date.valueOf(truck.getModelYear()));
        statement.executeUpdate();
    }


    @SneakyThrows
    public Truck getById(int id) {
        @Cleanup
        PreparedStatement statement = connection.prepareStatement(SQLRequests.getTruckById);
        statement.setInt(1, id);
        @Cleanup
        ResultSet resultSet = statement.executeQuery();
        return new Truck(
                resultSet.getInt("id"),
                resultSet.getString("model"),
                resultSet.getDate("modelYear").toLocalDate()
        );
    }

    @SneakyThrows
    public List<Truck> getAll() {
        List<Truck> trucks = new ArrayList<>();
        @Cleanup
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
    public void deleteById(int id) {
        @Cleanup
        PreparedStatement statement = connection.prepareStatement(SQLRequests.deleteTruckById);
        statement.setInt(1, id);
        statement.executeUpdate();
    }


    @SneakyThrows
    public void deleteAll() {
        @Cleanup
        Statement statement = connection.createStatement();
        statement.executeUpdate(SQLRequests.deleteAllTrucks);
    }


    @SneakyThrows
    public void update(int id, Truck newTruck) {
        @Cleanup
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
        @Cleanup
        PreparedStatement statement = connection.prepareStatement(SQLRequests.getTrucksByDriverId);
        statement.setInt(1, driverId);
        @Cleanup
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
