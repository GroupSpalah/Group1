package homeworks.dmytro_m.hw_2022.hw_06_11_2022;

public class Test6 {

    public static void main(String[] args) {

        String[] array = {"Hello", "world", "from", "array"};
        countingCharactersOfStrings(array);
    }
    public static void countingCharactersOfStrings(String[] array) {
        int count = 0;
        for (int i = 0; i < array.length; i++) {
            if(i % 2 == 0) {
                count+=array[i].length();
            }
        }
        System.out.println(count);
    }
}
        /*Подсчет символов строк, размещенных на четных позициях в заданном массиве.
  Например: array = {"Hello", "world", "from", "array"} результатом будет 9:
  длина "Hello" равна 5, а длина "from" равна 4 "world" и "array" пропущены,
  потому что они находятся на нечетных позициях.*/
