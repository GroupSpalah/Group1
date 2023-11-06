package homeworks.vladyslav_lazin.hw_2023.hw_29_10_23;

import java.util.List;

public class ShapeTest {
    public static void main(String[] args) {
        List<Shape> shapes = List.of(new Squere(5.0F),
                new Rectangle(6.0F, 7.5F),
                new Squere(8.9F),
                new Squere(7.1F),
                new Rectangle(3.9F, 9.0F),
                new Rectangle(4.6F, 7.3F));
    ShapeService.writeShapesToFile(shapes);
    List<Shape> shapesFromFile = ShapeService.readShapesFromFile();
    System.out.println(ShapeService.findMaximalPerimeterShape(shapesFromFile));
    System.out.println(ShapeService.findMaximalSquereShape(shapesFromFile));
    }
}
