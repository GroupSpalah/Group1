package homeworks.dmytro_k.hw_2024.sql.hw_30_06_24.dao.impl;

import homeworks.dmytro_k.hw_2024.sql.hw_30_06_24.dao.ModificationExecutorDao;
import homeworks.dmytro_k.hw_2024.sql.hw_30_06_24.domain.Order;
import homeworks.dmytro_k.hw_2024.sql.hw_30_06_24.domain.OrderDetail;
import homeworks.dmytro_k.hw_2024.sql.hw_30_06_24.util.ConnectionUtil;
import lombok.Cleanup;
import lombok.SneakyThrows;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static homeworks.dmytro_k.hw_2024.sql.hw_30_06_24.util.ConstantsUtil.*;

public class ModificationExecutorDaoImpl implements ModificationExecutorDao {

    @SneakyThrows(SQLException.class)
    public void createOrderFromToday() {

        LocalDate today = LocalDate.now();
        Date sqlDate = Date.valueOf(today);

        @Cleanup Connection conn = ConnectionUtil.getConnection();
        conn.setAutoCommit(false);

        @Cleanup PreparedStatement insertOrderStmt = conn.prepareStatement(INSERT_ORDER_QUERY);
        insertOrderStmt.setDate(1, sqlDate);
        insertOrderStmt.executeUpdate();

        Order
                .builder()
                .id(getLastInsertedOrderId())
                .orderDate(today)
                .build();

        List<OrderDetail> orderDetailsList = getOrderDetailsForToday(conn, sqlDate);
        @Cleanup PreparedStatement insertOrderDetailsStmt = conn.prepareStatement(INSERT_ORDER_DETAILS_QUERY);

/*        for (OrderDetail details : orderDetailsList) {
            insertOrderDetailsStmt.setInt(1, getLastInsertedOrderId());
            insertOrderDetailsStmt.setInt(2, details.getProductId());
            insertOrderDetailsStmt.setInt(3, details.getQuantity());
            insertOrderDetailsStmt.addBatch();
        }*/
/*        int index = 0;
        while (index < orderDetailsList.size()) {
            OrderDetails details = orderDetailsList.get(index);
            insertOrderDetailsStmt.setInt(1, getLastInsertedOrderId());
            insertOrderDetailsStmt.setInt(2, details.getProductId());
            insertOrderDetailsStmt.setInt(3, details.getQuantity());
            insertOrderDetailsStmt.addBatch();

            index++;
        }*/
        orderDetailsList.forEach(details -> {
            try {
                insertOrderDetailsStmt.setInt(1, getLastInsertedOrderId());
                insertOrderDetailsStmt.setInt(2, details.getProductId());
                insertOrderDetailsStmt.setInt(3, details.getQuantity());
                insertOrderDetailsStmt.addBatch();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        });


        insertOrderDetailsStmt.executeBatch();
        conn.commit();
    }

    @SneakyThrows
    private int getLastInsertedOrderId() {
        int lastInsertedId = 0;

        Connection conn = ConnectionUtil.getConnection();
        @Cleanup PreparedStatement stmt = conn.prepareStatement(LAST_INSERT_ID);

        @Cleanup ResultSet rs = stmt.executeQuery();

        lastInsertedId = rs.getInt(1);

        return lastInsertedId;
    }

/*    @SneakyThrows
    private List<OrderDetail> getOrderDetailsForToday(Date sqlDate) {
        List<OrderDetail> orderDetailsList = new ArrayList<>();
        String query = "SELECT od.order_detail_id, od.quantity, p.product_id, p.product_name, p.product_description, p.price " +
                "FROM order_details od " +
                "JOIN orders o ON od.order_id = o.order_id " +
                "JOIN products p ON od.product_id = p.product_id " +
                "WHERE o.order_date = ?";

        Connection conn = ConnectionUtil.getConnection();
        @Cleanup PreparedStatement stmt = conn.prepareStatement(query);
        stmt.setDate(1, sqlDate);

        @Cleanup ResultSet rs = stmt.executeQuery();
        while (rs.next()) {
            int orderDetailId = rs.getInt("order_detail_id");
            int quantity = rs.getInt("quantity");
            int productId = rs.getInt("product_id");
            String productName = rs.getString("product_name");
            String productDescription = rs.getString("product_description");
            double price = rs.getDouble("price");

            Product product = new Product(productId, productName, productDescription, price);
            OrderDetails orderDetails = new OrderDetails(null, product, quantity);
            orderDetails.setOrderDetailId(orderDetailId);

            orderDetailsList.add(orderDetails);
        }

        return orderDetailsList;
    }*/


    @SneakyThrows
    private List<OrderDetail> getOrderDetailsForToday(Connection conn, Date sqlDate) {

        List<OrderDetail> orderDetailsList = new ArrayList<>();

        @Cleanup PreparedStatement stmt = conn.prepareStatement(GET_ORDER_DETAIL);
        stmt.setDate(1, sqlDate);
        @Cleanup ResultSet rs = stmt.executeQuery();
        while (rs.next()) {

            orderDetailsList.add(OrderDetail
                    .builder()
                    .productId(rs.getInt("product_id"))
                    .quantity(rs.getInt("quantity"))
                    .build());
        }
        return orderDetailsList;
    }

    @SneakyThrows
    public void deleteOrdersByProductQuantity(int productId, int quantity) {
        Connection conn = ConnectionUtil.getConnection();
        @Cleanup PreparedStatement stmt = conn.prepareStatement(DELETE_ORDERS);
        stmt.setInt(1, productId);
        stmt.setInt(2, quantity);

        stmt.executeUpdate();
    }
}
