package homeworks.dmytro_k.hw_2023.hw_03_03_23.task3;

public class Rectangle {

    public static int squareRectangle(int sideA, int sideB) {
        if (sideA <= 0 || sideB <= 0) {
            throw new IllegalArgumentException("incorrect value");
        }
        return sideA * sideB;
    }

    public static int trySquareRectangle(int sideA, int sideB) {
        try {
            return squareRectangle(sideA, sideB);
        } catch (IllegalArgumentException e) {
            return -1;
        }
    }
}
