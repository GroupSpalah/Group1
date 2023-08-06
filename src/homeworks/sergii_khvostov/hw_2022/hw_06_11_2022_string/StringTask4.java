package homeworks.sergii_khvostov.hw_2022.hw_06_11_2022_string;

//@Khvostov

/*Объявите две локальные переменные myStr1 и myStr2 типа String и присвойте
  первой строке значение «Cartoon» и «Tomcat» для второго.
  Напишите код для отображения всех букв, которые присутствуют в первом слове,
  но отсутствуют во втором.*/

public class StringTask4 {
    public static void main(String[] args) {

        String myStr1 = "Cartoon".toLowerCase();
        String myStr2 = "Tomcat".toLowerCase();

        for (int i = 0; i < myStr1.length(); i++) {
            String charAsString = String.valueOf(myStr1.charAt(i));

            if (!myStr2.contains(charAsString)) {
                System.out.print(charAsString + "\t");
            }
        }
    }
}
