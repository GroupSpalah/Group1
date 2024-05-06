package homeworks.dmytro_k.hw_2024.sql.hw_28_01_24;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectionTest {
    private static final String URL = "jdbc:mysql://localhost:3306/bank_clients";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "af66s60dk29l97j;";

    //private static final String URL = "jdbc:mysql://localhost:3306/bank_clients; INIT=RUNSCRIPT FROM 'classpath:init.sql'"; // for test
    public static void main(String[] args) {
        try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
             Statement statement = connection.createStatement()) {
            statement.addBatch("INSERT INTO clients(name) VALUES('Oleksandr')");
            statement.executeBatch();
            statement.clearBatch();
            statement.addBatch("INSERT INTO clients(name) VALUES('Mykola')");
            statement.executeBatch();
            statement.clearBatch();
        } catch (SQLException e) {
            System.out.println("Failed db connection");
            throw new RuntimeException(e);
        }
    }
    //test ok
}
