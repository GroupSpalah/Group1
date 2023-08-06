package homeworks.sergii_khvostov.hw_2023.hw_12_01_23.task2;

public abstract class Circle implements Calculatable2{
    private double R;
    @Override
    public double calculateArea() {
        return 3.14 * R;
    }
}
