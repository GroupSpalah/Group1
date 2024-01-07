package homeworks.vladyslav_lazin.hw_2023.hw_24_12_23.template_method;

public abstract class Figures {
    private void showTriangle() {
        System.out.println("    *\n" +
                "   ***\n" +
                "  *****\n" +
                " *******\n" +
                "*********\n");
    }
    public abstract void showAnotherFigure();

    public void showFigures() {
        showTriangle();
        showAnotherFigure();
        showTriangle();

    }
}
