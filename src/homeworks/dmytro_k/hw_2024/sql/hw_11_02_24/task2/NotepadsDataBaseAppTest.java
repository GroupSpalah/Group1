package homeworks.dmytro_k.hw_2024.sql.hw_11_02_24.task2;

public class NotepadsDataBaseAppTest {
    public static void main(String[] args) {
        /*Отображение всего содержимого таблицы с блокнотами*/
        NotepadsDataBaseApp.printTable();
        /*Показать все страны производители*/
        NotepadsDataBaseApp.printDistinctColumnContent("country_of_origin");
        /*Показать названия стран и количество блокнотов из каждой страны*/
        NotepadsDataBaseApp.printNumberOfCoincidences("country_of_origin");
        /*Показать названия производителя и количество блокнотов каждого производителя*/
        NotepadsDataBaseApp.printNumberOfCoincidences("manufacturer_name");
        /*Показать страну с наибольшим количеством блокнотов*/
        NotepadsDataBaseApp.printMostCommonMeaning("country_of_origin");
        /*Показать страну с наименьшим количеством блокнотов*/
        NotepadsDataBaseApp.printLeastCommonMeaning("country_of_origin");
        /*Показать производителя с наибольшим количеством блокнотов*/
        NotepadsDataBaseApp.printMostCommonMeaning("manufacturer_name");
        /*Показать производителя с наименьшим количеством блокнотов*/
        NotepadsDataBaseApp.printLeastCommonMeaning("manufacturer_name");
        /*Показать все блокноты с мягкой обложкой*/
        NotepadsDataBaseApp.filterByValue("cover_type", "soft");
        /*Показать все блокноты с твердой обложкой*/
        NotepadsDataBaseApp.filterByValue("cover_type", "hard");
        /*Показать все блокноты конкретной страны*/
        NotepadsDataBaseApp.filterByValue("country_of_origin", "USA");
        /*Создать фильтр для отображения блокнотов по внешнему виду страницы*/
        NotepadsDataBaseApp.filterByValue("appearance_of_the_notebook_page", "square");
        /*Создать фильтр по количеству страниц*/
        NotepadsDataBaseApp.filterByValue("number_of_pages", "192");
        /*Добавление строки*/
        //NotepadsDataBaseApp.addNotebook("Oxford", "Campus Notebook",
        //        200, "hard", "France", "square");
        /*Обновление строки*/
        //NotepadsDataBaseApp.updateNotebook( "Pukka Pad", "Project Book",
        //        150, "hard", "UK", "ruler", 26);
        /*Удаление строки*/
        //NotepadsDataBaseApp.deleteNotebook(21);
    }
}
