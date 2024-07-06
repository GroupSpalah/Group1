package homeworks.sergii_khvostov.hw_2024.hw_16_06_24.task2.db_connection;

public class SQLRequests {
    public static String addDriver = "INSERT INTO drivers (id, firstName, lastName, age, qualification) VALUES (?, ?, ?, ?, ?)";
    public static String getDriverById = "SELECT * FROM drivers WHERE id = ?";
    public static String getAllDrivers = "SELECT * FROM drivers";
    public static String deleteDriverById = "DELETE FROM drivers WHERE id = ?";
    public static String deleteAllDrivers = "DELETE FROM drivers";
    public static String updateDriver = "UPDATE drivers SET firstName = ?, lastName = ?, age = ?, qualification = ? WHERE id = ?";

    public static String addTruck = "INSERT INTO trucks (id, model, modelYear, driverId) VALUES (?, ?, ?, ?)";
    public static String getTruckById = "SELECT * FROM trucks WHERE id = ?";
    public static String getAllTrucks = "SELECT * FROM trucks";
    public static String deleteTruckById = "DELETE FROM trucks WHERE id = ?";
    public static String deleteAllTrucks = "DELETE FROM trucks";
    public static String updateTruck = "UPDATE trucks SET model = ?, modelYear = ? WHERE id = ? AND driverId = ?";
    public static String getTrucksByDriverId = "SELECT * FROM trucks WHERE driverId = ?";
}
