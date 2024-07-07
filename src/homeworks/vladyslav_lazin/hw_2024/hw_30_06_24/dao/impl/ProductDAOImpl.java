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
                "FROM  products " +
                "WHERE  product_id = ?";
        Product product = new Product();
        try (PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery)) {
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            product.setId(resultSet.getInt("product_id"));
            product.setName(resultSet.getString("name"));
            product.setDescription(resultSet.getString("description"));
            product.setPrice(resultSet.getFloat("price"));

        } catch (SQLException e) {
            System.out.println("Find product by id was failure!");
        }
        return product;
    }
}
