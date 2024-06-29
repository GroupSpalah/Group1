package homeworks.dmytro_k.hw_2024.sql.hw_16_06_24;

import java.sql.*;

import static homeworks.dmytro_k.hw_2024.sql.hw_16_06_24.ConstantsUtil.*;

public class ConnectionUtil {
    static Connection getConnection() throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            throw new SQLException("Connection error");
        }
        return DriverManager.getConnection(URL, USERNAME, PASSWORD);
    }

    static void disconnect(Connection connection, Statement statement, ResultSet resultSet) {
        try {
            if (resultSet != null) resultSet.close();
            if (statement != null) statement.close();
            if (connection != null) connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
