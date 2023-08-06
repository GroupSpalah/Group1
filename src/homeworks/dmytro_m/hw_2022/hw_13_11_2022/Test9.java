package homeworks.dmytro_m.hw_2022.hw_13_11_2022;

public class Test9 {

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

    }
}
//        9) Имеется строка, к примеру "Hello my young dog".
//        Необходимо перевернуть строку в след. формате "godgn uo yymol leH".
//        То есть после реверса длина слова равнялась изначальной длине.
//
