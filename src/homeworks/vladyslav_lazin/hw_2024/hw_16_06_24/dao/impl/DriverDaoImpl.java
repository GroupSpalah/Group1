package homeworks.vladyslav_lazin.hw_2024.hw_16_06_24.dao.impl;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import homeworks.vladyslav_lazin.hw_2024.hw_16_06_24.dao.ConnectionUtil;
import homeworks.vladyslav_lazin.hw_2024.hw_16_06_24.dao.DriverDao;
import homeworks.vladyslav_lazin.hw_2024.hw_16_06_24.model.Driver;
import homeworks.vladyslav_lazin.hw_2024.hw_16_06_24.model.Qualification;
import homeworks.vladyslav_lazin.hw_2024.hw_16_06_24.model.Truck;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = AccessLevel.PRIVATE)
public class DriverDaoImpl implements DriverDao {
    private final Connection connection = ConnectionUtil.getConnection();

    @Override
    public void save(Driver driver) {
        String sqlQuery = "INSERT INTO drivers (first_name, last_name, age, qualification) " +
                "VALUES (?, ?, ?, ?)";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery)) {
            preparedStatement.setString(1, driver.getFirstName());
            preparedStatement.setString(2, driver.getLastName());
            preparedStatement.setInt(3, driver.getAge());
            preparedStatement.setString(4, String.valueOf(driver.getQualification()));
            preparedStatement.execute();
        } catch (SQLException e) {
            System.out.println("Failed db connection");
        }
    }

    @Override
    public void setTruckToDriverById(int driverId, int truckId) {
        String sqlQuery = "UPDATE trucks " +
                "SET fk_driver_id = ? " +
                "WHERE truck_id = ?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery)) {
            preparedStatement.setInt(1, driverId);
            preparedStatement.setInt(2, truckId);
            preparedStatement.execute();

        } catch (SQLException e) {
            System.out.println("Failed db connection");
        }
    }

    @Override
    public Driver findById(int id) {
        String sqlQuery = "SELECT * " +
                "FROM drivers " +
                "WHERE driver_id = ?";
        Driver driver = new Driver();

        try (PreparedStatement pStatementDriver = connection.prepareStatement(sqlQuery)) {
            pStatementDriver.setInt(1, id);

            ResultSet resultSetDriver = pStatementDriver.executeQuery();
            resultSetDriver.next();
            mapDriverFromResultSet(driver, resultSetDriver);
        } catch (SQLException e) {
            System.out.println("Failed db connection");
        }
        driver.setTrucks(findTrucksByDriver(driver));
        return driver;
    }

    public List<Driver> findAll() {
        String sqlQuery = "SELECT * FROM drivers";
        List<Driver> drivers = new ArrayList<>();

        try (Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery(sqlQuery)) {
            while (resultSet.next()) {
                Driver driver = new Driver();
                mapDriverFromResultSet(driver, resultSet);
                driver.setTrucks(findTrucksByDriver(driver));
                drivers.add(driver);
            }

        } catch (SQLException e) {
            System.out.println("Failed db connection");
        }
        return drivers;
    }


    private void mapDriverFromResultSet(Driver driver, ResultSet resultSet) throws SQLException {
        driver.setId(resultSet.getInt("driver_id"));
        driver.setFirstName(resultSet.getString("first_name"));
        driver.setLastName(resultSet.getString("last_name"));
        driver.setAge(resultSet.getInt("age"));
        driver.setQualification(switch (resultSet.getString("qualification")) {
            case "TRAINY" -> Qualification.TRAINY;
            case "PRO" -> Qualification.PRO;
            case "EXPERT" -> Qualification.EXPERT;
            default -> throw new IllegalArgumentException("Unexpected value: " +
                    resultSet.getString("qualification"));
        });
    }

    private List<Truck> findTrucksByDriver(Driver driver) {
        String sqlQuery = "SELECT t.truck_id, t.model, t.model_year " +
                "FROM drivers d " +
                "INNER JOIN trucks t " +
                "ON t.fk_driver_id = d.driver_id " +
                "WHERE d.driver_id = ?";
        List<Truck> trucks = new ArrayList<>();
        try (PreparedStatement pStatementTrucks = connection.prepareStatement(sqlQuery)) {
            pStatementTrucks.setInt(1, driver.getId());
            ResultSet resultSetTrucks = pStatementTrucks.executeQuery();
            while (resultSetTrucks.next()) {
                Truck truck = new Truck();
                truck.setId(resultSetTrucks.getInt("truck_id"));
                truck.setModel(resultSetTrucks.getString("model"));
                truck.setModelYear(resultSetTrucks.getInt("model_year"));
                trucks.add(truck);
            }
        } catch (SQLException e) {
            System.out.println("Failed db connection");
        }
        return trucks;
    }
}
