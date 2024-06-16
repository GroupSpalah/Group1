package homeworks.sergii_khvostov.hw_2024.hw_02_06_24;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class LaptopDAOImpl implements LaptopDAO {

    private final Connection connection;

    public LaptopDAOImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void addLaptop(Laptop laptop) {
        String query = "INSERT INTO laptops (model, manufacturer, release_date, ram, ssd_capacity, processor) " +
                "VALUES (?, ?, ?, ?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, laptop.getModel());
            statement.setString(2, laptop.getManufacturer());
            statement.setDate(3, Date.valueOf(laptop.getReleaseDate()));
            statement.setInt(4, laptop.getRamSize());
            statement.setInt(5, laptop.getSsdCapacity());
            statement.setString(6, laptop.getProcessor());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Laptop getLaptopById(int id) {
        String query = "SELECT * FROM laptops WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return extractLaptopFromResultSet(resultSet);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Laptop> getAllLaptops() {
        List<Laptop> laptops = new ArrayList<>();
        String query = "SELECT * FROM laptops";
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {
            while (resultSet.next()) {
                laptops.add(extractLaptopFromResultSet(resultSet));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return laptops;
    }

    @Override
    public void deleteLaptopById(int id) {
        String query = "DELETE FROM laptops WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteAllLaptops() {
        String query = "DELETE FROM laptops";
        try (Statement statement = connection.createStatement()) {
            statement.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateLaptop(int id, Laptop newLaptop) {
        String query = "UPDATE laptops SET model = ?, manufacturer = ?, release_date = ?, ram = ?, " +
                "ssd_capacity = ?, processor = ? WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, newLaptop.getModel());
            statement.setString(2, newLaptop.getManufacturer());
            statement.setDate(3, java.sql.Date.valueOf(newLaptop.getReleaseDate()));
            statement.setInt(4, newLaptop.getRamSize());
            statement.setInt(5, newLaptop.getSsdCapacity());
            statement.setString(6, newLaptop.getProcessor());
            statement.setInt(7, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    @Override
    public List<Laptop> getLaptopsByModel(String model) {
        List<Laptop> laptops = new ArrayList<>();
        String query = "SELECT * FROM laptops WHERE model = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, model);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                laptops.add(extractLaptopFromResultSet(resultSet));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return laptops;
    }

    @Override
    public List<Laptop> getLaptopsByReleaseDate(LocalDate releaseDate) {
        List<Laptop> laptops = new ArrayList<>();
        String query = "SELECT * FROM laptops WHERE release_date = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setDate(1, java.sql.Date.valueOf(releaseDate));
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                laptops.add(extractLaptopFromResultSet(resultSet));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return laptops;
    }


    @Override
    public List<Laptop> getLaptopsByRAMAndSSD(int ram, int ssdCapacity) {
        List<Laptop> laptops = new ArrayList<>();
        String query = "SELECT * FROM laptops WHERE ram = ? AND ssd_capacity = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, ram);
            statement.setInt(2, ssdCapacity);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                laptops.add(extractLaptopFromResultSet(resultSet));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return laptops;
    }

    @Override
    public List<Laptop> getLaptopsByProcessor(String processor) {
        List<Laptop> laptops = new ArrayList<>();
        String query = "SELECT * FROM laptops WHERE processor = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, processor);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                laptops.add(extractLaptopFromResultSet(resultSet));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return laptops;
    }

    private Laptop extractLaptopFromResultSet(ResultSet rs) throws SQLException {
        Laptop laptop = new Laptop(
                rs.getInt("id"),
                rs.getString("model"),
                rs.getString("manufacturer"),
                rs.getDate("release_date").toLocalDate(),
                rs.getInt("ram"),
                rs.getInt("ssd_capacity"),
                rs.getString("processor")
        );
        return laptop;
    }

}

