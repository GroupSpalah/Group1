package homeworks.dmytro_k.hw_2024.sql.hw_30_06_24.dao.impl;

import homeworks.dmytro_k.hw_2024.sql.hw_30_06_24.dao.ExtractorDao;
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
import java.util.ArrayList;
import java.util.List;

import static homeworks.dmytro_k.hw_2024.sql.hw_30_06_24.util.ConstantsUtil.*;



public class ExtractorDaoImpl implements ExtractorDao {

    @Override
    @SneakyThrows(SQLException.class)
    public Order getOrderDetails(int orderId) {

        Order order = null;

        Connection conn = ConnectionUtil.getConnection();
        @Cleanup PreparedStatement stmt = conn.prepareStatement(SELECT_ORDERS_DETAILS);
        stmt.setInt(1, orderId);
        @Cleanup ResultSet rs = stmt.executeQuery();

        while (rs.next()) {
            if (order == null) {
                order = Order.builder()
                        .id(orderId)
                        .orderDate(rs.getDate("order_date").toLocalDate())
                        .build();
            }

            Product product = Product
                    .builder()
                    .id(rs.getInt("product_id"))
                    .name(rs.getString("name"))
                    .description(rs.getString("description"))
                    .price(rs.getFloat("price"))
                    .build();

            OrderDetail orderDetail = OrderDetail
                    .builder()
                    .product(product)
                    .quantity(rs.getInt("quantity"))
                    .build();
            order.addOrderDetail(orderDetail);
        }
        return order;
    }

    @Override
    @SneakyThrows(SQLException.class)
    public List<Integer> getOrdersBySumAndProductCount(float sum, int productCount) {

        List<Integer> orderIds = new ArrayList<>();

        Connection conn = ConnectionUtil.getConnection();//убрать дубликацию
        @Cleanup PreparedStatement stmt = conn.prepareStatement(PRODUCT_BY_SUM_AND_QUANTITY);
        stmt.setDouble(1, sum);
        stmt.setInt(2, productCount);

        @Cleanup ResultSet rs = stmt.executeQuery();
        while (rs.next()) {
            orderIds.add(rs.getInt(ORDER_ID));
        }

        return orderIds;
    }

    @Override
    @SneakyThrows(SQLException.class)
    public List<Integer> getOrdersContainingProduct(int productId) {

        List<Integer> orderIds = new ArrayList<>();

        Connection conn = ConnectionUtil.getConnection();
        @Cleanup PreparedStatement stmt = conn.prepareStatement(ORDERS_CONTAINING_PRODUCT_ID);
        stmt.setInt(1, productId);

        @Cleanup ResultSet rs = stmt.executeQuery();
        while (rs.next()) {
            orderIds.add(rs.getInt(ORDER_ID));
        }

        return orderIds;
    }

    @Override
    @SneakyThrows(SQLException.class)
    public List<Integer> getOrdersNotContainingProductToday(int productId) {

        List<Integer> orderIds = new ArrayList<>();

        Connection conn = ConnectionUtil.getConnection();
        @Cleanup PreparedStatement stmt = conn.prepareStatement(ORDERS_WITHOUT_PRODUCT_TODAY);
        stmt.setInt(1, productId);

        @Cleanup ResultSet rs = stmt.executeQuery();
        while (rs.next()) {
            orderIds.add(rs.getInt(ORDER_ID));
        }

        return orderIds;
    }


}
