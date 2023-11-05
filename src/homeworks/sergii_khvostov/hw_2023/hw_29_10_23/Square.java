package homeworks.sergii_khvostov.hw_2023.hw_29_10_23;

public class Square extends Figure {
    private double a;
    private double b;

    public Square(double a, double b) {
        this.a = a;
        this.b = b;
    }

    @Override
    double CalcSquare() {
        return a * b;
    }

    @Override
    double CalcPerimeter() {
        return 4 * a;
    }

    @Override
    public String toString() {
        return "Square: " + CalcSquare() + ", Perimeter: " + CalcPerimeter();
    }
}
