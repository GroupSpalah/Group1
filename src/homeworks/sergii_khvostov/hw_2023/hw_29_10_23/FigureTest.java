package homeworks.sergii_khvostov.hw_2023.hw_29_10_23;


public class FigureTest {
    public static void main(String[] args) {
        FigureService fs = new FigureService();

        String fileName = "figure.fig";

        Square square1 = new Square(5, 7);
        Square square2 = new Square(3, 3);
        Rectangle rectangle1 = new Rectangle(3, 5);
        Rectangle rectangle2 = new Rectangle(5, 6);

        fs.addFigure(square1);
        fs.addFigure(square2);
        fs.addFigure(rectangle1);
        fs.addFigure(rectangle2);

        fs.inFileFigures(fileName);
        fs.findMaxSquare(fileName);
        fs.findMaxPerimeter(fileName);
    }
}
