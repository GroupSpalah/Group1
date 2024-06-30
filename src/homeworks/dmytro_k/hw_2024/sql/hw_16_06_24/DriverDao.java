package homeworks.dmytro_k.hw_2024.sql.hw_16_06_24;

import lombok.Cleanup;
import lombok.SneakyThrows;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import static homeworks.dmytro_k.hw_2024.sql.hw_16_06_24.ConnectionUtil.*;
import static homeworks.dmytro_k.hw_2024.sql.hw_16_06_24.ConstantsUtil.*;

public class DriverDao implements DaoDriver {

    @SneakyThrows(SQLException.class)
    private void getPreparedStatement(String sqlExpression, Driver driver, int driverId) {

        @Cleanup
        Connection connection = getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(sqlExpression);
        preparedStatement.setString(1, driver.getFirstName());
        preparedStatement.setString(2, driver.getLastName());
        preparedStatement.setInt(3, driver.getAge());
        preparedStatement.setString(4, driver
                .getQualification()
                .toString()
                .toLowerCase(Locale.ROOT));
        if (driverId != 0) {
            preparedStatement.setInt(5, driverId);
        }
        preparedStatement.executeUpdate();
        disconnect(connection, preparedStatement, null);
    }

    public void addDriver(Driver driver) {
        getPreparedStatement(INSERT_DRIVER, driver, 0);
    }

    public void updateDriver(Driver driver, int driverId) {
        getPreparedStatement(UPDATE_DRIVER, driver, driverId);
    }

    @SneakyThrows(SQLException.class)
    public void deleteDriver(int driverId) {
        @Cleanup
        Connection connection = getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(DELETE_DRIVER);
        preparedStatement.setInt(1, driverId);
        preparedStatement.executeUpdate();
        disconnect(connection, preparedStatement, null);
    }

    @SneakyThrows(SQLException.class)
    private List<Driver> getDriverList(String sqlExpression, int filterValue) {

        List<Driver> drivers = new ArrayList<>();

        @Cleanup
        Connection connection = getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(sqlExpression);

        if (filterValue != 0) {
            preparedStatement.setInt(1, filterValue);
        }

        ResultSet resultSet = preparedStatement.executeQuery();

        while (resultSet.next()) {
            int id = resultSet.getInt("driver_id");
            String firstName = resultSet.getString("firstName");
            String lastName = resultSet.getString("lastName");
            int age = resultSet.getInt("age");
            String qualificationValue = resultSet.getString("qualification");
            Qualification qualification = Qualification.valueOf(qualificationValue.toUpperCase());

            drivers.add(
                    Driver
                            .builder()
                            .id(id)
                            .firstName(firstName)
                            .lastName(lastName)
                            .age(age)
                            .qualification(qualification)
                            .truckList(getTrucksForDriver(id))
                            .build()
            );
        }
        disconnect(connection, preparedStatement, resultSet);
        return drivers;
    }

    public List<Driver> getAllDrivers() {
        return getDriverList(SELECT_ALL_DRIVERS, 0);
    }

    public Driver getDriverById(int driverId) {
        return getDriverList(SELECT_DRIVER_BY_ID, driverId).getFirst();
    }

    public List<Truck> getTrucksForDriver(int driverId) {
        TruckDao truckDAO = new TruckDao();
        return truckDAO.getTrucksByValue(SELECT_TRUCKS_FOR_DRIVER, driverId);
    }
}