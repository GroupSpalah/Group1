package homeworks.dmytro_k.hw_2024.sql.hw_30_06_24.dao.impl;

import homeworks.dmytro_k.hw_2024.sql.hw_30_06_24.dao.QueryExecutorDao;
import homeworks.dmytro_k.hw_2024.sql.hw_30_06_24.domain.Order;
import homeworks.dmytro_k.hw_2024.sql.hw_30_06_24.domain.OrderDetail;
import homeworks.dmytro_k.hw_2024.sql.hw_30_06_24.domain.Product;
import homeworks.dmytro_k.hw_2024.sql.hw_30_06_24.util.ConnectionUtil;
import lombok.Cleanup;
import lombok.SneakyThrows;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import static homeworks.dmytro_k.hw_2024.sql.hw_30_06_24.util.ConstantsUtil.SELECT_ORDER_DETAILS;

public class QueryExecutorDaoImpl implements QueryExecutorDao {

    @SneakyThrows(SQLException.class)
    public Order getOrderDetails(int orderId) {

        Order order;

        Connection conn = ConnectionUtil.getConnection();
        @Cleanup PreparedStatement stmt = conn.prepareStatement(SELECT_ORDER_DETAILS);
        stmt.setInt(1, orderId);
        @Cleanup ResultSet rs = stmt.executeQuery();

        order = Order.builder()
                .id(orderId)
                .orderDate(rs.getDate("order_date").toLocalDate())
                .build();

        while (rs.next()) {

            Product product = Product
                    .builder()
                    .name(rs.getString("product_name"))
                    .description(rs.getString("product_description"))
                    .price(rs.getFloat("product_price"))
                    .build();

            OrderDetail orderDetail = OrderDetail
                    .builder()
                    .productId(product.getId())
                    .quantity(rs.getInt("quantity"))
                    .build();
            order.addOrderDetail(orderDetail);
        }
        return order;
    }

    @Override
    public List<Integer> getOrdersBySumAndProductCount(float amount, int productCount) {
        return null;
    }

    @Override
    public List<Integer> getOrdersContainingProduct(int productId) {
        return null;
    }

    @Override
    public List<Integer> getOrdersNotContainingProductToday(int productId) {
        return null;
    }

}
