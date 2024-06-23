package homeworks.dmytro_k.hw_2024.sql.hw_02_06_24;

/**
 * ---
 * Завдання 6
 * <p>
 * ++ 1. Напишіть клас, що описує ноутбук на фірмі. Поля класу:
 * a) модель;
 * б) виробник;
 * в) дата випуску;
 * г) об’єм оперативної пам’яті;
 * д) місткість SSD;
 * е) процесор;
 * є) id.
 * <p>
 * ++ Типи полів задайте самостійно.
 * <p>
 * 2. Розробіть інтерфейс, котрий міститиме необхідні операції над даними. Перелік операцій:
 * ++ a) додавання;
 * ++ б) перегляд за id;
 * ++ в) перегляд повного переліку;
 * ++ г) видалення за id;
 * ++ д) видалення повного переліку;
 * ++ е) модифікація за id;
 * ++ є) перегляд за моделлю;
 * ++ ж) перегляд за датою випуску;
 * ++ з) перегляд за об’ємом оперативної пам’яті та місткістю SSD;
 * ++ и) перегляд за процесором.
 * <p>
 * 3. Розробіть репозиторій на основі інтерфейсу (п. 2). Реалізуйте його методи.
 * 4. Побудуйте сервіс, що використовує отриманий у п. 3 репозиторій.
 * 5. Розробіть контролер для обробки запитів користувача.
 * 6. Продемонструйте розроблений проект у дії. Скористайтеся для надсилання запитів до сервера
 * API-клієнтом (Postman, Insomnia тощо). Формат тіла HTTP-запитів та відповідей сервера — JSON.
 * <p>
 * ---
 */

import lombok.Cleanup;
import lombok.SneakyThrows;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static homeworks.dmytro_k.hw_2024.sql.hw_02_06_24.ConstantsUtil.*;

public class LaptopsDataBaseApp {
    private static Connection getConnection() throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            throw new SQLException("Connection error");
        }
        return DriverManager.getConnection(URL, USERNAME, PASSWORD);
    }

    @SneakyThrows(SQLException.class)
    public static void deleteLaptop(int laptopId) {
        String sqlExpression = "DELETE " +
                "FROM laptops " +
                "WHERE laptop_id = ?";

        @Cleanup
        Connection connection = getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(sqlExpression);
        preparedStatement.setInt(1, laptopId);
        preparedStatement.executeUpdate();
    }

    @SneakyThrows(SQLException.class)
    public static void deleteAllLaptops() {
        String sqlExpression = "TRUNCATE TABLE laptops";
        @Cleanup
        Connection connection = getConnection();
        Statement statement = connection.createStatement();
        statement.executeUpdate(sqlExpression);
    }

    @SneakyThrows(SQLException.class)
    private static void myPreparedStatement(String sqlExpression, Laptop laptop, int laptopId) {
        @Cleanup
        Connection connection = getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(sqlExpression);
        preparedStatement.setString(1, laptop.getModel());
        preparedStatement.setString(2, laptop.getManufacturer());
        preparedStatement.setDate(3, Date.valueOf(laptop.getReleaseDate()));
        preparedStatement.setInt(4, laptop.getSSDCapacity());
        preparedStatement.setInt(5, laptop.getRAMCapacity());
        preparedStatement.setString(6, laptop.getProcessor());
        if (laptopId != 0) {
            preparedStatement.setInt(7, laptopId);
        }
        preparedStatement.executeUpdate();
    }

    public static void addLaptopToDb(Laptop laptop) {

        String sqlExpression = "INSERT INTO laptops(model, manufacturer, release_date, " +
                "RAM_capacity, SSD_capacity, processor)" +
                "VALUES (?, ?, ?, ?, ?, ?)";

        myPreparedStatement(sqlExpression, laptop, 0);
    }

    public static void updateLaptop(Laptop laptop, int laptopId) {

        String sqlExpression = "UPDATE laptops " +
                "SET model = ?, manufacturer = ?, release_date = ?, " +
                "RAM_capacity = ?, SSD_capacity = ?, processor = ? " +
                "WHERE laptop_id = ?;";

        myPreparedStatement(sqlExpression, laptop, laptopId);
    }

    @SneakyThrows(SQLException.class)
    private static void addLaptopsToList(String sqlExpression, List<String> filterValues) {

        List<Laptop> laptops = new ArrayList<>();

        @Cleanup
        Connection connection = getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(sqlExpression);

        int paramIndex = 1;

        for (String filterValue : filterValues) {
            preparedStatement.setString(paramIndex++, filterValue);
        }

/*            IntStream.range(1,filterValues.size()).forEach(i -> {
                try {
                    preparedStatement.setString(paramIndex.getAndIncrement(), filterValues.get(i));
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            });*/

        ResultSet resultSet = preparedStatement.executeQuery();

        while (resultSet.next()) {
            int laptopId = resultSet.getInt("laptop_id");
            String model = resultSet.getString("model");
            String manufacturer = resultSet.getString("manufacturer");
            LocalDate releaseDate = resultSet.getDate("release_date").toLocalDate();
            int ramCapacity = resultSet.getInt("RAM_capacity");
            int ssdCapacity = resultSet.getInt("SSD_capacity");
            String processor = resultSet.getString("processor");

            Laptop laptop = new Laptop(model, manufacturer,
                    releaseDate, ramCapacity, ssdCapacity, processor);
            laptop.setId(laptopId);

            laptops.add(laptop);
        }
        laptops.forEach(System.out::println);
    }

    @SneakyThrows(SQLException.class)
    private static boolean isValidColumnName(String columnName) {

        String sqlExpression = "SHOW COLUMNS " +
                "FROM laptops";
        List<String> columnNames = new ArrayList<>();

        @Cleanup
        Connection connection = getConnection();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sqlExpression);

        while (resultSet.next()) {
            String field = resultSet.getString("Field");
            columnNames.add(field);
        }
        return columnNames.contains(columnName);
    }

    public static void filterByValue(String columnName, String value) {

        String sqlExpression = "";

        List<String> filterValues = new ArrayList<>();

        filterValues.add(value);

        if (isValidColumnName(columnName)) {
            sqlExpression = "SELECT * " +
                    "FROM laptops " +
                    "WHERE " + columnName + " = ?";
        } else {
            System.out.println("no such column exists");
        }

        addLaptopsToList(sqlExpression, filterValues);
    }

/*    public static void filterByValue(String... filters) {

        StringBuilder sbSqlExpression = new StringBuilder(
                "SELECT * " +
                "FROM laptops " +
                "WHERE 1=1");

        List<String> filterValues = new ArrayList<>();

        for (int i = 0; i < filters.length; i += 2) {
            String columnName = filters[i];
            String value = filters[i + 1];

            if (isValidColumnName(columnName) && value != null && !value.trim().isEmpty()) {
                sbSqlExpression
                        .append(" AND ")
                        .append(columnName)
                        .append(" LIKE ?");
                filterValues.add("%" + value.trim() + "%");
            }
        }

        sqlExpression =sbSqlExpression.toString();

        addLaptopsToList(sqlExpression, filterValues);
    }*/

    /**
     * Params:
     * K - column name,
     * V - the value by which you want to filter the result.
     * <p>
     * The number of filters is limited only by columns and database values.
     * Two parameters for one column are not allowed at the same time.
     */
    public static void filterByValue(Map<String, String> filters) {

        List<String> filterValues = new ArrayList<>();

        StringBuilder sbSqlExpression = new StringBuilder(
                "SELECT * " +
                        "FROM laptops " +
                        "WHERE 1=1"
        );

/*        for (Map.Entry<String, String> entry : filters.entrySet()) {
            String columnName = entry.getKey();
            String value = "%" + entry.getValue().trim() + "%";

            if (isValidColumnName(columnName)) {
                sbSqlExpression
                        .append(" AND ")
                        .append(columnName)
                        .append(" LIKE ?");
                filterValues.add(value);
            } else {
                System.out.println("No such column exists: " + columnName);
            }
        }*/


        filters.entrySet()
                .stream()
                .peek(entry -> {
                    String columnName = entry.getKey();
                    if (!isValidColumnName(columnName)) {
                        throw new IllegalArgumentException("No such column exists: " + columnName);
                    }
                })
                .forEach(entry -> {
                    String columnName = entry.getKey();
                    String value = "%" + entry.getValue().trim() + "%";
                    sbSqlExpression
                            .append(" AND ")
                            .append(columnName)
                            .append(" LIKE ?");
                    filterValues.add(value);
                });

        String sqlExpression = sbSqlExpression.toString();

        addLaptopsToList(sqlExpression, filterValues);
    }
}
