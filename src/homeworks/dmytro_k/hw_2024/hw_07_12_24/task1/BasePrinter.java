package homeworks.dmytro_k.hw_2024.hw_07_12_24.task1;

public class BasePrinter implements Printable {
    private final String text;

    public BasePrinter(String text) {
        this.text = text;
    }


    @Override
    public void print() {
        System.out.print(text);
    }
}
