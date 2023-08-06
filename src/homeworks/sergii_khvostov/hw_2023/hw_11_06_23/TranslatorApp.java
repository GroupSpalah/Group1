package homeworks.sergii_khvostov.hw_2023.hw_11_06_23;
/*Создать приложение переводчик.

Приложение должно позволять:
- добавлять новые слова.
- переводить предложение с одного из языков(Русский - Украинский, Украинский - Русский, Английский - Русский, Русский - Английский).
- после ввода слова определять язык, на котором ввел юзер
- добавлять новые языки
- Написать метод который определяет есть ли в словаре перевод для данного слова
- В методе перевода предложения написать логику что если хотя бы нет перевода одного слова из
предложения то не переводить все предложение.

После остановки программы сохранять словари в файлах и после запуска наполнять словари.*/

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.*;

public class TranslatorApp {
    final Map<String, Map<String, String>> DICTIONARIES;

    public static final Path PATH_TO_DIR = Paths.get("dictionaries/");
    public static final String DUO_POINT = ":";
    public static final String TXT = ".txt";
    public static final String LOWER_LINE = "_";
    public static final String SPACE = " ";
    public static final String EMPTY = "";

    public TranslatorApp() throws IOException {
        this.DICTIONARIES = new HashMap<>();
        loadDictionary();
    }

    void translateWord(String fromLanguage, String toLanguage, String sentence) {
        String[] words = sentence.split(SPACE);
        StringBuilder translation = new StringBuilder();

        String dictionaryKey = fromLanguage + LOWER_LINE + toLanguage;
        Map<String, String> dictionary =
                DICTIONARIES.computeIfAbsent(dictionaryKey, k -> new HashMap<>());

        boolean hasUntranslatedWord = false;

        for (String word : words) {
            String translatedWord = dictionary.get(word);

            if (translatedWord == null || translation.indexOf(translatedWord) != -1) {
                System.out.println("Translation for word '" + word + "' not found.");
                hasUntranslatedWord = true;
                break;
            }

            translation.append(translatedWord).append(SPACE);
        }
        if (!hasUntranslatedWord) {
            System.out.println("Translation: " + translation.toString().trim());
        }
    }

    void addWordToDictionary(String word, String translation,
                             String fromLanguageCode, String toLanguageCode) throws IOException {
        String dictionaryKey = fromLanguageCode + LOWER_LINE + toLanguageCode;
        Map<String, String> dictionary =
                DICTIONARIES.computeIfAbsent(dictionaryKey, k -> new HashMap<>());
        dictionary.put(word, translation);
    }

    private void loadDictionary() throws IOException {
        Files.walkFileTree(PATH_TO_DIR, new SimpleFileVisitor<>() {
            @Override
            public FileVisitResult visitFile(Path path, BasicFileAttributes attrs) throws IOException {

                List<String> lines = Files.readAllLines(path);
                Map<String, String> temporaryDictionary = new HashMap<>();

                for (String line : lines) {
                    String[] parts = line.split(DUO_POINT);
                    if (parts.length >= 2) {
                        String word = parts[0].trim();
                        String translation = parts[1].trim();
                        temporaryDictionary.put(word, translation);
                    }
                }

                String name = path.toFile().getName().replace(TXT, EMPTY);

                DICTIONARIES.put(name, temporaryDictionary);

                return FileVisitResult.CONTINUE;
            }
        });
    }

    void saveDictionary(String fileName) throws IOException {
        String filePath = PATH_TO_DIR + "/" + fileName + TXT;

        Map<String, String> dictionary = DICTIONARIES.get(fileName);

        if (dictionary == null) {
            System.out.println("Dictionary not found.");
            return;
        }

        Set<String> existingWords = new HashSet<>();

        List<String> existingLines = Files.readAllLines(Paths.get(filePath));

        for (String line : existingLines) {
            String[] parts = line.split(DUO_POINT);
            existingWords.add(parts[0].trim());
        }

        List<String> linesToAdd = new ArrayList<>();

        for (Map.Entry<String, String> wordEntry : dictionary.entrySet()) {
            String word = wordEntry.getKey();
            String translation = wordEntry.getValue();
            if (!existingWords.contains(word)) {
                linesToAdd.add(word + DUO_POINT + translation);
            }
        }

        Files.write(Paths.get(filePath), linesToAdd, StandardOpenOption.APPEND);

        System.out.println("Dictionary saved: " + fileName);
    }

    public String detectLanguage(String word) throws IOException {

        for (Path filePath : Files.newDirectoryStream(PATH_TO_DIR, "*.txt")) {
            for (String line : Files.readAllLines(filePath)) {
                String[] parts = line.split(DUO_POINT);

                if (parts[0].equalsIgnoreCase(word) || parts[1].equalsIgnoreCase(word)) {
                    String fileName = filePath.getFileName().toString();
                    String languageCode = fileName.replace(TXT, EMPTY);
                    String[] languageParts = languageCode.split(LOWER_LINE);

                    if (parts[0].equalsIgnoreCase(word)) {
                        System.out.println(languageParts[0]);
                        return languageParts[0];
                    } else {
                        System.out.println(languageParts[1]);
                        return languageParts[1];
                    }
                }
            }
        }
        return null;
    }
}









