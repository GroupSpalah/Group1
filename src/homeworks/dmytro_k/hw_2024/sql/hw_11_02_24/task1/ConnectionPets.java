package homeworks.dmytro_k.hw_2024.sql.hw_11_02_24.task1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectionPets {

    private static final String URL = "jdbc:mysql://localhost:3306/pets";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "af66s60dk29l97j;";

    public static void main(String[] args) {
        try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
             Statement statement = connection.createStatement()) {

            statement.executeBatch();
            statement.clearBatch();
        } catch (SQLException e) {
            System.out.println("Failed db connection");
            throw new RuntimeException(e);
        }
    }
}
