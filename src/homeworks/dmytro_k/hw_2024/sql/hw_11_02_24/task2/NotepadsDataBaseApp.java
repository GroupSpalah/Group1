package homeworks.dmytro_k.hw_2024.sql.hw_11_02_24.task2;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class NotepadsDataBaseApp {
    private static final String URL = "jdbc:mysql://localhost:3306/notepads";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "af66s60dk29l97j;";
    private static String sqlExpression;

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
    public static void disconnect(Connection connection) {//Где нужно закрывать коннект?
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
                IntStream.range(1, columnCount).forEach(i -> {
                    try {
                        System.out.print(" |" + resultSet.getString(i) + "|");
                    } catch (SQLException e) {
                        throw new RuntimeException(e);
                    }
                });
                System.out.println();
                System.out.println("-----------------------------------");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void printTable() {
        sqlExpression = "SELECT * FROM notebooks";
        printResultSetAllFields(sqlExpression, "");
    }

    private static boolean isValidColumnName(String columnName) {

        sqlExpression = "SHOW COLUMNS FROM notebooks";
        List<String> columnNames = new ArrayList<>();

        try (Connection connection = connect();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sqlExpression)) {

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

        if (isValidColumnName(columnName)) {
            sqlExpression = "SELECT DISTINCT " + columnName + " FROM notebooks";
        } else {
            System.out.println("no such column exists");
        }

        try (Connection connection = connect();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sqlExpression)) {

            while (resultSet.next()) {
                System.out.println(resultSet.getString(columnName));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private static void printValueAndQuantityResultSet(String columnName, String sql) {//? rename?
        try (Connection connection = connect();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {

            while (resultSet.next()) {
                System.out.println(resultSet.getString(columnName) + " - " +
                        resultSet.getInt("number_of_coincidences"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void printNumberOfCoincidences(String columnName) {

        if (isValidColumnName(columnName)) {
            sqlExpression = "SELECT " + columnName + ", COUNT(" + columnName + ") " +
                    "AS number_of_coincidences " +
                    "FROM notebooks " +
                    "GROUP BY " + columnName;
        } else {
            System.out.println("no such column exists");
        }
        printValueAndQuantityResultSet(columnName, sqlExpression);
    }

    public static void printMostCommonMeaning(String columnName) {

        if (isValidColumnName(columnName)) {
            //нужен запрос не для 1 варианта, а для нескольких одинаковых максимальных/минимальных значений
            sqlExpression = "SELECT " + columnName + ", COUNT(" + columnName + ") " +
                    "AS number_of_coincidences " + "FROM notebooks " + "GROUP BY " + columnName +
                    " HAVING COUNT(" + columnName + ") = (SELECT MAX(number_of_coincidences) " +
                    "FROM (SELECT COUNT(" + columnName + ") AS number_of_coincidences " +
                    "FROM notebooks GROUP BY " + columnName + ") AS tempList) " +
                    "ORDER BY number_of_coincidences DESC;";
        } else {
            System.out.println("no such column exists");
        }
        printValueAndQuantityResultSet(columnName, sqlExpression);
    }

    public static void printLeastCommonMeaning(String columnName) {

        if (isValidColumnName(columnName)) {
            sqlExpression = "SELECT " + columnName + ", COUNT(" + columnName + ") " +
                    "AS number_of_coincidences " +
                    "FROM notebooks " + "GROUP BY " + columnName +
                    " HAVING COUNT(" + columnName + ") = (SELECT MIN(number_of_coincidences) " +
                    "FROM (SELECT COUNT(" + columnName + ") AS number_of_coincidences " +
                    "FROM notebooks GROUP BY " + columnName + ") AS tempList) " +
                    "ORDER BY number_of_coincidences ASC;";
        } else {
            System.out.println("no such column exists");
        }
        printValueAndQuantityResultSet(columnName, sqlExpression);
    }

    public static void filterByValue(String columnName, String value) {

        if (isValidColumnName(columnName)) {
            sqlExpression = "SELECT * " +
                    "FROM notebooks " +
                    "WHERE " + columnName + " = ?";
        } else {
            System.out.println("no such column exists");
        }
        printResultSetAllFields(sqlExpression, value);
    }

    public static void addNotebook(String manufacturerName, String notebookName,
                                   int numberOfPages, String coverType,
                                   String countryOfOrigin, String appearanceOfTheNotebookPage) {

        sqlExpression = "INSERT INTO notebooks(manufacturer_name, notebook_name, " +
                "number_of_pages, cover_type, country_of_origin, appearance_of_the_notebook_page) " +
                "VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection connection = connect();
             PreparedStatement preparedStatement = connection.prepareStatement(sqlExpression)) {
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
        sqlExpression = "DELETE FROM notebooks " + "WHERE id = ?";

        try {
            Connection connection = connect();
            PreparedStatement preparedStatement = connection.prepareStatement(sqlExpression);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void updateNotebook(String manufacturerName, String notebookName,
                                      int numberOfPages, String coverType,
                                      String countryOfOrigin, String appearanceOfTheNotebookPage, int id) {

        sqlExpression = "UPDATE notebooks " +
                "SET manufacturer_name = ?, notebook_name = ?, number_of_pages = ?, cover_type = ?, " +
                "country_of_origin = ?, appearance_of_the_notebook_page = ? " + "WHERE id = ?;";

        try (Connection connection = connect();
             PreparedStatement preparedStatement = connection.prepareStatement(sqlExpression)) {
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
