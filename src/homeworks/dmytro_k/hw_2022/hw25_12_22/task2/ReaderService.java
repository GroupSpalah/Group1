package homeworks.dmytro_k.hw_2022.hw25_12_22.task2;

public class ReaderService {

    public static void main(String[] args) {

        Reader reader1 = new Reader("Some name Q.Q.", 12345, "qwerty", "20.01.1990", 1234567890);

        Book book1 = new Book("Приключения", "Some author");
        Book book2 = new Book("Энциклопедия", "Some author");
        Book book3 = new Book("Словарь", "Some author");

        reader1.takeBook(3);
        reader1.takeBook(new String[]{"Приключения", "Словарь", "Энциклопедия"});
        reader1.takeBook(new Book[]{book1, book2, book3});

        reader1.returnBook(3);
        reader1.returnBook(new String[]{"Приключения", "Словарь", "Энциклопедия"});
        reader1.returnBook(new Book[]{book1, book2, book3});
    }
}
