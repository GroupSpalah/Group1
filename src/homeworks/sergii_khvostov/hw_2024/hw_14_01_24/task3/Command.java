package homeworks.sergii_khvostov.hw_2024.hw_14_01_24.task3;

/*Реализуйте интерфейс Command:

   public interface Command {
    void execute(String... args);
   }
   для поддержки следующих команд:

   help (Выводит в консоль сообщение "Help executed")

   echo <text> (Выводит на консоль строку, например: echo Hello World выведет: "Hello World")

   now (Выводит на экран текущую дату в миллисекундах начиная с 1 января 1970 года.
        Для получения времени используйте метод System.currentTimeMillis()).

   exit (Выводит на экран строку "Goodbye!" и завершает работу программы.
         Для завершения программы используйте метод System.exit(0)).

   Каждая реализация - это отдельный класс реализующий интерфейс Command.
   В случае если команда неизвестна, то необходимо вывести на экран сообщение "Error".
   Пример работы программы:

   >>> help
   Help executed
   >>> now
   1604586299340
   >>> echo Hello World
   Hello World
   >>> exit
   Goodbye!*/

public interface Command {
    void execute(String... args);
}
