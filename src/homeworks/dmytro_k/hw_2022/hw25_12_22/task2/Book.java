package homeworks.dmytro_k.hw_2022.hw25_12_22.task2;

/*  (создать новый класс,
   содержащий имя и автора книги).*/

public class Book {
    String name;
    String author;

    public Book(String name, String author) {
        this.name = name;
        this.author = author;
    }

    public String getName() {
        return name;
    }
}
