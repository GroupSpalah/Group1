package homeworks.sergii_khvostov.hw_2023.hw_12_01_23.task1;

public abstract class Figure implements Calculatable {
    public double sideLength;
    public double height;

    public Figure(double sideLength, double height) {
        this.sideLength = sideLength;
        this.height = height;
    }
}


