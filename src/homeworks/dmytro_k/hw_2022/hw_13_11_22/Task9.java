package homeworks.dmytro_k.hw_2022.hw_13_11_22;

/*9) Имеется строка, к примеру "Hello my young dog".
   Необходимо перевернуть строку в след. формате "godgn uo yymol leH".
   То есть после реверса длина слова равнялась изначальной длине.

    public static void main(String[] args) {

           String str = "Don't speak my English";

           String replacedStr = str.replaceAll(" ", "");

           String s = new StringBuilder(replacedStr).reverse().toString();
           String[] words = str.split(" ");

           StringBuilder builder = new StringBuilder();

           for (String word : words) {
               int length = word.length();
               String value = s.substring(0, length);

               builder.append(value).append(" ");
               s = s.substring(length);
           }
           System.out.println(builder);

       }*/

public class Task9 {

    public static void main(String[] args) {

        String myStr1 = "12345 6789 123 45 6 7 8 9";

        System.out.println(myStr1);

        String[] words = myStr1.split(" ");

        String withOutSpase = myStr1.replace(" ", "");

        String revers = new StringBuilder(withOutSpase).reverse().toString();

        for (String word : words) {

            int lengthWord = word.length();

            String reverseValue = revers.substring(0, lengthWord);

            revers = revers.substring(lengthWord);

            System.out.print(reverseValue + " ");
        }
    }
}
