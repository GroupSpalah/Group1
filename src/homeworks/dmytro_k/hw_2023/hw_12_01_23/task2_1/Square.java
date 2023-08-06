package homeworks.dmytro_k.hw_2023.hw_12_01_23.task2_1;

public class Square implements Calculable {

    private double sideLength;

    public Square(double sideLength) {
        this.sideLength = sideLength;
    }

    @Override
    public double calculateArea() {
        return sideLength * sideLength;
    }

    @Override
    public double calculatePerimeter() {
        return sideLength * 4;
    }
}
