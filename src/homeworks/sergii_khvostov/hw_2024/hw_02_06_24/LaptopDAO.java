package homeworks.sergii_khvostov.hw_2024.hw_02_06_24;

import java.time.LocalDate;
import java.util.List;

public interface LaptopDAO {

    void addLaptop(Laptop laptop);

    Laptop getLaptopById(int id);

    List<Laptop> getAllLaptops();

    void deleteLaptopById(int id);

    void deleteAllLaptops();

    void updateLaptop(int id, Laptop newLaptop);

    List<Laptop> getLaptopsByModel(String model);

    List<Laptop> getLaptopsByReleaseDate(LocalDate releaseDate);

    List<Laptop> getLaptopsByRAMAndSSD(int ramSize, int ssdCapacity);

    List<Laptop> getLaptopsByProcessor(String processor);
}

