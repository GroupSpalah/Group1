package homeworks.vladyslav_lazin.hw_2024.hw_07_01_24.decorator;

public class PhraseDecorator implements Printable {
    private Printable printable;

    public PhraseDecorator(Printable printable) {
        this.printable = printable;
    }

    @Override
    public void print() {
        printable.print();
    }
}
