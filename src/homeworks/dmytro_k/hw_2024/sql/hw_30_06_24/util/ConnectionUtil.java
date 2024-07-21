package homeworks.dmytro_k.hw_2024.sql.hw_30_06_24.util;

import lombok.SneakyThrows;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Objects;

public class ConnectionUtil {

    private static Connection connection;

    @SneakyThrows
    public static Connection getConnection() throws SQLException {
        if (Objects.isNull(connection)) {
            connection = DriverManager
                    .getConnection(ConstantsUtil.URL, ConstantsUtil.USERNAME, ConstantsUtil.PASSWORD);
        }
        return connection;
    }

    @SneakyThrows
    public static void disconnect() throws SQLException {
        if (connection != null && !connection.isClosed()) {
            connection.close();
        }
    }
}
