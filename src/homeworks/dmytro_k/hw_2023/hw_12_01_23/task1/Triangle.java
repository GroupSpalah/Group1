package homeworks.dmytro_k.hw_2023.hw_12_01_23.task1;

public class Triangle extends Figure {

    public Triangle(double height, double sideLength, String name) {
        super(height, sideLength, name);
    }

    @Override
    public double calculateSquare() {
        return super.calculateSquare() / 2;
    }
}
