package homeworks.dmytro_k.hw_2023.hw_29_10_23;

public class FigureTest {
    public static void main(String[] args) {
/*        Rectangle rectangle1 = new Rectangle(2, 3);
        Rectangle rectangle2 = new Rectangle(3, 3);
        Rectangle rectangle3 = new Rectangle(10, 1);
        Square square1 = new Square(5);
        Square square2 = new Square(4);
        Square square3 = new Square(1);*/

        FigureService figureService = new FigureService();
/*
      figureService.addFigure(rectangle1);
        figureService.addFigure(rectangle2);
        figureService.addFigure(rectangle3);
        figureService.addFigure(square1);
        figureService.addFigure(square2);
        figureService.addFigure(square3);*/

        FileManager fileManager = new FileManager();
        //fileManager.writeToFile(figureService);
        fileManager.readFile(figureService);
        figureService.maxArea();
        figureService.maxPerimeter();
    }
}
