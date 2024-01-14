package homeworks.vladyslav_lazin.hw_2024.hw_07_01_24.decorator;

public class HashWrapper extends PhraseDecorator {
    public HashWrapper(Printable printable) {
        super(printable);
    }
    public void wrapByHash() {
        System.out.print("#");
    }

    @Override
    public void print() {
        wrapByHash();
        super.print();
        wrapByHash();
    }
}
