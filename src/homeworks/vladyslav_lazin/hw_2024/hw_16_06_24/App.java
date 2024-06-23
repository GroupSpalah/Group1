package homeworks.vladyslav_lazin.hw_2024.hw_16_06_24;

import homeworks.vladyslav_lazin.hw_2024.hw_16_06_24.model.Driver;
import homeworks.vladyslav_lazin.hw_2024.hw_16_06_24.model.Qualification;
import homeworks.vladyslav_lazin.hw_2024.hw_16_06_24.model.Truck;
import homeworks.vladyslav_lazin.hw_2024.hw_16_06_24.service.TruckService;
import homeworks.vladyslav_lazin.hw_2024.hw_16_06_24.service.impl.DriverServiceImpl;
import homeworks.vladyslav_lazin.hw_2024.hw_16_06_24.service.DriverService;
import homeworks.vladyslav_lazin.hw_2024.hw_16_06_24.service.impl.TruckServiceImpl;

public class App {
    public static void main(String[] args) {
        DriverService driverService = new DriverServiceImpl();
//        TruckService truckService = new TruckServiceImpl();
//        Driver driver = Driver.builder()
//                .firstName("Ken")
//                .lastName("Baker")
//                .age(21)
//                .qualification(Qualification.TRAINY)
//                .build();
//        Truck truck = Truck.builder()
//                .model("CITROEN")
//                .modelYear(2024)
//                .build();
//        driverService.save(driver);
//        truckService.save(truck);
//        driverService.setTruckToDriverById(2, 3);

        System.out.println(driverService.findById(1));
    }
}
