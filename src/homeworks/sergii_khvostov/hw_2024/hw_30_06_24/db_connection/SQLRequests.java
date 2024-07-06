package homeworks.sergii_khvostov.hw_2024.hw_30_06_24.db_connection;

public class SQLRequests {
    public static String addOrder = "INSERT INTO orders (order_number, order_date) VALUES (?, ?)";
    public static String addOrderItems = "INSERT INTO order_items (order_id, product_id, quantity) VALUES (?, ?, ?)";
    public static String getAllOrders = "SELECT id, order_number, order_date FROM orders";
    public static String getByIdOrders = "SELECT id, order_number, order_date FROM orders WHERE id = ?";
    public static String updateOrder = "UPDATE orders SET order_number = ?, order_date = ? WHERE id = ?";
    public static String deleteOrder = "DELETE FROM orders WHERE id = ?";
    public static String addProduct = "INSERT INTO products (name, description, price) VALUES (?, ?, ?)";
    public static String getAllProducts = "SELECT id, name, description, price FROM products";
    public static String getByIdProduct = "SELECT id, name, description, price FROM products WHERE id = ?";
    public static String updateProduct = "UPDATE products SET name = ?, description = ?, price = ? WHERE id = ?";
    public static String deleteProduct = "DELETE FROM products WHERE id = ?";
}
