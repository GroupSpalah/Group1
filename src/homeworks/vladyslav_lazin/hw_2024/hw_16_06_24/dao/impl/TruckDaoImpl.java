package homeworks.vladyslav_lazin.hw_2024.hw_16_06_24.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import homeworks.vladyslav_lazin.hw_2024.hw_16_06_24.dao.ConnectionUtil;
import homeworks.vladyslav_lazin.hw_2024.hw_16_06_24.dao.TruckDao;
import homeworks.vladyslav_lazin.hw_2024.hw_16_06_24.model.Truck;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = AccessLevel.PRIVATE)
public class TruckDaoImpl implements TruckDao {
    final Connection connection = ConnectionUtil.getConnection();

    @Override
    public void save(Truck truck) {
        String sqlQuery = "INSERT INTO trucks (model, model_year) VALUES (?, ?)";
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
        String sqlQuery = "SELECT * " +
                        "FROM trucks " + 
                        "WHERE truck_id = ?";
        Truck truck = new Truck();
        try (PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery)) {
            
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            truck.setId(resultSet.getInt("truck_id"));
            truck.setModel(resultSet.getString("model"));
            truck.setModelYear(resultSet.getInt("model_year"));
            
        } catch (SQLException e) {
            System.out.println("Failed db connection");
        }

    return truck;
    }
    // @Override
    // public void update(Truck truck) {
    //
    // }
    //
    // @Override
    // public void deleteById(int id) {
    //
    // }

    

    // @Override
    // public List<Truck> findAll() {
    // return List.of();
    // }
}
