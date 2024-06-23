package homeworks.dmytro_k.hw_2024.sql.hw_16_06_24;

import lombok.Cleanup;
import lombok.SneakyThrows;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static homeworks.dmytro_k.hw_2024.sql.hw_16_06_24.ConstantsUtil.*;

public class DriverDAO {
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
    private static void myPreparedStatement(String sqlExpression, Driver driver, int driverId) {
        @Cleanup
        Connection connection = getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(sqlExpression);
        preparedStatement.setString(1, driver.getFirstName());
        preparedStatement.setString(2, driver.getLastName());
        preparedStatement.setInt(3, driver.getAge());
        preparedStatement.setString(4, driver.getQualification().toString());
        if (driverId != 0) {
            preparedStatement.setInt(5, driverId);
        }
        preparedStatement.executeUpdate();
    }

    public static void addDriver(Driver driver) {

        myPreparedStatement(INSERT_DRIVER, driver, 0);
    }

    public static void updateDriver(Driver driver, int driverId) {

        myPreparedStatement(UPDATE_DRIVER, driver, driverId);
    }

    @SneakyThrows(SQLException.class)
    public static void deleteDriver(int driverId) {
        @Cleanup
        Connection connection = getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(DELETE_TRUCK);
        preparedStatement.setInt(1, driverId);
        preparedStatement.executeUpdate();
    }

    @SneakyThrows(SQLException.class)
    private static void addDriversToList(String sqlExpression, int filterValue) {

        List<Driver> drivers = new ArrayList<>();

        @Cleanup
        Connection connection = getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(sqlExpression);

        if (filterValue != 0) {
            preparedStatement.setInt(1, filterValue);
        }

        ResultSet resultSet = preparedStatement.executeQuery();

        while (resultSet.next()) {
            int driverId = resultSet.getInt("driver_id");
            String firstName = resultSet.getString("firstName");
            String lastName = resultSet.getString("lastName");
            int age = resultSet.getInt("age");
            String qualification = resultSet.getString("qualification");

            Driver driver = new Driver(firstName, lastName, age, qualification);
            Qualification qualification1 = Qualification.valueOf(qualification);
            driver.setDriverId(driverId);
            drivers.add(driver);
        }
        drivers.forEach(System.out::println);
    }

    public static void getAllDrivers() {

        addDriversToList(SELECT_ALL_DRIVERS, 0);
    }

    public static void getDriverById(int driverId) {

        addDriversToList(SELECT_DRIVER_BY_ID, driverId);
    }

    public static void getTrucksForDriver(int driverId) {

        TruckDAO.getTruckByValue(SELECT_TRUCKS_FOR_DRIVER, driverId);
    }
}

