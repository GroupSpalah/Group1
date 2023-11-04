package homeworks.vladyslav_lazin.hw_2023.hw_29_10_23;

public class Rectangle extends Shape {
    private final float width;
    private final float height;

    public Rectangle(float width, float height) {
        this.width = width;
        this.height = height;
    }

    @Override
    public float getPerimeter() {
        return 2 * (this.width + this.height);
    }

    @Override
    public float getSquere() {
        return this.width * this.height;
    }

    @Override
    public String toString() {
        return "Rectangle{" +
                "width=" + width +
                ", height=" + height +
                '}';
    }
}
