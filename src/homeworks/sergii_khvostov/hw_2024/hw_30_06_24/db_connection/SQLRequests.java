package homeworks.sergii_khvostov.hw_2024.hw_30_06_24.db_connection;

public class SQLRequests {
    public static final String ADD_ORDER = "INSERT INTO orders (order_number, order_date) VALUES (?, ?)";
    public static final String ADD_ORDER_ITEMS = "INSERT INTO order_items (order_id, product_id, quantity) VALUES (?, ?, ?)";
    public static final String GET_ALL_ORDERS = "SELECT id, order_number, order_date FROM orders";
    public static final String GET_BY_ID_ORDER = "SELECT id, order_number, order_date FROM orders WHERE id = ?";
    public static final String UPDATE_ORDER = "UPDATE orders SET order_number = ?, order_date = ? WHERE id = ?";
    public static final String DELETE_ORDER = "DELETE FROM orders WHERE id = ?";
    public static final String ADD_PRODUCT = "INSERT INTO products (name, description, price) VALUES (?, ?, ?)";
    public static final String GET_ALL_PRODUCTS = "SELECT id, name, description, price FROM products";
    public static final String GET_BY_ID_PRODUCT = "SELECT id, name, description, price FROM products WHERE id = ?";
    public static final String UPDATE_PRODUCT = "UPDATE products SET name = ?, description = ?, price = ? WHERE id = ?";
    public static final String DELETE_PRODUCT = "DELETE FROM products WHERE id = ?";
}
