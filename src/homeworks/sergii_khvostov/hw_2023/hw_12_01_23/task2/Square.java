package homeworks.sergii_khvostov.hw_2023.hw_12_01_23.task2;

public abstract class Square implements Calculatable2 {
    private double sideLength;
    private double height;

    @Override
    public double calculatePerimeter() {
        return sideLength * height;
    }
}
