package homeworks.dmytro_m.hw_2022.hw_11_12_2022;

import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Pattern;

public class RegexTest4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        String number = "(" + str.substring(0,3) + ")" + str.substring(3,6) + "-" + str.substring(6,8)+
                    "-" + str.substring(str.length()-2);
        
        System.out.println(number);
        String template = "\\((095|097|073|067|099|063|066)\\)" +
                "+\\d{3}-\\d{2}-\\d{2}";

        boolean bool = Pattern.matches(template, number);
        String operator = number.substring(1, 4);

        if(bool) {
            switch (operator) {
                case "095", "099","066"  -> System.out.println("MTC");
                case "067", "097", "068" -> System.out.println("Киевстар");
                case "073", "063", "093" -> System.out.println("Лайф");
            }
        } else {
            System.out.println("error");
        }
    }
}
//        4) Пользователь вводит телефон в формате (ххх)ххх-хх-хх.
//        (ххх) должен быть таким: (095), (097), (073), (067), (099), (063).
//        Проверить, чтобы 10 - ый номер был в формате (xxx)ххх-хх-хх.
//        Если пользователь вводит номер начинающийся на(095) или (099) ххх-хх-хх, выводить в консоль
//        "Пользователь имеет МТС номер",
//        на(097) или (067) ххх-хх-хх, выводить в консоль "Пользователь имеет Киевстар номер",
//        на(073) или (063) ххх-хх-хх, выводить в консоль "Пользователь имеет Лайф номер".
//
//        Код оператора надо вычленить с помощью метода String split
//
//        (\\(095\\)|\\(099\\)|\\(097\\)|\\(067\\)|\\(063\\)|\\(073\\))