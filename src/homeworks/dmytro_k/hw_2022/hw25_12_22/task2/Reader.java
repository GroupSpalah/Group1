package homeworks.dmytro_k.hw_2022.hw25_12_22.task2;

/*Определить класс Reader, хранящий такую информацию о
пользователе библиотеки: ФИО, номер читательского билета,
   факультет, дата рождения, телефон. Методы takeBook(), returnBook().
      Перегрузить методы takeBook(), returnBook():

   - takeBook, который будет принимать количество взятых книг. Выводит на консоль сообщение
   "Петров В. В. взял 3 книги".++

   - takeBook, который будет принимать переменное количество названий книг.
   Выводит на консоль сообщение "Петров В. В. взял книги: Приключения, Словарь, Энциклопедия".

   - takeBook, который будет принимать переменное количество объектов класса Book
   (создать новый класс,
   содержащий имя и автора книги). Выводит на консоль сообщение "Петров В. В. взял книги:
   Приключения,
   Словарь, Энциклопедия".

    Аналогичным образом перегрузить метод returnBook(). Выводит на консоль сообщение
    "Петров В. В. вернул книги:
    Приключения, Словарь, Энциклопедия". Или "Петров В. В. вернул 3 книги".
*/

import java.util.Arrays;

public class Reader {

    private String fullName;
    private int libraryCardNumber;
    private String faculty;
    private String dateOfBirth;
    private int phone;

    public Reader(String fullName, int libraryCardNumber, String faculty, String dateOfBirth, int phone) {
        this.fullName = fullName;
        this.libraryCardNumber = libraryCardNumber;
        this.faculty = faculty;
        this.dateOfBirth = dateOfBirth;
        this.phone = phone;
    }

    public void takeBook(int amountOfBook) {
        System.out.println(this.fullName + " take " + amountOfBook + " books");
    }

    public void takeBook(String[] books) {
        System.out.println(this.fullName + " take books: " + Arrays.toString(books));
    }

    public void takeBook(Book[] books) {

        String[] names = new String[books.length];

        for (int i = 0; i < books.length; i++) {
            String name = books[i].getName();
            names[i] = name;
        }

        System.out.println(this.fullName + " take books: " + Arrays.toString(names));
    }

    public void returnBook(int amountOfBook) {
        System.out.println(this.fullName + " return " + amountOfBook + " books");
    }

    public void returnBook(String[] books) {
        System.out.println(this.fullName + " return books: " + Arrays.toString(books));
    }

    public void returnBook(Book[] books) {

        String[] names = new String[books.length];

        for (int i = 0; i < books.length; i++) {
            String name = books[i].getName();
            names[i] = name;
        }

        System.out.println(this.fullName + " return books: " + Arrays.toString(names));
    }
}
