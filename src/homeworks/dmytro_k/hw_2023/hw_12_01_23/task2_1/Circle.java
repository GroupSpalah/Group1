package homeworks.dmytro_k.hw_2023.hw_12_01_23.task2_1;

public class Circle implements Calculable {

    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public double calculateArea() {
        return 3.14 * radius * radius;
    }

    @Override
    public double calculatePerimeter() {
        return 2 * 3.14 * radius;
    }
}
