package homeworks.vladyslav_lazin.hw_2024.hw_30_06_24.dao.impl;

import homeworks.vladyslav_lazin.hw_2024.hw_30_06_24.dao.OrderDao;
import homeworks.vladyslav_lazin.hw_2024.hw_30_06_24.domain.Order;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@FieldDefaults(level = AccessLevel.PRIVATE)
public class OrderDaoImpl implements OrderDao {
    String sqlQuery;
    final Connection connection = ConnectionUtil.getConnection();

    @Override
    public void save(Order order) {
        sqlQuery = "INSERT INTO orders (numb, receipt_date) " +
                    "VALUES (?, ?)";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery)) {
            preparedStatement.setInt(1, order.getOrderNumber());
            preparedStatement.setDate(2, Date.valueOf(order.getReceiptDate()));
            preparedStatement.execute();
        } catch (SQLException e) {
            System.out.println("Failed db connection");
        }
    }

    @Override
    public void addProductToOrder(int orderId, int productId) {
        sqlQuery = "INSERT INTO order_to_product (fk_order_id, fk_product_id) " +
                    "VALUES (?, ?)";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery)) {
            preparedStatement.setInt(1, orderId);
            preparedStatement.setInt(2, productId);
            preparedStatement.execute();
        } catch (SQLException e) {
            System.out.println("Failed db connection");
        }
    }
}
