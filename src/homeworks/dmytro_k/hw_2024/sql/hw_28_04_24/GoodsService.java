package homeworks.dmytro_k.hw_2024.sql.hw_28_04_24;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

/**
 * 1) Cоздать таблицы:
 * <p>
 * ++Item(название, дата производства, производитель, хрупкость, цена),
 * ++Producer товара(название фирмы(Enum), страна производства(отдельна¤ таблица)).
 * ++Country(название)
 * <p>
 * Выбрать товары:
 * ++1) Одного производителя(любое название), хрупкие(boolean)
 * 2) Товары, произведенные в разных странах Канада и Украина и одинаковые производители
 * 3) Хрупкие из разных стран.
 * 4) Выбрать товары, страны которых начинаютс¤ с определенной(ых) букв.
 * 5) Вывести товары, отсортированные по стране(сортировать по убыванию и возрастанию)
 * и вывести только 5 первых.
 * 6) Вывести товары с максимальной, минимальной, средней ценой
 * В задаче использовать Primary and Foreign keys, создать свою базу данных,
 * использовать корректные типы данных.
 * <p>
 * Название товара должно быть уникальным(не допускать в таблице одинаковых товаров)
 * <p>
 * <p>
 * 2)
 * 1) Добавить новые строки с одинаковыми именами,
 * но разными датами или с одинаковой датой производства, но с разными имнами
 * 2) Изменить таблицу(для существующих данных) Item с помощью команды UPDATE и
 * поменять price, name у некоторых items на одинаковые
 * и сгруппировать и посчитать:
 * - по цене
 * - по хрупкости
 * - по имени
 * - по дате производства
 * - по дате производства, но применить условие к дате
 * - по цене, но применить условие к цене
 * 3) Изменить тип данных у колонки name с VARCHAR(20) на VARCHAR(100)
 * 4) Посчитать товары, у которых производители находятся в странах начинающихся на0у С
 */

public class GoodsService {

    private static final String URL = "jdbc:mysql://localhost:3306/goods";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "af66s60dk29l97j;";
    private static String sqlExpression;

    private static Connection connect() throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            throw new SQLException("Connection error");
        }
        return DriverManager.getConnection(URL, USERNAME, PASSWORD);
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
        sqlExpression = "SELECT item.name, item.production_date, " +
                "producer.product_producer, item.fragility, item.price " +
                "FROM Item " +
                "INNER JOIN producer ON item.manufacturer_id = producer.manufacturer_id";
        printResultSetAllFields(sqlExpression, "");
    }

    private static boolean isValidColumnName(String tableName, String columnName) {

        sqlExpression = "SHOW COLUMNS FROM " + tableName;
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

    public static void printDistinctColumnContent(String tableName, String columnName) {

        if (isValidColumnName(tableName, columnName)) {
/*            sqlExpression = "SELECT item.name, item.production_date, " +
                    "producer.product_producer, item.fragility, item.price " +
                    "FROM Item " +
                    "INNER JOIN producer ON item.manufacturer_id = producer.manufacturer_id";*/
            sqlExpression = "SELECT DISTINCT " + columnName + " FROM " + tableName;
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

    public static void filterByValue(String tableName, String columnName, String value) {

        if (isValidColumnName(tableName, columnName)) {
            sqlExpression = "SELECT item.name, item.production_date, " +
                    "producer.product_producer, item.fragility, item.price " +
                    "FROM item " +
                    "INNER JOIN producer ON item.manufacturer_id = producer.manufacturer_id " +
                    "WHERE " + columnName + " = ?";
        } else {
            System.out.println("no such column exists");
        }
        printResultSetAllFields(sqlExpression, value);
    }

}
