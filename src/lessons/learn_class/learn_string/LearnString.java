package lessons.learn_class.learn_string;

public class LearnString {
    public static void main(String[] args) {
        String str1 = new String("Hello my young friend");//object
        String str2 = "Hello";//object-literal

        for (int i = 0; i < str1.length(); i++) {
//            System.out.println(str1.charAt(i));
        }

        String[] words = str1.split(" ");//"Hello", "my"

        for (String word : words) {
//            word.charAt(word.length() - 1);
        }

        String str3 = str1.substring(5);

//        System.out.println(str3);

        String str4 = str1.substring(5, 10);

//        System.out.println(str4);

        char c = 'H';

        final char[] sentence = {'H', 'e', 'l', 'l', 'o'};
//        sentence = new char[]{'H', 'e', 'l', 'l'};

        String str5 = "Hello";

    }
}
