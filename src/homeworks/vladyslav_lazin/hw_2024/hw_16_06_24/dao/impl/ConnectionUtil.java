package homeworks.vladyslav_lazin.hw_2024.hw_16_06_24.dao.impl;

import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@FieldDefaults(level = AccessLevel.PRIVATE)
public class ConnectionUtil {
    static final String URL = "jdbc:mysql://localhost:3306/drivers";
    static final String USERNAME = "root";
    static final String PASSWORD = "123";
    static Connection connection;

    public static Connection getConnection() {
        try {
            if (connection == null) {
                connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            }

        } catch (SQLException e) {
            System.out.println("DB isn't accessable");
            e.printStackTrace();
        }
        return connection;
    }

}
