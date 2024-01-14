package homeworks.vladyslav_lazin.hw_2024.hw_07_01_24.bridge;

public class StockExchange extends Program{
    protected StockExchange(Developer developer) {
        super(developer);
    }

    @Override
    public void developProgram() {
        System.out.println("Stock Exchange development in progress...");
        developer.writeCode();
    }
}
