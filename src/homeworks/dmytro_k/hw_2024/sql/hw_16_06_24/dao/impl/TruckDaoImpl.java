package homeworks.dmytro_k.hw_2024.sql.hw_16_06_24.dao.impl;


import homeworks.dmytro_k.hw_2024.sql.hw_16_06_24.dao.TruckDao;
import homeworks.dmytro_k.hw_2024.sql.hw_16_06_24.domain.Truck;
import lombok.Cleanup;
import lombok.SneakyThrows;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static homeworks.dmytro_k.hw_2024.sql.hw_16_06_24.ConstantsUtil.*;
import static homeworks.dmytro_k.hw_2024.sql.hw_16_06_24.ConnectionUtil.*;

public class TruckDaoImpl implements TruckDao {

    @SneakyThrows(SQLException.class)
    private void getPreparedStatement(String sqlExpression, Truck truck) {
        Connection connection = getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(sqlExpression);
        preparedStatement.setString(1, truck.getModel());
        preparedStatement.setDate(2, Date.valueOf(truck.getModelYear()));
        preparedStatement.setInt(3, truck.getDriverId());

        int id = truck.getId();

        if (id != 0) {
            preparedStatement.setInt(4, id);
        }
        preparedStatement.executeUpdate();
        disconnect(connection, preparedStatement, null);
    }

    public void add(Truck truck) {
        getPreparedStatement(INSERT_TRUCK, truck);
    }

    public void update(Truck truck) {
        getPreparedStatement(UPDATE_TRUCK, truck);
    }

    @SneakyThrows(SQLException.class)
    public void deleteById(int truckId) {
        @Cleanup
        Connection connection = getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(DELETE_TRUCK);
        preparedStatement.setInt(1, truckId);
        preparedStatement.executeUpdate();
        disconnect(connection, preparedStatement, null);
    }

    @SneakyThrows(SQLException.class)
    private List<Truck> getTruckList(String sqlExpression, int filterValue) {

        List<Truck> trucks = new ArrayList<>();

        @Cleanup
        Connection connection = getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(sqlExpression);

        if (filterValue != 0) {
            preparedStatement.setInt(1, filterValue);
        }

        ResultSet resultSet = preparedStatement.executeQuery();

        while (resultSet.next()) {
            int id = resultSet.getInt("truck_id");
            String model = resultSet.getString("model");
            int driverId = resultSet.getInt("FK_driver_id");
            LocalDate modelYear = resultSet.getDate("model_year").toLocalDate();

            trucks.add(
                    Truck
                            .builder()
                            .id(id)
                            .model(model)
                            .driverId(driverId)
                            .modelYear(modelYear)
                            .build()
            );
        }
        disconnect(connection, preparedStatement, resultSet);
        return trucks;
    }

    public List<Truck> getAll() {
        return getTruckList(SELECT_ALL_TRUCKS, 0);
    }

    public List<Truck> getTrucksByValue(String sqlExpression, int value) {
        return getTruckList(sqlExpression, value);
    }

    public Truck getById(int truckId) {
        return getTrucksByValue(SELECT_TRUCK_BY_ID, truckId).getFirst();
    }
}