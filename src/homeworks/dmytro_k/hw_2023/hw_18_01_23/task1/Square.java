package homeworks.dmytro_k.hw_2023.hw_18_01_23.task1;

public class Square extends Shape {

    public Square(ShapeName name, double side1, double side2) {
        super(name, side1, side2);
        if (side1 != side2) {
            System.out.println("Square has equal sides, " +
                    "sides will be set to the first value");
            setSide2(side1);
        }
    }

    @Override
    void drawShape() {
        System.out.println(super.getName().getName());
        System.out.println("pretend it's a square");
    }
}
