package homeworks.sergii_khvostov.hw_2023.hw_19_03_23;

//Какие будут ошибки?

public class FindABug {
    class Task implements Actionable {
        public void doIt() {
        }
    }

    abstract class Test extends Task {
    }

    abstract class Compile extends Task {
        public void doIt(int x) {
        }
    }
    /*Класс Compile наследуется от Task, но переопределяет метод doIt()
    с другой сигнатурой (public void doIt(int x)). Это не разрешено,
    потому что в Java методы должны иметь ту же сигнатуру,
    что и методы в базовом классе.*/

    class Run extends Task implements Actionable {
        public void doStuff() {
        }
    }

    //Класс Run реализует интерфейс Actionable, но не реализует его метод doIt().
    interface Actionable {
        public void doIt();
    }
}
