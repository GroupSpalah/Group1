package homeworks.vladyslav_lazin.hw_2024.hw_07_01_24.decorator;

public class Task {
    public static void main(String[] args) {
        Printable wrappedPhrase = new HashWrapper(new FigureBracketsWrapper(new MainPhrase()));
        wrappedPhrase.print();
    }
}
