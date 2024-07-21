package homeworks.dmytro_k.hw_2024.sql.hw_30_06_24.dao.impl;

import homeworks.dmytro_k.hw_2024.sql.hw_30_06_24.dao.ModificationDao;
import homeworks.dmytro_k.hw_2024.sql.hw_30_06_24.domain.Order;
import homeworks.dmytro_k.hw_2024.sql.hw_30_06_24.domain.OrderDetail;
import homeworks.dmytro_k.hw_2024.sql.hw_30_06_24.domain.Product;
import homeworks.dmytro_k.hw_2024.sql.hw_30_06_24.util.ConnectionUtil;
import lombok.Cleanup;
import lombok.SneakyThrows;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static homeworks.dmytro_k.hw_2024.sql.hw_30_06_24.util.ConstantsUtil.*;

public class ModificationDaoImpl implements ModificationDao {

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

        orderDetailsList.forEach(details -> {
            try {
                insertOrderDetailsStmt.setInt(1, getLastInsertedOrderId());
                insertOrderDetailsStmt.setInt(2, details.getProduct().getId());
                insertOrderDetailsStmt.setInt(3, details.getQuantity());
                insertOrderDetailsStmt.addBatch();
            } catch (SQLException e) {
//                throw new RuntimeException(e);
                try {
                    conn.rollback();
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
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

    @SneakyThrows
    private List<OrderDetail> getOrderDetailsForToday(Connection conn, Date sqlDate) {

        List<OrderDetail> orderDetailsList = new ArrayList<>();

        @Cleanup PreparedStatement stmt = conn.prepareStatement(GET_ORDER_DETAIL);
        stmt.setDate(1, sqlDate);
        @Cleanup ResultSet rs = stmt.executeQuery();
        while (rs.next()) {

            Product product = Product
                    .builder()
                    .id(rs.getInt("product_id"))
                    .name(rs.getString("name"))
                    .description(rs.getString("description"))
                    .price(rs.getFloat("price"))
                    .build();

            orderDetailsList.add(OrderDetail
                    .builder()
                    //.product.setId(rs.getInt("product_id"))
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
