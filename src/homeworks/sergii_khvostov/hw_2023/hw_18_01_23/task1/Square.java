package homeworks.sergii_khvostov.hw_2023.hw_18_01_23.task1;

public class Square extends Shape {
    public Square(ShareType shareType) {
        super(shareType);
    }

    @Override
    public void drawShape() {
        if (getShareType() == ShareType.SQUARE) {
            drawSquare();
        } else {
            System.out.println(ShareType.CIRCLE);
        }
    }

    @Override
    public void drawSquare() {
        System.out.println(ShareType.SQUARE);
    }
}
