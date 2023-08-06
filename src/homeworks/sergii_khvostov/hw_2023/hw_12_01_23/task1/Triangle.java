package homeworks.sergii_khvostov.hw_2023.hw_12_01_23.task1;

public class Triangle extends Figure {

    public Triangle(double sideLength, double height) {
        super(sideLength, height);
    }

    @Override
    public double calculateSquare() {
        return  0.5 * sideLength * height;

    }
}
