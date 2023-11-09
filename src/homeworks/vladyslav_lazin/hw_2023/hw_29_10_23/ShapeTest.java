package homeworks.vladyslav_lazin.hw_2023.hw_29_10_23;

import java.util.List;

public class ShapeTest {
    public static void main(String[] args) {
        List<Shape> shapes = List.of(new Square(5.0F),
                new Rectangle(6.0F, 7.5F),
                new Square(8.9F),
                new Square(7.1F),
                new Rectangle(3.9F, 9.0F),
                new Rectangle(11.9F, 23.0F));
    ShapeService.writeShapesToFile(shapes);
    List<Shape> shapesFromFile = ShapeService.readShapesFromFile();
    System.out.println(ShapeService.findMaximalPerimeterShape(shapesFromFile));
    System.out.println(ShapeService.findMaximalSquareShape(shapesFromFile));
    }
}
