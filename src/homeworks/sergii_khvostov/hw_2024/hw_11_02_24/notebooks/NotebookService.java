package homeworks.sergii_khvostov.hw_2024.hw_11_02_24.notebooks;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class NotebookService {
    public static void main(String[] args) {
        try {
            // Присоединение к базе данных
            Connection connection = NotebookDatabase.connect();

            // Отображение всего содержимого таблицы с блокнотами
            NotebookDatabase.displayAllNotebooks();

            // Показать все страны производители
            NotebookDatabase.displayAllCountries();

            // Показать названия стран и количество блокнотов из каждой страны
            NotebookDatabase.displayCountryNotebookCount();

            // Показать названия производителя и количество блокнотов каждого производителя
            NotebookDatabase.displayManufacturerNotebookCount();

            // Показать страну с наибольшим количеством блокнотов
            String countryWithMostNotebooks = NotebookDatabase.getCountryWithMostNotebooks();
            System.out.println("Country with most notebooks: " + countryWithMostNotebooks);

            // Показать страну с наименьшим количеством блокнотов
            String countryWithLeastNotebooks = NotebookDatabase.getCountryWithLeastNotebooks();
            System.out.println("Country with least notebooks: " + countryWithLeastNotebooks);

            // Показать производителя с наибольшим количеством блокнотов
            String manufacturerWithMostNotebooks = NotebookDatabase.getManufacturerWithMostNotebooks();
            System.out.println("Manufacturer with most notebooks: " + manufacturerWithMostNotebooks);

            // Показать производителя с наименьшим количеством блокнотов
            String manufacturerWithLeastNotebooks = NotebookDatabase.getManufacturerWithLeastNotebooks();
            System.out.println("Manufacturer with least notebooks: " + manufacturerWithLeastNotebooks);

            // Показать все блокноты с твердой обложкой
            List<Notebook> hardCoverNotebooks = NotebookDatabase.getNotebooksWithHardCover();
            System.out.println("Notebooks with hard cover: " + hardCoverNotebooks);

            // Показать все блокноты с мягкой обложкой
            List<Notebook> softCoverNotebooks = NotebookDatabase.getNotebooksWithSoftCover();
            System.out.println("Notebooks with soft cover: " + softCoverNotebooks);

            // Показать все блокноты конкретной страны
            String specificCountry = "Country1"; // Замените на конкретную страну
            List<Notebook> notebooksFromSpecificCountry = NotebookDatabase.getNotebooksFromCountry(specificCountry);
            System.out.println("Notebooks from " + specificCountry + ": " + notebooksFromSpecificCountry);

            // Создать фильтр для отображения блокнотов по внешнему виду страницы
            String specificPageAppearance = "lined"; // Замените на конкретный внешний вид
            List<Notebook> notebooksByPageAppearance = NotebookDatabase.getNotebooksByPageAppearance(specificPageAppearance);
            System.out.println("Notebooks with page appearance " + specificPageAppearance + ": " + notebooksByPageAppearance);

            // Создать фильтр по количеству страниц
            int specificPageCount = 120; // Замените на конкретное количество страниц
            List<Notebook> notebooksByPageCount = NotebookDatabase.getNotebooksByPageCount(specificPageCount);
            System.out.println("Notebooks with page count " + specificPageCount + ": " + notebooksByPageCount);

            // Добавление строки
            Notebook newNotebook = new Notebook("NewBrand", "NewNotebook", 200, "hard", "NewCountry", "lined");
            NotebookDatabase.addNotebook(newNotebook);

            // Отображение обновленного содержимого таблицы с блокнотами
            NotebookDatabase.displayAllNotebooks();

            // Удаление строки
            int notebookIdToDelete = 1; // Замените на конкретный ID блокнота для удаления
            NotebookDatabase.deleteNotebook(notebookIdToDelete);

            // Отображение обновленного содержимого таблицы с блокнотами
            NotebookDatabase.displayAllNotebooks();

            // Обновление строки
            int notebookIdToUpdate = 2; // Замените на конкретный ID блокнота для обновления
            Notebook notebookToUpdate = new Notebook("UpdatedBrand", "UpdatedNotebook", 150, "soft", "UpdatedCountry", "grid");
            notebookToUpdate.setId(notebookIdToUpdate);
            NotebookDatabase.updateNotebook(notebookToUpdate);

            // Отображение обновленного содержимого таблицы с блокнотами
            NotebookDatabase.displayAllNotebooks();

            // Отсоединение от базы данных
            NotebookDatabase.disconnect(connection);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
