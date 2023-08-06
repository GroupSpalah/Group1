package homeworks.dmytro_m.hw_2022.hw_06_11_2022;

public class Test1 {
    public static void main(String[] args) {

        String str = "Write code to display all of the letters " +
                "which are present in the first word but absent in the second";
        displaysLastLetters(str);
    }

    public static void displaysLastLetters(String str) {
        String [] array = str.split(" ");

        for (int i = 0; i < array.length; i++) {
            char c = array[i].charAt(array[i].length()-1);
            System.out.print(c);
        }

        System.out.println();
    }
}
//Вывести текст, составленный из последних букв всех слов., charAt, split