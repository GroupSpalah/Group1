package homeworks.vladyslav_lazin.hw_2024.hw_07_01_24.bridge;

public class BankSystem extends Program{
    protected BankSystem(Developer developer) {
        super(developer);
    }

    @Override
    public void developProgram() {
        System.out.println("Bank system development in progress...");
        developer.writeCode();
    }
}
