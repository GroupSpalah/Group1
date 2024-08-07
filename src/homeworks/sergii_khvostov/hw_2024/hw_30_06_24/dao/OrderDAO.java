package homeworks.sergii_khvostov.hw_2024.hw_30_06_24.dao;

import homeworks.sergii_khvostov.hw_2024.hw_30_06_24.db_connection.DatabaseConnection;
import homeworks.sergii_khvostov.hw_2024.hw_30_06_24.domain.Order;
import homeworks.sergii_khvostov.hw_2024.hw_30_06_24.domain.Product;
import lombok.Cleanup;
import lombok.NoArgsConstructor;
import lombok.SneakyThrows;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static homeworks.sergii_khvostov.hw_2024.hw_30_06_24.db_connection.SQLRequests.*;


@NoArgsConstructor
public class OrderDAO implements CrudDao<Order> {

    @SneakyThrows
    public void add(Order order) {
        @Cleanup
        Connection connection = DatabaseConnection.getConnection();
        @Cleanup
        PreparedStatement orderStatement = connection.prepareStatement(ADD_ORDER, Statement.RETURN_GENERATED_KEYS);
        orderStatement.setString(1, order.getOrderNumber());
        orderStatement.setDate(2, Date.valueOf(order.getOrderDate()));
        orderStatement.executeUpdate();
        ResultSet generatedKeys = orderStatement.getGeneratedKeys();
        if (generatedKeys.next()) {
            int orderId = generatedKeys.getInt(1);
            @Cleanup
            PreparedStatement itemStatement = connection.prepareStatement(ADD_ORDER_ITEMS);

            for (Product product : order.getProducts().keySet()) {
                itemStatement.setInt(1, orderId);
                itemStatement.setInt(2, product.getId());
                itemStatement.setInt(3, order.getProducts().get(product));
                itemStatement.addBatch();
            }

            order.getProducts();

            itemStatement.executeBatch();
        }
    }

    @SneakyThrows
    public List<Order> getAll() {
        List<Order> orders = new ArrayList<>();
        @Cleanup
        Connection connection = DatabaseConnection.getConnection();
        @Cleanup
        PreparedStatement statement = connection.prepareStatement(GET_ALL_ORDERS);
        @Cleanup
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()) {
            Order order = new Order();
            order.setId(resultSet.getInt("id"));
            order.setOrderNumber(resultSet.getString("order_number"));
            order.setOrderDate(resultSet.getDate("order_date").toLocalDate());
            orders.add(order);
        }
        return orders;
    }

    @SneakyThrows
    public Order getById(int orderId) {
        @Cleanup
        Connection connection = DatabaseConnection.getConnection();
        @Cleanup
        PreparedStatement statement = connection.prepareStatement(GET_BY_ID_ORDER);
        statement.setInt(1, orderId);
        @Cleanup
        ResultSet resultSet = statement.executeQuery();
        if (resultSet.next()) {
            Order order = new Order();
            order.setId(resultSet.getInt("id"));
            order.setOrderNumber(resultSet.getString("order_number"));
            order.setOrderDate(resultSet.getDate("order_date").toLocalDate());
            return order;
        }
        return null;
    }

    @SneakyThrows
    public void update(Order order) {
        @Cleanup
        Connection connection = DatabaseConnection.getConnection();
        @Cleanup
        PreparedStatement statement = connection.prepareStatement(UPDATE_ORDER);
        statement.setString(1, order.getOrderNumber());
        statement.setDate(2, Date.valueOf(order.getOrderDate()));
        statement.setInt(3, order.getId());
        statement.executeUpdate();
    }

    @SneakyThrows
    public void delete(int orderId) {
        @Cleanup
        Connection connection = DatabaseConnection.getConnection();
        @Cleanup
        PreparedStatement statement = connection.prepareStatement(DELETE_ORDER);
        statement.setInt(1, orderId);
        statement.executeUpdate();
    }
}


