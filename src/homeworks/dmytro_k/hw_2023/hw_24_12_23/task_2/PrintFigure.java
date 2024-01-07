package homeworks.dmytro_k.hw_2023.hw_24_12_23.task_2;

abstract class PrintFigure {

    private void baseFigure() {
        System.out.println("""
                          *
                         ***
                        *****
                       *******
                      *********\
                """);
    }

    abstract void resizableFigure();

    public final void figurePrint() {
        baseFigure();
        resizableFigure();
        baseFigure();
    }

}
