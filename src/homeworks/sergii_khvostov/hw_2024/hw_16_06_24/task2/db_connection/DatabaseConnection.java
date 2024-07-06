package homeworks.sergii_khvostov.hw_2024.hw_16_06_24.task2.db_connection;

import lombok.SneakyThrows;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    private static final String URL = "jdbc:mysql://localhost:3306/driver_truck";
    private static final String USER = "Sergii_Khvostov";
    private static final String PASSWORD = "password";

    @SneakyThrows
    public static Connection getConnection() {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}
