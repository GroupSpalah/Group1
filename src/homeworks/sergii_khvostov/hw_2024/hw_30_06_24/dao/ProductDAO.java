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
        @Cleanup
        PreparedStatement statement = connection.prepareStatement(ADD_PRODUCT, Statement.RETURN_GENERATED_KEYS);
        statement.setString(1, product.getName());
        statement.setString(2, product.getDescription());
        statement.setBigDecimal(3, product.getPrice());
        statement.executeUpdate();
        @Cleanup
        ResultSet generatedKeys = statement.getGeneratedKeys();

        if (generatedKeys.next()) {
            product.setId(generatedKeys.getInt(1));
        }
    }

    @SneakyThrows
    public List<Product> getAll() {
        List<Product> products = new ArrayList<>();
        @Cleanup
        Connection connection = DatabaseConnection.getConnection();
        @Cleanup
        PreparedStatement statement = connection.prepareStatement(GET_ALL_PRODUCTS);
        @Cleanup
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
        @Cleanup
        PreparedStatement statement = connection.prepareStatement(GET_BY_ID_PRODUCT);
        statement.setInt(1, productId);
        @Cleanup
        ResultSet resultSet = statement.executeQuery();
        if (resultSet.next()) {
            Product product = new Product();
            product.setId(resultSet.getInt("id"));
            product.setName(resultSet.getString("name"));
            product.setDescription(resultSet.getString("description"));
            product.setPrice(resultSet.getBigDecimal("price"));
            return product;
        }
        return null;
    }

    @SneakyThrows
    public void update(Product product) {
        @Cleanup
        Connection connection = DatabaseConnection.getConnection();
        @Cleanup
        PreparedStatement statement = connection.prepareStatement(UPDATE_PRODUCT);
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
        @Cleanup
        PreparedStatement statement = connection.prepareStatement(DELETE_PRODUCT);
        statement.setInt(1, productId);
        statement.executeUpdate();
    }
}


