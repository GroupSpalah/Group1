package homeworks.sergii_khvostov.hw_2024.hw_30_06_24.dao;


import homeworks.sergii_khvostov.hw_2024.hw_30_06_24.db_connection.DatabaseConnection;
import homeworks.sergii_khvostov.hw_2024.hw_30_06_24.domain.Product;
import lombok.Cleanup;
import lombok.SneakyThrows;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static homeworks.sergii_khvostov.hw_2024.hw_30_06_24.db_connection.SQLRequests.*;

public class ProductDAO implements CrudDao<Product> {

    @SneakyThrows
    public void add(Product product) {
        @Cleanup
        Connection connection = DatabaseConnection.getConnection();
        PreparedStatement statement = connection.prepareStatement(addProduct, Statement.RETURN_GENERATED_KEYS);
        statement.setString(1, product.getName());
        statement.setString(2, product.getDescription());
        statement.setBigDecimal(3, product.getPrice());
        statement.executeUpdate();
        ResultSet generatedKeys = statement.getGeneratedKeys();

        product.setId(generatedKeys.getInt(1));
    }


    @SneakyThrows
    public List<Product> getAll() {
        List<Product> products = new ArrayList<>();
        @Cleanup
        Connection connection = DatabaseConnection.getConnection();
        PreparedStatement statement = connection.prepareStatement(getAllProducts);
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()) {
            Product product = new Product();
            product.setId(resultSet.getInt("id"));
            product.setName(resultSet.getString("name"));
            product.setDescription(resultSet.getString("description"));
            product.setPrice(resultSet.getBigDecimal("price"));
            products.add(product);
        }
        return products;
    }

    @SneakyThrows
    public Product getById(int productId) {
        @Cleanup
        Connection connection = DatabaseConnection.getConnection();
        PreparedStatement statement = connection.prepareStatement(getByIdProduct);
        statement.setInt(1, productId);
        ResultSet resultSet = statement.executeQuery();
        Product product = new Product();
        product.setId(resultSet.getInt("id"));
        product.setName(resultSet.getString("name"));
        product.setDescription(resultSet.getString("description"));
        product.setPrice(resultSet.getBigDecimal("price"));

        return product;
    }

    @SneakyThrows
    public void update(Product product) {
        @Cleanup
        Connection connection = DatabaseConnection.getConnection();
        PreparedStatement statement = connection.prepareStatement(updateProduct);
        statement.setString(1, product.getName());
        statement.setString(2, product.getDescription());
        statement.setBigDecimal(3, product.getPrice());
        statement.setInt(4, product.getId());
        statement.executeUpdate();
    }


    @SneakyThrows
    public void delete(int productId) {
        @Cleanup
        Connection connection = DatabaseConnection.getConnection();
        PreparedStatement statement = connection.prepareStatement(deleteProduct);
        statement.setInt(1, productId);
        statement.executeUpdate();
    }
}


