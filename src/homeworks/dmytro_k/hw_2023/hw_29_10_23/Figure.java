package homeworks.dmytro_k.hw_2023.hw_29_10_23;

import java.io.Serializable;

public class Figure implements Comparable<Figure>, Serializable {

    private double sideA;
    private double sideB;

    public Figure(double sideA, double sideB) {
        this.sideA = sideA;
        this.sideB = sideB;
    }

    public double calculatePerimeter() {
        return (sideA + sideB) * 2;
    }

    public double calculateAreA() {
        return sideA * sideB;
    }

    @Override
    public int compareTo(Figure o) {
        return 0;
    }

    @Override
    public String toString() {
        return "Figure {" +
                "sideA=" + sideA +
                ", sideB=" + sideB +
                '}';
    }
}
