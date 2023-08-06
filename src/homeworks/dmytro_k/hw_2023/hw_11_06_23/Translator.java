package homeworks.dmytro_k.hw_2023.hw_11_06_23;

import java.io.IOException;

/**
 * Создать приложение переводчик.
 * <p>
 * Приложение должно позволять:
 * - добавлять новые слова.
 * - переводить предложение с одного из языков(Русский - Украинский, Украинский - Русский,
 * Английский - Русский, Русский - Английский).
 * - после ввода слова определять язык, на котором ввел юзер
 * - добавлять новые языки.
 * - Написать метод, который определяет есть ли в словаре перевод для данного слова
 * - В методе перевода предложения написать логику, что если хотя бы нет перевода одного слова из
 * предложения то не переводить все предложение.
 * <p>
 * После остановки программы сохранять словари в файлах и после запуска наполнять словари.
 * <p>
 * Map<String, Map<String, String>>
 * Map<String, List<Word>>
 * <p>
 * Map<eng_rus, Map<Hello, Привет; Morning:Утро>>
 * <p>
 * Map<eng_de, Map<Hello, Hallo; Morning:Tak>>
 * <p>
 * Dir:
 * eng_rus.txt
 * eng_de.txt
 * eng_sp.txt
 * <p>
 * Hello:Привет
 * Morning:Утро
 * Friend:Друг
 * <p>
 * Files.readAllLines()
 */

public class Translator {

    public static void main(String[] args) throws IOException {

        TranslatorService translatorService = new TranslatorService();
        translatorService.translate("Hello Dog", "eng", "ukr");
        translatorService.addWord("eng_ukr", "woman","жінка");
        translatorService.getLanguage("Dog");
        translatorService.getAvailableTranslations("людина");
        translatorService.stop();
    }
}
