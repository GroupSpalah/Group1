package homeworks.dmytro_k.hw_2023.hw_18_01_23.task1;


public class Circle extends Shape {

    public Circle(ShapeName shapeName, double radius) {
        super(shapeName, radius);
    }

    @Override
    void drawShape() {
        System.out.println(super.getName().getName());
        System.out.println("pretend it's a circle");
    }
}