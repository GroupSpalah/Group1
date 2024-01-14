package homeworks.vladyslav_lazin.hw_2024.hw_07_01_24.decorator;

public class FigureBracketsWrapper extends PhraseDecorator {
    public FigureBracketsWrapper(Printable printable) {
        super(printable);
    }
    public void printLeftFigureBracket() {
        System.out.print("{");
    }
    public void printRightFigureBracket() {
        System.out.print("}");
    }

    @Override
    public void print() {
        printLeftFigureBracket();
        super.print();
        printRightFigureBracket();
    }
}
