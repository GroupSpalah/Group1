package homeworks.sergii_khvostov.hw_2023.hw_18_01_23.task1;

/*Пожалуйста, создайте абстрактный класс Shape и два подкласса Square и Circle.
 Заменить код в методе drawShape() в соответствии с принципами полиморфизма.
 Пожалуйста, предложите другие решения для улучшения качества кода.
*/
public abstract class Shape {
    private ShareType shareType;

    public Shape(ShareType shareType) {
        this.shareType = shareType;
    }

    public ShareType getShareType() {
        return shareType;
    }

    public void drawSquare() {
    }

    public void drawCircle() {
    }

    public void drawShape() {
    }
}
