package homeworks.sergii_khvostov.hw_2023.hw_24_12_23.figure;

/*Использовать паттерн "Шаблонный метод" и выводить в консоль следующие фигуры:
1)
          *
         ***
        *****
       *******
      *********

	  *********

          *
         ***
        *****
       *******
      *********
2)
          *
         ***
        *****
       *******
      *********

      *********
      *********
      *********
      *********

          *
         ***
        *****
       *******
      *********

3)
          *
         ***
        *****
       *******
      *********

         ***
         ***
      *********
      *********
         ***
         ***

          *
         ***
        *****
       *******
      **********/

abstract class FigureTemplate {
     public abstract void drawFigure();

     private void buildTriangles() {
        System.out.println();
        System.out.println("    *");
        System.out.println("   ***");
        System.out.println("  *****");
        System.out.println(" *******");
        System.out.println("*********");
        System.out.println();
    }
    public final void buildFigure() {
        buildTriangles();
        drawFigure();
        buildTriangles();
    }
}
