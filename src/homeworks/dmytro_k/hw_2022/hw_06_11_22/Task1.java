package homeworks.dmytro_k.hw_2022.hw_06_11_22;

/**** Вывести текст, составленный из последних букв всех слов., charAt, split
 *** Дано слово, состоящее из четного числа букв. Вывести на экран его первую половину, не используя оператор цикла., substring
 *** Count chars of strings placed in the even positions in the given array. For example: array = {"Hello", "world", "from", "array"}
 the result will be 9: "Hello" length is 5 and "from" length is 4 "world" and "array" are skipped because they are on the odd positions.
 *** Declare two local variables myStr1 and myStr2 of String type and assign a value “Cartoon” for first string
 and ”Tomcat” for second.
 Write code to display all of the letters, which are present in the first word, but absent in the second.
 *** В заданной строке удалить первый символ., substring
 *** В заданной строке посчитать количество точек и запятых., charAt*/

public class Task1 {

    public static void main(String[] args) {

        String someString = "you can write something here";

        String[] words = someString.split(" ");

        for (String word : words) {
            System.out.print(word.charAt(word.length() - 1) + "\t");
        }
    }
}
