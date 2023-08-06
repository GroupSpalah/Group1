package homeworks.dmytro_k.hw_2023.hw_18_01_23.task1;


public class TestShape {
    public static void main(String[] args) {

        Shape shape1 = new Circle(ShapeName.CIRCLE,5);
        Shape shape2 = new Square(ShapeName.SQUARE,5,6);

        shape1.drawShape();

        shape2.drawShape();

        shape1.setSide2(6); //?
    }
}