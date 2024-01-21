package homeworks.sergii_khvostov.hw_2024.hw_14_01_24.task2;

/*Suppose we have executed method with next signature:

  public static void execute(int a, int b, Strategy strategy) {
  double result = strategy.doOperation(a, b);
  System.out.println(result);
}

 Where is Strategy is the next interface:

  public interface Strategy {
    double doOperation(int a, int b);
}

Using anonymous classes concept, call the execute method 4 times with different strategy
(override method doOperation from Strategy interface):
1) Add a to b \\ (a + b)
2) Subtract b from a \\ (a - b)
3) Multiply a by b \\ (a * b)
4) Divide a by b \\ (a / b)
*/

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.chrono.ChronoLocalDate;

class AnonymousClass {
    public static void main(String[] args) {
        execute(5, 5, (a, b) -> a + b);
        execute(10, 5, (a, b) -> a - b);
        execute(5, 5, (a, b) -> a * b);
        execute(10, 5, (a, b) -> (double) a / b);
    }

    public static void execute(int a, int b, Strategy strategy) {
        double result = strategy.doOperation(a, b);
        System.out.println(result);
    }

    public interface Strategy {
        double doOperation(int a, int b);
    }
}
