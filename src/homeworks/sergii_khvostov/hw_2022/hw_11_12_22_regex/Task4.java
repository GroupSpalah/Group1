package homeworks.sergii_khvostov.hw_2022.hw_11_12_22_regex;

/*Пользователь вводит телефон в формате (ххх)ххх-хх-хх.
   (ххх) должен быть таким: (095), (097), (073), (067), (099), (063).
   Проверить, чтобы 10 - ый номер был в формате (xxx)ххх-хх-хх.
   Если пользователь вводит номер начинающийся на(095) или (099) ххх-хх-хх,
   выводить в консоль "Пользователь имеет МТС номер",
   на(097) или (067) ххх-хх-хх, выводить в консоль
   "Пользователь имеет Киев стар номер",
   на(073) или (063) ххх-хх-хх, выводить в консоль
   "Пользователь имеет Лайф номер".
    Код оператора надо вычленить с помощью метода String split*/

import java.util.regex.Pattern;

public class Task4 {
    private String phoneNumber = "(099)555-65-95";

    public static void main(String[] args) {
        Task4 phone = new Task4();

        phone.validFormatNumber();
        phone.checkIndexOperator();
    }

    public boolean validFormatNumber() {
        Task4 phone = new Task4();

        String template = "\\((095|097|073|067|099|063)\\)\\d{3}-{1}" +
                "\\d{2}-{1}\\d{2}";

        return Pattern.matches(template, phone.phoneNumber);
    }

    public void checkIndexOperator() {
        Task4 phone = new Task4();

        String operatorCode = phone.phoneNumber.substring(1, 4);

        if (phone.validFormatNumber()) {
            switch (operatorCode) {
                case "095", "099" -> System.out.println("Пользователь является абонентом МТС");
                case "063", "073" -> System.out.println("Пользователь является абонентом Лайф");
                case "097", "067" -> System.out.println("Пользователь является абонентом Киевстар");
                default -> System.out.println("Error enter");
            }
        } else System.out.println("Error enter");
    }
}
