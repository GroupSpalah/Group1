package homeworks.vladyslav_lazin.hw_2024.hw_02_06_24;

import homeworks.vladyslav_lazin.hw_2024.hw_02_06_24.dao.impl.LaptopDaoImpl;

public class App {
    public static void main(String[] args) {
        LaptopDaoImpl laptopDAO = new LaptopDaoImpl();
        //  laptopDAO.addLaptop(
        //  new Laptop("ThinkPad", "Lenovo", LocalDate.of(2021, 8, 21), 32, 512, "Inetl Core I7"));
        // // System.out.println(laptopDAO.findLaptopById(2));

        // laptopDAO.findAllLaptops().forEach(System.out::println);

        // laptopDAO.deletLaptopbyId(3);

        // laptopDAO.deleteAllLaptops();
        // laptopDAO.updateLaptopById(4, new Laptop("ThinkPad", "Lenovo", LocalDate.of(2021, 8, 21), 32, 512, "Inetl Core I7"));
        // laptopDAO.findLaptopByModel("ThinkPad").forEach(System.out::println);
        // laptopDAO.findLaptopByProdDate("2021-08-21").forEach(System.out::println);
        // laptopDAO.findLaptopByRamAnadSsd(32, 512).forEach(System.out::println);
        laptopDAO.findLaptopByCpu("Inetl Core I7").forEach(System.out::println);

    }
}
