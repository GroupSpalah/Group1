package homeworks.sergii_khvostov.hw_2022.hw_18_12_22.computer;

public class ComputerTest {
    public static void main(String[] args) {
        Computer computer =
                new Computer(3200, 4, 16000,
                        1000);
        System.out.println(computer.info());

        System.out.println();

        Notebook notebook =
                new Notebook(3200, 4, 16000,
                        1000, 59);
        System.out.println(notebook.info());
    }
}
