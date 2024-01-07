package homeworks.vladyslav_lazin.hw_2023.hw_24_12_23.template_method;

public class showFiguresTest {
    public static void main(String[] args) {
        Figures figures = new Line();
        figures.showFigures();
        figures = new Square();
        figures.showFigures();
        figures = new Cross();
        figures.showFigures();
    }
}

