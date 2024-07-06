package homeworks.vladyslav_lazin.hw_2024.hw_30_06_24.dao.impl;

import homeworks.vladyslav_lazin.hw_2024.hw_30_06_24.dao.ProductDao;
import homeworks.vladyslav_lazin.hw_2024.hw_30_06_24.domain.Product;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@FieldDefaults(level = AccessLevel.PRIVATE)
public class ProductDAOImpl implements ProductDao {
    String sqlQuery;
    final Connection connection = ConnectionUtil.getConnection();

    @Override
    public void save(Product product) {
        sqlQuery = "INSERT INTO products (name, description, price) " +
                    "VALUES (?, ?, ?)";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery)) {
            preparedStatement.setString(1, product.getName());
            preparedStatement.setString(2, product.getDescription());
            preparedStatement.setFloat(3, product.getPrice());
            preparedStatement.execute();
        } catch (SQLException e) {
            System.out.println("Failed db connection");
        }
    }

    @Override
    public Product findById(int id) {
        sqlQuery = "SELECT * " +
                "FROM  orders " +
                "WHERE  order_id = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery)) {
            ResultSet resultSet = preparedStatement.executeQuery();

        } catch (SQLException e) {
            System.out.println("Failed db connection");
        }
        return null;
    }
}
