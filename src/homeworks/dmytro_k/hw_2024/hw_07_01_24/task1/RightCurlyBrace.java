package homeworks.dmytro_k.hw_2024.hw_07_01_24.task1;

public class RightCurlyBrace implements Printable {

    private final Printable printable;

    public RightCurlyBrace(Printable printable) {
        this.printable = printable;
    }


    @Override
    public void print() {
        printable.print();
        System.out.print("}");
    }
}
