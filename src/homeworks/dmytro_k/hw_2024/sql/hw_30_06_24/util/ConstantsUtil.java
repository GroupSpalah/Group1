package homeworks.dmytro_k.hw_2024.sql.hw_30_06_24.util;


public class ConstantsUtil {
    static final String URL = "jdbc:mysql://localhost:3306/orders";
    static final String USERNAME = "root";
    static final String PASSWORD = "af66s60dk29l97j;";

    public static final String SELECT_ORDER_DETAILS =
            "SELECT orders.order_id, orders.order_date, products.product_id, products.product_name, " +
                    "products.product_description, products.product_price, order_details.quantity " +
                    "FROM Orders " +
                    "JOIN order_details ON orders.order_id = order_details.order_id " +
                    "JOIN products ON order_details.product_id = products.product_id " +
                    "WHERE orders.order_id = ?";
    public static final String INSERT_ORDER_QUERY =
            "INSERT INTO orders (order_date) " +
                    "VALUES (?)";    //CURDATE()
    public static final String INSERT_ORDER_DETAILS_QUERY =
            "INSERT INTO order_details (FK_order_id, FK_product_id, quantity) " +
                    "VALUES (?, ?, ?)";
    public static final String LAST_INSERT_ID = "SELECT LAST_INSERT_ID()";

    public static final String GET_ORDER_DETAIL =
            "SELECT product_id, quantity " +
                    "FROM OrderDetails " +
                    "JOIN Orders ON orders_details.FK_order_id = orders.order_id " +
                    "WHERE orders.order_date = ?";
    public static final String DELETE_ORDERS =
            "DELETE o, od " +
                    "FROM Orders o " +
                    "JOIN OrderDetails od ON o.order_id = od.order_id " +
                    "WHERE od.product_id = ? AND od.quantity = ?";
}
