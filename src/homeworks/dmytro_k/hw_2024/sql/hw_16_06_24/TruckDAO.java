package homeworks.dmytro_k.hw_2024.sql.hw_16_06_24;


import lombok.Cleanup;
import lombok.SneakyThrows;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static homeworks.dmytro_k.hw_2024.sql.hw_16_06_24.ConstantsUtil.*;

public class TruckDAO {

    private static Connection getConnection() throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            throw new SQLException("Connection error");
        }
        return DriverManager.getConnection(URL, USERNAME, PASSWORD);
    }

    @SneakyThrows(SQLException.class)
    private static void myPreparedStatement(String sqlExpression, Truck truck, int truckId) {
        @Cleanup
        Connection connection = getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(sqlExpression);
        preparedStatement.setString(1, truck.getModel());
        preparedStatement.setDate(2, Date.valueOf(truck.getModelYear()));
        preparedStatement.setInt(3, truck.getDriverId());
        if (truckId != 0) {
            preparedStatement.setInt(4, truckId);
        }
        preparedStatement.executeUpdate();
    }

    public static void addTruck(Truck truck) {

        myPreparedStatement(INSERT_TRUCK, truck, 0);
    }

    public static void updateTruck(Truck truck, int truckId) {

        myPreparedStatement(UPDATE_TRUCK, truck, truckId);
    }

    @SneakyThrows(SQLException.class)
    public static void deleteTruck(int truckId) {
        @Cleanup
        Connection connection = getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(DELETE_TRUCK);
        preparedStatement.setInt(1, truckId);
        preparedStatement.executeUpdate();
    }

    @SneakyThrows(SQLException.class)
    private static void addTrucksToList(String sqlExpression, int filterValue) {

        List<Truck> trucks = new ArrayList<>();

        @Cleanup
        Connection connection = getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(sqlExpression);

        if (filterValue != 0) {
            preparedStatement.setInt(1, filterValue);
        }

        ResultSet resultSet = preparedStatement.executeQuery();

        while (resultSet.next()) {
            int truckId = resultSet.getInt("truck_id");
            String model = resultSet.getString("model");
            int driverId = resultSet.getInt("FK_driver_id");
            LocalDate modelYear = resultSet.getDate("model_year").toLocalDate();

            Truck truck = new Truck(model, driverId, modelYear);
            truck.setTruckId(truckId);

            trucks.add(truck);
        }
        trucks.forEach(System.out::println);
    }

    public static void getAllTrucks() {

        addTrucksToList(SELECT_ALL_TRUCKS, 0);
    }

    public static void getTruckByValue(String sqlExpression, int value) {

        addTrucksToList(sqlExpression, value);
    }

    public static void getTruckById(int truckId) {

        getTruckByValue(SELECT_TRUCK_BY_ID, truckId);
    }
}
