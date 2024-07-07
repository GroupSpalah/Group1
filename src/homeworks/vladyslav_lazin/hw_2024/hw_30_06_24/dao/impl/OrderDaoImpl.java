package homeworks.vladyslav_lazin.hw_2024.hw_30_06_24.dao.impl;

import homeworks.vladyslav_lazin.hw_2024.hw_30_06_24.dao.OrderDao;
import homeworks.vladyslav_lazin.hw_2024.hw_30_06_24.domain.Order;
import homeworks.vladyslav_lazin.hw_2024.hw_30_06_24.domain.Product;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

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

    @Override
    public Order findById(int id) {
        sqlQuery = "SELECT * " +
                "FROM orders WHERE order_id = ?";
        Order order = new Order();

        try (PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery)) {
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            order.setId(resultSet.getInt("order_id"));
            order.setOrderNumber(resultSet.getInt("numb"));
            order.setReceiptDate(resultSet.getDate("receipt_date").toLocalDate());
        }  catch (SQLException e) {
            System.out.println("Find order by id was failure");
        }
        List<Product> productsInOrder = findProductsByOrderId(id);
        if (!productsInOrder.isEmpty()) {
            order.setProducts(productsInOrder.stream()
                    .collect(Collectors.toMap(
                            product -> product,
                            product -> 1,
                            Integer::sum
                    )));
        }
        return order;
    }

    private List<Product> findProductsByOrderId(int id) {
        sqlQuery = "SELECT p.product_id, p.name, p.description, p.price " +
                "FROM orders o " +
                "INNER JOIN order_to_product otp " +
                "ON o.order_id = otp.fk_order_id " +
                "INNER JOIN products p " +
                "ON otp.fk_product_id = p.product_id " +
                "WHERE o.order_id = ?";
        List<Product> products = new ArrayList<>();
        try (PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery)){
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Product product = new Product();
                product.setId(resultSet.getInt("product_id"));
                product.setName(resultSet.getString("name"));
                product.setDescription(resultSet.getString("description"));
                product.setPrice(resultSet.getFloat("price"));
                products.add(product);
            }
        }  catch (SQLException e) {
            System.out.println("Failed db connection");
        }
        return products;
    }
}
