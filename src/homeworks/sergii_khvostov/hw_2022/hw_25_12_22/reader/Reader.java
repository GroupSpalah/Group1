package homeworks.sergii_khvostov.hw_2022.hw_25_12_22.reader;

/*"Читатели библиотеки". Определить класс Reader, хранящий
 такую информацию о пользователе библиотеки:
 ФИО, номер читательского билета, факультет, дата рождения, телефон.
 Методы takeBook(), returnBook().
 Перегрузить методы takeBook(), returnBook():
- takeBook, который будет принимать количество взятых книг.
  Выводит на консоль сообщение "Петров В. В. взял 3 книги".
- takeBook, который будет принимать переменное количество названий книг.
  Выводит на консоль сообщение "Петров В. В. взял книги:
  Приключения, Словарь, Энциклопедия".
- takeBook, который будет принимать переменное количество
  объектов класса Book (создать новый класс, содержащий имя и автора книги).
  Выводит на консоль сообщение "Петров В. В. взял книги: Приключения,
  Словарь, Энциклопедия".
  Аналогичным образом перегрузить метод returnBook().
  Выводит на консоль сообщение "Петров В. В. вернул книги:
  Приключения, Словарь, Энциклопедия". Или "Петров В. В. вернул 3 книги".*/

import java.util.Arrays;

public class Reader extends Book {
    private String name;
    private int numberTicket;
    private String faculty;
    private String dateOfBirth;
    private int phoneNumber;

    public Reader(String name, int numberTicket, String faculty,
                  String dateOfBirth, int phoneNumber) {
        this.name = name;
        this.numberTicket = numberTicket;
        this.faculty = faculty;
        this.dateOfBirth = dateOfBirth;
        this.phoneNumber = phoneNumber;
    }

    public void takeBook() {

    }

    public void returnBook() {

    }

    public void takeBook(int amountBook) {
        System.out.println(name + " take " + amountBook + " books");
    }

    public void takeBook(String... bookName) {
        System.out.println(name + " taked a books: " +
                Arrays.toString(bookName));
    }

    public void takeBook(Book... books) {
        System.out.println(name + " taked a books: " +
                Arrays.toString(books));
    }

    public void returnBook(int amountBook) {
        System.out.println(name + " return " + amountBook + " books");
    }

    public void returnBook(String... bookName) {
        System.out.println(name + " returned a books: " +
                Arrays.toString(bookName));
    }

    public void returnBook(Book... book) {
        System.out.println(name + " returned a books: " +
                Arrays.toString(book));
    }
}
