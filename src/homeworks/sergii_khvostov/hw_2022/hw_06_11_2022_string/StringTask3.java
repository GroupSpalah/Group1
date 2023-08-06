package homeworks.sergii_khvostov.hw_2022.hw_06_11_2022_string;

//@Khvostov

/*Подсчет символов строк, размещенных на четных позициях в заданном массиве.
  Например: array = {"Hello", "world", "from", "array"} результатом будет 9:
  длина "Hello" равна 5, а длина "from" равна 4 "world" и "array" пропущены,
  потому что они находятся на нечетных позициях.*/

public class StringTask3 {
    public static void main(String[] args) {

        String str = "Hello world from array";

        String[] words = str.split(" ");

        int sum = 0;

        for (int i = 0; i < words.length; i++) {
            if (i % 2 == 0) {
                sum += words[i].length();
            }
        }
        System.out.println(sum);
    }
}
