package homeworks.dmytro_k.hw_2024.sql.hw_16_06_24;

import java.sql.*;
import java.util.Objects;

import static homeworks.dmytro_k.hw_2024.sql.hw_16_06_24.ConstantsUtil.*;

public class ConnectionUtil {

    private static Connection connection;

    public static Connection getConnection() throws SQLException {
        if (Objects.isNull(connection)) {
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        }

        return connection;
    }

    public static void disconnect(Connection connection, Statement statement, ResultSet resultSet) {
        try {
            if (resultSet != null) resultSet.close();
            if (statement != null) statement.close();
            if (connection != null) connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
