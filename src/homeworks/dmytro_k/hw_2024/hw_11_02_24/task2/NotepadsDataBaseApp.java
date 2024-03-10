package homeworks.dmytro_k.hw_2024.hw_11_02_24.task2;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class NotepadsDataBaseApp {
    private static final String URL = "jdbc:mysql://localhost:3306/notepads";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "af66s60dk29l97j;";

    /*Присоединение к базе данных;*/
    private static Connection connect() throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            throw new SQLException("Connection error");
        }
        return DriverManager.getConnection(URL, USERNAME, PASSWORD);
    }

    /*Отсоединение от базы данных*/
    public static void disconnect(Connection connection) {//где нужно закрывать коннект?
        // (не нужно закрывать, конструкция try-with-resources в Java автоматически закрывает ресурсы, 
        // которые были открыты в начале блока try. Это работает для любых объектов, 
        // которые реализуют интерфейс AutoCloseable, включая Connection, PreparedStatement и ResultSet в JDBC)
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private static void printResultSetAllFields(String sql, String value) {
        try (Connection connection = connect();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            if (!value.isBlank()) {
                preparedStatement.setString(1, value);
            }

            ResultSet resultSet = preparedStatement.executeQuery();
            ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
            int columnCount = resultSetMetaData.getColumnCount();

            while (resultSet.next()) {
                for (int i = 1; i <= columnCount; i++) {
                    System.out.print(" |" + resultSet.getString(i) + "|");
                }
                System.out.println();
                System.out.println("-----------------------------------");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void printTable() {
        String sql = "SELECT * FROM notebooks";
        printResultSetAllFields(sql, "");
    }

    private static boolean isValidColumnName(String columnName) {
        String sql = "SHOW COLUMNS FROM notebooks";
        List<String> columnNames = new ArrayList<>();

        try (Connection connection = connect();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {

            while (resultSet.next()) {
                String field = resultSet.getString("Field");
                columnNames.add(field);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return columnNames.contains(columnName);
    }

    public static void printDistinctColumnContent(String columnName) {
        String sql = "";

        if (isValidColumnName(columnName)) {
            sql = "SELECT DISTINCT " + columnName + " FROM notebooks";
        } else {
            System.out.println("no such column exists");
        }

        try (Connection connection = connect();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {

            while (resultSet.next()) {
                System.out.println(resultSet.getString(columnName));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private static void printValueAndQuantityResultSet(String columnName, String sql) {
        try (Connection connection = connect();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {

            while (resultSet.next()) {
                System.out.println(resultSet.getString(columnName) + " - "
                        + resultSet.getInt("number_of_coincidences"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void printNumberOfCoincidences(String columnName) {
        String sql = "";

        if (isValidColumnName(columnName)) {
            sql = "SELECT " + columnName + ", COUNT(" + columnName + ") AS number_of_coincidences " +
                    "FROM notebooks " +
                    "GROUP BY " + columnName;
        } else {
            System.out.println("no such column exists");
        }
        printValueAndQuantityResultSet(columnName, sql);
    }

    public static void printMostCommonMeaning(String columnName) {
        String sql = "";

        if (isValidColumnName(columnName)) {
            //нужен запрос не для 1 варианта, а для нескольких одинаковых максимальных/минимальных значений
            sql = "SELECT " + columnName + ", COUNT(" + columnName + ") AS number_of_coincidences " +
                    "FROM notebooks " +
                    "GROUP BY " + columnName +
                    " HAVING COUNT(" + columnName + ") = (SELECT MAX(number_of_coincidences) " +
                    "FROM (SELECT COUNT(" + columnName + ") AS number_of_coincidences " +
                    "FROM notebooks GROUP BY " + columnName + ") AS tempList) " +
                    "ORDER BY number_of_coincidences DESC;";
        } else {
            System.out.println("no such column exists");
        }
        printValueAndQuantityResultSet(columnName, sql);
    }

    public static void printLeastCommonMeaning(String columnName) {
        String sql = "";

        if (isValidColumnName(columnName)) {
            sql = "SELECT " + columnName + ", COUNT(" + columnName + ") AS number_of_coincidences " +
                    "FROM notebooks " +
                    "GROUP BY " + columnName +
                    " HAVING COUNT(" + columnName + ") = (SELECT MIN(number_of_coincidences) " +
                    "FROM (SELECT COUNT(" + columnName + ") AS number_of_coincidences " +
                    "FROM notebooks GROUP BY " + columnName + ") AS tempList) " +
                    "ORDER BY number_of_coincidences ASC;";
        } else {
            System.out.println("no such column exists");
        }
        printValueAndQuantityResultSet(columnName, sql);
    }

    public static void filterByValue(String columnName, String value) {
        String sql = "";

        if (isValidColumnName(columnName)) {
            sql = "SELECT * " +
                    "FROM notebooks " +
                    "WHERE " + columnName + " = ?";
        } else {
            System.out.println("no such column exists");
        }
        printResultSetAllFields(sql, value);
    }

    public static void addNotebook(String manufacturerName, String notebookName,
                                   int numberOfPages, String coverType,
                                   String countryOfOrigin, String appearanceOfTheNotebookPage) {
        String sql = "INSERT INTO notebooks(manufacturer_name, notebook_name, " +
                "number_of_pages, cover_type, country_of_origin, appearance_of_the_notebook_page) " +
                "VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection connection = connect();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, manufacturerName);
            preparedStatement.setString(2, notebookName);
            preparedStatement.setInt(3, numberOfPages);
            preparedStatement.setString(4, coverType);
            preparedStatement.setString(5, countryOfOrigin);
            preparedStatement.setString(6, appearanceOfTheNotebookPage);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void deleteNotebook(int id) {
        String sql = "DELETE FROM notebooks " +
                "WHERE id = ?";

        try {
            Connection connection = connect();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void updateNotebook(String manufacturerName, String notebookName,
                                      int numberOfPages, String coverType,
                                      String countryOfOrigin, String appearanceOfTheNotebookPage, int id) {
        String sql = "UPDATE notebooks " +
                "SET manufacturer_name = ?, notebook_name = ?, number_of_pages = ?, cover_type = ?, " +
                "country_of_origin = ?, appearance_of_the_notebook_page = ? " +
                "WHERE id = ?;";

        try (Connection connection = connect();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, manufacturerName);
            preparedStatement.setString(2, notebookName);
            preparedStatement.setInt(3, numberOfPages);
            preparedStatement.setString(4, coverType);
            preparedStatement.setString(5, countryOfOrigin);
            preparedStatement.setString(6, appearanceOfTheNotebookPage);
            preparedStatement.setInt(7, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
