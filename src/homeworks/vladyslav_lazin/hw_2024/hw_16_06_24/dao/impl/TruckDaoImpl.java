package homeworks.vladyslav_lazin.hw_2024.hw_16_06_24.dao.impl;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import homeworks.vladyslav_lazin.hw_2024.hw_16_06_24.dao.TruckDao;
import homeworks.vladyslav_lazin.hw_2024.hw_16_06_24.model.Truck;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = AccessLevel.PRIVATE)
public class TruckDaoImpl implements TruckDao {
    String sqlQuery;
    final Connection connection = ConnectionUtil.getConnection();

    @Override
    public void save(Truck truck) {
        sqlQuery = "INSERT INTO trucks (model, model_year) VALUES (?, ?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery)) {
            preparedStatement.setString(1, truck.getModel());
            preparedStatement.setInt(2, truck.getModelYear());
            preparedStatement.execute();
        } catch (SQLException e) {
            System.out.println("Failed db connection");
        }
    }

    @Override
    public Truck findById(int id) {
        sqlQuery = "SELECT * " +
                        "FROM trucks " + 
                        "WHERE truck_id = ?";
        Truck truck = new Truck();
        try (PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery)) {
            
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
           mapTruckFromResultSet(truck, resultSet);
            
        } catch (SQLException e) {
            System.out.println("Failed db connection");
        }
    return truck;
    }

    @Override
    public List<Truck> findall() {
        sqlQuery = "SELECT * FROM trucks";
        List<Truck> trucks = new ArrayList<>();
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sqlQuery)){
            while (resultSet.next()) {
                Truck truck = new Truck();
                mapTruckFromResultSet(truck, resultSet);
                trucks.add(truck);
            }
        } catch (SQLException e) {
            System.out.println("Failed db connection");
        }

        return trucks;
    }

    private void mapTruckFromResultSet(Truck truck, ResultSet resultSet) throws SQLException {
        truck.setId(resultSet.getInt("truck_id"));
        truck.setModel(resultSet.getString("model"));
        truck.setModelYear(resultSet.getInt("model_year"));
    }
}
