package lessons.inheritance;

import java.nio.file.Path;
import java.nio.file.Paths;

public class RefactorInheritance {

    public void processing(Book book) {
//        do something with book
    }

    public void processing(Article article) {

//        Article article1 = new Reference();

//        do something with article

//        Заменить параметры на класс Reference, предложить рефакторинг
    }

}


class Reference {
    /*String author1, String author2,
    String author3, String author4,

    Boolean isUpdated, int year, int volume*/
}

class Book extends Reference {
//    int countOfpages, String nameBook,
}

class Article extends Reference {
    /*int startPage, int endPage,
    String nameArticle,*/
}

