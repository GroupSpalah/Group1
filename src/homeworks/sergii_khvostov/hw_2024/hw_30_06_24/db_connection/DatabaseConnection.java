package homeworks.sergii_khvostov.hw_2024.hw_30_06_24.db_connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

    private static final String URL = "jdbc:mysql://localhost:3306/your_database_name";
    private static final String USER = "your_database_username";
    private static final String PASSWORD = "your_database_password";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}