package homeworks.sergii_khvostov.hw_2024.hw_11_02_24.notebooks;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class NotebookDatabase {
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/notebooks";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "12345";

    static Connection connect() throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            throw new SQLException("MySQL JDBC driver not found");
        }
        return DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);
    }


    public static void disconnect(Connection connection) {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void displayAllNotebooks() {
        try (Connection connection = connect();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT * FROM Notebooks")) {

            while (resultSet.next()) {
                System.out.println("ID: " + resultSet.getInt("id") +
                        ", Manufacturer: " + resultSet.getString("manufacturer") +
                        ", Name: " + resultSet.getString("notebook_name") +
                        ", Pages: " + resultSet.getInt("page_count") +
                        ", Cover Type: " + resultSet.getString("cover_type") +
                        ", Country: " + resultSet.getString("country") +
                        ", Page Appearance: " + resultSet.getString("page_appearance"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void displayAllCountries() {
        try (Connection connection = connect();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT DISTINCT country FROM Notebooks")) {

            while (resultSet.next()) {
                System.out.println(resultSet.getString("country"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void displayCountryNotebookCount() {
        try (Connection connection = connect();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(
                     "SELECT country, COUNT(*) AS notebookCount FROM Notebooks GROUP BY country")) {

            while (resultSet.next()) {
                System.out.println("Country: " + resultSet.getString("country") +
                        ", Notebook Count: " + resultSet.getInt("notebookCount"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static String getCountryWithMostNotebooks() {
        try (Connection connection = connect();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(
                     "SELECT country, COUNT(*) AS notebookCount FROM Notebooks GROUP BY country ORDER BY notebookCount DESC LIMIT 1")) {

            if (resultSet.next()) {
                return resultSet.getString("country");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String getCountryWithLeastNotebooks() {
        try (Connection connection = connect();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(
                     "SELECT country, COUNT(*) AS notebookCount FROM Notebooks GROUP BY country ORDER BY notebookCount ASC LIMIT 1")) {

            if (resultSet.next()) {
                return resultSet.getString("country");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String getManufacturerWithMostNotebooks() {
        try (Connection connection = connect();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(
                     "SELECT manufacturer, COUNT(*) AS notebookCount FROM Notebooks GROUP BY manufacturer ORDER BY notebookCount DESC LIMIT 1")) {

            if (resultSet.next()) {
                return resultSet.getString("manufacturer");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String getManufacturerWithLeastNotebooks() {
        try (Connection connection = connect();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(
                     "SELECT manufacturer, COUNT(*) AS notebookCount FROM Notebooks GROUP BY manufacturer ORDER BY notebookCount ASC LIMIT 1")) {

            if (resultSet.next()) {
                return resultSet.getString("manufacturer");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static List<Notebook> getNotebooksWithHardCover() {
        List<Notebook> notebooks = new ArrayList<>();
        try (Connection connection = connect();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT * FROM Notebooks WHERE cover_type = 'hard'")) {

            while (resultSet.next()) {
                Notebook notebook = new Notebook(
                        resultSet.getString("manufacturer"),
                        resultSet.getString("notebook_name"),
                        resultSet.getInt("page_count"),
                        resultSet.getString("cover_type"),
                        resultSet.getString("country"),
                        resultSet.getString("page_appearance")
                );
                notebooks.add(notebook);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return notebooks;
    }

    public static List<Notebook> getNotebooksWithSoftCover() {
        List<Notebook> notebooks = new ArrayList<>();
        try (Connection connection = connect();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT * FROM Notebooks WHERE cover_type = 'soft'")) {

            while (resultSet.next()) {
                Notebook notebook = new Notebook(
                        resultSet.getString("manufacturer"),
                        resultSet.getString("notebook_name"),
                        resultSet.getInt("page_count"),
                        resultSet.getString("cover_type"),
                        resultSet.getString("country"),
                        resultSet.getString("page_appearance")
                );
                notebooks.add(notebook);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return notebooks;
    }

    public static List<Notebook> getNotebooksFromCountry(String country) {
        List<Notebook> notebooks = new ArrayList<>();
        try (Connection connection = connect();
             PreparedStatement preparedStatement = connection.prepareStatement(
                     "SELECT * FROM Notebooks WHERE country = ?")) {

            preparedStatement.setString(1, country);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Notebook notebook = new Notebook(
                        resultSet.getString("manufacturer"),
                        resultSet.getString("notebook_name"),
                        resultSet.getInt("page_count"),
                        resultSet.getString("cover_type"),
                        resultSet.getString("country"),
                        resultSet.getString("page_appearance")
                );
                notebooks.add(notebook);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return notebooks;
    }

    public static List<Notebook> getNotebooksByPageAppearance(String pageAppearance) {
        List<Notebook> notebooks = new ArrayList<>();
        try (Connection connection = connect();
             PreparedStatement preparedStatement = connection.prepareStatement(
                     "SELECT * FROM Notebooks WHERE page_appearance = ?")) {

            preparedStatement.setString(1, pageAppearance);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Notebook notebook = new Notebook(
                        resultSet.getString("manufacturer"),
                        resultSet.getString("notebook_name"),
                        resultSet.getInt("page_count"),
                        resultSet.getString("cover_type"),
                        resultSet.getString("country"),
                        resultSet.getString("page_appearance")
                );
                notebooks.add(notebook);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return notebooks;
    }

    public static void addNotebook(Notebook notebook) {
        try (Connection connection = connect();
             PreparedStatement preparedStatement = connection.prepareStatement(
                     "INSERT INTO Notebooks (manufacturer, notebook_name, page_count, cover_type, country, page_appearance) VALUES (?, ?, ?, ?, ?, ?)")) {

            preparedStatement.setString(1, notebook.getManufacturer());
            preparedStatement.setString(2, notebook.getNotebookName());
            preparedStatement.setInt(3, notebook.getPageCount());
            preparedStatement.setString(4, notebook.getCoverType());
            preparedStatement.setString(5, notebook.getCountry());
            preparedStatement.setString(6, notebook.getPageAppearance());

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void deleteNotebook(int id) {
        try (Connection connection = connect();
             PreparedStatement preparedStatement = connection.prepareStatement(
                     "DELETE FROM Notebooks WHERE id = ?")) {

            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void updateNotebook(Notebook notebook) {
        try (Connection connection = connect();
             PreparedStatement preparedStatement = connection.prepareStatement(
                     "UPDATE Notebooks SET manufacturer = ?, notebook_name = ?, page_count = ?, cover_type = ?, country = ?, page_appearance = ? WHERE id = ?")) {

            preparedStatement.setString(1, notebook.getManufacturer());
            preparedStatement.setString(2, notebook.getNotebookName());
            preparedStatement.setInt(3, notebook.getPageCount());
            preparedStatement.setString(4, notebook.getCoverType());
            preparedStatement.setString(5, notebook.getCountry());
            preparedStatement.setString(6, notebook.getPageAppearance());
            preparedStatement.setInt(7, notebook.getId());

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void displayManufacturerNotebookCount() {
        try (Connection connection = connect();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(
                     "SELECT manufacturer, COUNT(*) AS notebookCount FROM Notebooks GROUP BY manufacturer")) {

            while (resultSet.next()) {
                System.out.println("Manufacturer: " + resultSet.getString("manufacturer") +
                        ", Notebook Count: " + resultSet.getInt("notebookCount"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static List<Notebook> getNotebooksByPageCount(int pageCount) {
        List<Notebook> notebooks = new ArrayList<>();
        try (Connection connection = connect();
             PreparedStatement preparedStatement = connection.prepareStatement(
                     "SELECT * FROM Notebooks WHERE page_count = ?")) {

            preparedStatement.setInt(1, pageCount);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Notebook notebook = new Notebook(
                        resultSet.getString("manufacturer"),
                        resultSet.getString("notebook_name"),
                        resultSet.getInt("page_count"),
                        resultSet.getString("cover_type"),
                        resultSet.getString("country"),
                        resultSet.getString("page_appearance")
                );
                notebooks.add(notebook);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return notebooks;
    }
}

