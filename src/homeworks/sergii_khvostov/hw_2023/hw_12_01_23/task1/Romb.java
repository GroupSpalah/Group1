package homeworks.sergii_khvostov.hw_2023.hw_12_01_23.task1;

public class Romb extends Figure {
    public Romb(double sideLength, double height) {
        super(sideLength, height);
    }

    @Override
    public double calculateSquare() {
        return sideLength * height;
    }
}
