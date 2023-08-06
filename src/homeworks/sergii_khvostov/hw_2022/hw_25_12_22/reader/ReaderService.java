package homeworks.sergii_khvostov.hw_2022.hw_25_12_22.reader;

public class ReaderService {
    public static void main(String[] args) {
        Book book = new Book();
        Reader reader =
                new Reader("Alex", 102, "Mechanic",
                        "05/01/2001", 3581465);

        reader.takeBook(3);
        reader.returnBook(2);

        reader.takeBook("Adventure", "Enciclopedia");
        reader.returnBook("Dictionary");

        reader.takeBook(book.books);
        reader.returnBook(book.books);

    }
}
