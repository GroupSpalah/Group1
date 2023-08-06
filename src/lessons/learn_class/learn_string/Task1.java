package lessons.learn_class.learn_string;

/**
 * *** Implement method hasNoneLetters. Method returns true if none of the letters in the blacklist are present in the phrase.
 * If at least one letter from blacklist is present in the phrase return false. Comparison should be case insensitive.
 */
public class Task1 {
    public static void main(String[] args) {
        int a = 10;

        a = a + 5;
    }

    public static boolean hasNoneLetters(String str, String blackList) {
        str = str.toLowerCase();//"Hello", "hello"
        blackList = blackList.toLowerCase();

        for (int i = 0; i < blackList.length(); i++) {
            char symbol = blackList.charAt(i);

            String symbolAsString = String.valueOf(symbol);//char -> String

            if (str.contains(symbolAsString)) {
                return false;
            }
        }

        return true;
    }
}
