package homeworks.sergii_khvostov.hw_2023.hw_18_01_23.task1;

public class Circle extends Shape {
    public Circle(ShareType shareType) {
        super(shareType);
    }

    @Override
    public void drawShape() {
        if (getShareType() == ShareType.CIRCLE) {
            drawCircle();
        } else {
            System.out.println(ShareType.SQUARE);
        }
    }

    @Override
    public void drawCircle() {
        System.out.println(ShareType.CIRCLE);
    }
}
