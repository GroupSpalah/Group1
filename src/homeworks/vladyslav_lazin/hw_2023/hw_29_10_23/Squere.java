package homeworks.vladyslav_lazin.hw_2023.hw_29_10_23;

public class Squere extends Shape {
    private final float side;

    public Squere(float side) {
        this.side = side;
    }

    @Override
    public float getPerimeter() {
        return this.side * 4;
    }

    @Override
    public float getSquere() {
        return this.side * this.side;
    }

    @Override
    public String toString() {
        return "Squere{" +
                "side=" + side +
                '}';
    }
}
