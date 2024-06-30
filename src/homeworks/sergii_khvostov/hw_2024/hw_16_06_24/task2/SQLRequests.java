package homeworks.sergii_khvostov.hw_2024.hw_16_06_24.task2;

public class SQLRequests {
    static String addDriver = "INSERT INTO Driver (id, firstName, lastName, age, qualification) VALUES (?, ?, ?, ?, ?)";
    static String getDriverById = "SELECT * FROM Driver WHERE id = ?";
    static String getAllDrivers = "SELECT * FROM Driver";
    static String deleteDriverById = "DELETE FROM Driver WHERE id = ?";
    static String deleteAllDrivers = "DELETE FROM Driver";
    static String updateDriver = "UPDATE Driver SET firstName = ?, lastName = ?, age = ?, qualification = ? WHERE id = ?";
    static String addTruck = "INSERT INTO Truck (id, model, modelYear, driver_id) VALUES (?, ?, ?, ?)";
    static String getTruckById = "SELECT * FROM Truck WHERE id = ?";
    static String getAllTrucks = "SELECT * FROM Truck";
    static String deleteTruckById = "DELETE FROM Truck WHERE id = ?";
    static String deleteAllTrucks = "DELETE * FROM Truck";
    static String updateTruck = "UPDATE Truck SET model = ?, modelYear = ?, driver_id = ? WHERE id = ?";
    static String getTrucksByDriverId = "SELECT * FROM Truck WHERE driver_id = ?";


}
