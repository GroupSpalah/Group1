package homeworks.dmytro_k.hw_2024.hw_07_12_24.task1;

public class RightNumberSign implements Printable {

    private final Printable printable;

    public RightNumberSign(Printable printable) {
        this.printable = printable;
    }


    @Override
    public void print() {
        printable.print();
        System.out.print("#");
    }
}
