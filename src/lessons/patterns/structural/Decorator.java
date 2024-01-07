package lessons.patterns.structural;

/**
 *  СТРУКТУРНЫЙ ШАБЛОН ПРОЕКТИРОВАНИЯ, предназначенный для динамического подключения дополнительного поведения
 *  к объекту. Шаблон Декоратор предоставляет гибкую альтернативу практике создания
 *  подклассов с целью расширения функциональности.
 */
public class Decorator {
    public static void main(String[] args) {//[Hello]
//        System.out.println("[Hello]");

        /*Printable printer = new RealPrinter("Hello");

        Printable leftBracket = new LeftBracket(printer);

        Printable rightBracket = new RightBracket(leftBracket);

        rightBracket.print();*/

        new RightBracket(new LeftBracket(new RealPrinter("Hello"))).print();
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
        System.out.print("[");//[
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
        System.out.print("]");
    }
}
