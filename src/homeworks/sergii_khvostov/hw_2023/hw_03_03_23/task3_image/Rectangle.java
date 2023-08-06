package homeworks.sergii_khvostov.hw_2023.hw_03_03_23.task3_image;

/*Create a method for calculating an area of a rectangle.
int squareRectangle(int a, int b) which should throw IllegalArgumentException
if at least one of its arguments is non positive.
Create trySquareRectangle method which take two parameters
and calls squareRectangle to evaluate an area of a rectangle.
Catch exception that can be generated.
trySquareRectangle shouldn't generate any exception.
In case when one or two parameters are non positive the method should return -1.*/

public class Rectangle {
    public static int SquareRectangle(int a, int b) throws IllegalArgumentException {
        if (a <= 0 || b <= 0) {
            throw new IllegalArgumentException
                    ("Both arguments must be positive integers");
        }
        return a * b;
    }

    public static int trySquareRectangle(int a, int b) {
        try {
            return SquareRectangle(a, b);
        } catch (IllegalArgumentException e) {
            return -1;
        }
    }
}

