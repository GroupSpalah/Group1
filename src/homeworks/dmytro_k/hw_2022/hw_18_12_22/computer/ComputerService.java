package homeworks.dmytro_k.hw_2022.hw_18_12_22.computer;


public class ComputerService {

    public static void main(String[] args) {

        Computer computer1 = new Computer(2200,4,4096,500);

        Laptop laptop1 = new Laptop(2200,2,2048,320,120);

        System.out.println(computer1.information());

        System.out.println(laptop1.information());
    }
}
