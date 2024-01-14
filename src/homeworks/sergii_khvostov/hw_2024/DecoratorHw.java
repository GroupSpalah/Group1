package homeworks.sergii_khvostov.hw_2024;

/**
 * СТРУКТУРНЫЙ ШАБЛОН ПРОЕКТИРОВАНИЯ, предназначенный для динамического подключения дополнительного поведения
 * к объекту. Шаблон Декоратор предоставляет гибкую альтернативу практике создания
 * подклассов с целью расширения функциональности.
 * <p>
 * Добавить функционал добавления к строке # и {} к шаблону Декоратор, чтобы получить строку #{Hello}#
 */
public class DecoratorHw {
    public static void main(String[] args) {//[Hello]

        /*Printable printer = new RealPrinter("Hello");

        Printable leftBracket = new LeftBracket(printer);

        Printable rightBracket = new RightBracket(leftBracket);

        rightBracket.print();*/

        // new RightBracket(new LeftBracket(new RealPrinter("Hello"))).print();

        new LatticeRight(new LatticeLeft(new RightBracket(new LeftBracket(new RealPrinter("Hello")))))
                .print();
    }
}

interface Printable {
    void print();
}

class RealPrinter implements Printable {
    private String text;

    public RealPrinter(String text) {
        this.text = text;
    }

    @Override
    public void print() {
        System.out.print("Hello");
    }
}

class LeftBracket implements Printable {
    private Printable printable;

    public LeftBracket(Printable printable) {//RealPrinter
        this.printable = printable;
    }

    @Override
    public void print() {
        System.out.print("{");//[
        printable.print();//Hello
    }
}

class RightBracket implements Printable {
    private Printable printable;

    public RightBracket(Printable printable) {//LeftBracket
        this.printable = printable;
    }

    @Override
    public void print() {
        printable.print();
        System.out.print("}");
    }
}

class LatticeLeft implements Printable {
    private Printable printable;

    public LatticeLeft(Printable printable) {
        this.printable = printable;
    }

    @Override
    public void print() {
        System.out.print("#");
        printable.print();
    }
}

class LatticeRight implements Printable {
    private Printable printable;

    public LatticeRight(Printable printable) {
        this.printable = printable;
    }

    @Override
    public void print() {
        printable.print();
        System.out.print("#");
    }
}
