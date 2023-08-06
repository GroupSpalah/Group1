package homeworks.dmytro_k.hw_2023.hw_11_06_23;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static java.nio.file.Files.delete;

public class TranslatorService {

    private static final Path TRANSLATOR_DIRECTORY =
            Paths.get("src/homeworks/dmytro_k/hw_2023/hw_11_06_23/translator");
    private static final String SPACE = " ";
    private static final String DOT = "\\.";
    private static final String COLON = ":";
    private static final String LOW_LINE = "_";
    private static final Map<String, Map<String, String>> DICTIONARIES = new HashMap<>();

    public TranslatorService() throws IOException {
        fillMap();
    }

    public void addWord(String language, String word, String translation) {

        if (DICTIONARIES.containsKey(language)) {
            Map<String, String> dictionary = DICTIONARIES.get(language);
            if (!dictionary.containsKey(word)) {
                dictionary.put(word, translation);
            }
        } else {
            addDictionary(language);
            addWord(language, word, translation);
        }
    }

    public void addDictionary(String languages) {

        Map<String, String> dictionary = new HashMap<>();
        DICTIONARIES.put(languages, dictionary);
    }

    public void translate(String text, String translateFrom, String translateTo) {

        String[] textWords = text.split(SPACE);
        int count = 0;

        String language = translateFrom.concat(LOW_LINE).concat(translateTo);

        Set<Map.Entry<String, Map<String, String>>> dictionaries = DICTIONARIES.entrySet();

        if (DICTIONARIES.containsKey(language)) {
            Set<Map.Entry<String, String>> dictionary = DICTIONARIES.get(language).entrySet();

            System.out.println("Result: ");

            for (Map.Entry<String, String> contentEntry : dictionary) {
                for (String word : textWords) {
                    String firstLangWord = contentEntry.getKey();

                    if (word.equalsIgnoreCase(firstLangWord)) {
                        String secondLangWord = contentEntry.getValue();
                        System.out.println(secondLangWord);
                        count++;
                    }
                }
            }

            if (textWords.length > count) {
                System.out.println("This word is not in the dictionary.");
                System.out.println("You can add words by calling the method: addWord");
            }
        }
    }

    private void fillMap() throws IOException {

        Files.walkFileTree(TRANSLATOR_DIRECTORY, new SimpleFileVisitor<>() {

            @Override
            public FileVisitResult visitFile(Path path, BasicFileAttributes attrs) throws IOException {

                String fullFileName = path.toFile().getName();

                String[] fileName = fullFileName.split(DOT);

                String key = fileName[0];

                List<String> fileContent = Files.readAllLines(path);

                for (String words : fileContent) {
                    String[] langWords = words.split(COLON);
                    addWord(key, langWords[0], langWords[1]);
                }
                return FileVisitResult.CONTINUE;
            }
        });
    }

    public static void saveDictionaries() throws IOException {

        for (Map.Entry<String, Map<String, String>> dictionariesMapEntry : DICTIONARIES.entrySet()) {

            String fileName = TRANSLATOR_DIRECTORY + "\\" + dictionariesMapEntry.getKey() + ".txt";

            Path filePath = Paths.get(fileName);

            Files.createFile(filePath);

            Set<Map.Entry<String, String>> content = dictionariesMapEntry.getValue().entrySet();

            for (Map.Entry<String, String> contentEntry : content) {

                String word = contentEntry.getKey();
                String translate = contentEntry.getValue();

                Files.writeString(filePath, word + COLON
                        + translate + "\n", StandardOpenOption.APPEND);
            }
        }
    }

    public void getLanguage(String word) {

        int count = 0;

        for (Map.Entry<String, Map<String, String>> dictionariesMapEntry : DICTIONARIES.entrySet()) {

            String dictionariesName = dictionariesMapEntry.getKey();

            String[] languages = dictionariesName.split(LOW_LINE);

            Set<Map.Entry<String, String>> content = dictionariesMapEntry.getValue().entrySet();

            for (Map.Entry<String, String> contentEntry : content) {

                String dictionaryWord = contentEntry.getKey();
                String translate = contentEntry.getValue();

                if (word.equalsIgnoreCase(dictionaryWord)) {
                    System.out.println("Original language: ");
                    System.out.println(languages[0]);
                    count++;
                    return;
                }
                if (word.equalsIgnoreCase(translate)) {
                    System.out.println("Original language: ");
                    System.out.println(languages[1]);
                    count++;
                    return;
                }
            }
        }
        if (count == 0) {
            System.out.println("No matches found in dictionaries.");
        }
    }

    public void getAvailableTranslations(String word) {

        int count = 0;
        System.out.println("You can translate this word into: ");

        for (Map.Entry<String, Map<String, String>> dictionariesMapEntry : DICTIONARIES.entrySet()) {

            String dictionariesName = dictionariesMapEntry.getKey();

            String[] languages = dictionariesName.split(LOW_LINE);

            Set<Map.Entry<String, String>> content = dictionariesMapEntry.getValue().entrySet();

            for (Map.Entry<String, String> contentEntry : content) {

                String dictionaryWord = contentEntry.getKey();
                String translate = contentEntry.getValue();

                if (word.equalsIgnoreCase(dictionaryWord)) {
                    System.out.println(languages[1]);
                    count++;
                }
                if (word.equalsIgnoreCase(translate)) {
                    System.out.println(languages[0]);
                    count++;
                }
            }
        }
        if (count == 0) {
            System.out.println("No matches found in dictionaries.");
        }
    }

    public void deleteDictionaries() throws IOException {
        Files.walkFileTree(TRANSLATOR_DIRECTORY, new SimpleFileVisitor<>() {
            @Override
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs)
                    throws IOException {
                delete(file);
                return FileVisitResult.CONTINUE;
            }
        });
    }

    public void stop() throws IOException {
        deleteDictionaries();
        saveDictionaries();
    }
}
