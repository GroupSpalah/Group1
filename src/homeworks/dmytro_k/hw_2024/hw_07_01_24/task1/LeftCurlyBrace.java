package homeworks.dmytro_k.hw_2024.hw_07_01_24.task1;

public class LeftCurlyBrace implements Printable {

    private final Printable printable;

    public LeftCurlyBrace(Printable printable) {
        this.printable = printable;
    }


    @Override
    public void print() {
        System.out.print("{");
        printable.print();
    }
}
