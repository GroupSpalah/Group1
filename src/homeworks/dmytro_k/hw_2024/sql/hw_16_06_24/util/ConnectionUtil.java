package homeworks.dmytro_k.hw_2024.sql.hw_16_06_24.util;

import lombok.SneakyThrows;

import java.sql.*;
import java.util.Objects;

import static homeworks.dmytro_k.hw_2024.sql.hw_16_06_24.util.ConstantsUtil.*;

public class ConnectionUtil {

    private static Connection connection;

    @SneakyThrows
    public static Connection getConnection() {
        if (Objects.isNull(connection)) {
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        }
        return connection;
    }

    @SneakyThrows
    public static void disconnect() {
        if (connection != null && !connection.isClosed()) {
            connection.close();
        }
    }
}
