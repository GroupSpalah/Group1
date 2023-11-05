package homeworks.sergii_khvostov.hw_2023.hw_29_10_23;

public class Rectangle extends Figure {
    private double a;
    private double b;

    public Rectangle(double a, double b) {
        this.a = a;
        this.b = b;
    }

    @Override
    double CalcSquare() {
        return a * b;
    }

    @Override
    double CalcPerimeter() {
        return 2 * (a + b);
    }

    @Override
    public String toString() {
        return "Rectangle: " + CalcSquare() + ", Perimeter: " + CalcPerimeter();
    }
}


