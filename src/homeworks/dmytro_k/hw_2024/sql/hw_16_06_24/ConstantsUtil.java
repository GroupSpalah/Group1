package homeworks.dmytro_k.hw_2024.sql.hw_16_06_24;

public class ConstantsUtil {
    static final String URL = "jdbc:mysql://localhost:3306/drivers";
    static final String USERNAME = "root";
    static final String PASSWORD = "af66s60dk29l97j;";

    static final String INSERT_DRIVER =
            "INSERT INTO drivers (firstName, lastName, age, qualification) " +
                    "VALUES (?, ?, ?, ?)";
    static final String UPDATE_DRIVER =
            "UPDATE drivers " +
                    "SET firstName=?, lastName=?, age=?, qualification=? " +
                    "WHERE driver_id=?";
    static final String DELETE_DRIVER =
            "DELETE FROM drivers " +
                    "WHERE driver_id=?";
    static final String SELECT_ALL_DRIVERS =
            "SELECT * " +
                    "FROM drivers";
    static final String SELECT_DRIVER_BY_ID =
            "SELECT * " +
                    "FROM drivers " +
                    "WHERE driver_id=?";
    static final String SELECT_TRUCKS_FOR_DRIVER =
            "SELECT * " +
                    "FROM trucks " +
                    "WHERE FK_driver_id=?";
    static final String INSERT_TRUCK =
            "INSERT INTO trucks (model, model_year, FK_driver_id) " +
                    "VALUES (?, ?, ?)";
    static final String UPDATE_TRUCK =
            "UPDATE trucks " +
                    "SET model=?, model_year=?, FK_driver_id=? " +
                    "WHERE truck_id=?";
    static final String DELETE_TRUCK =
            "DELETE FROM trucks " +
                    "WHERE truck_id=?";
    static final String SELECT_ALL_TRUCKS =
            "SELECT * " +
                    "FROM trucks";
    static final String SELECT_TRUCK_BY_ID =
            "SELECT * " +
                    "FROM trucks " +
                    "WHERE truck_id=?";
}
