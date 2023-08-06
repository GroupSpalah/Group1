package homeworks.dmytro_k.hw_2022.hw_11_12_22;

/*4) Пользователь вводит телефон в формате (ххх)ххх-хх-хх.
   (ххх) должен быть таким: (095), (097), (073), (067), (099), (063).
   Проверить, чтобы 10 - ый номер был в формате (xxx)ххх-хх-хх.
   Если пользователь вводит номер начинающийся на(095) или (099) ххх-хх-хх, выводить в консоль "Пользователь имеет МТС номер",
   на(097) или (067) ххх-хх-хх, выводить в консоль "Пользователь имеет Киевстар номер",
   на(073) или (063) ххх-хх-хх, выводить в консоль "Пользователь имеет Лайф номер".

   Код оператора надо вычленить с помощью метода String split

   (\\(095\\)|\\(099\\)|\\(097\\)|\\(067\\)|\\(063\\)|\\(073\\))*/

import java.util.regex.Pattern;

public class Task4 {

    public static void main(String[] args) {

        String phoneNumber = "(068)123-45-67";

        String template = "\\((067|098|068|097|063|093|073|066|099|050|095)\\)\\d{3}-\\d{2}-\\d{2}";

        boolean formatNumber = Pattern.matches(template, phoneNumber);

        if (formatNumber) {

            String[] codeAndNumber = phoneNumber.split("\\)");

            String code = codeAndNumber[0].substring(1);

            String[] kievstar = {"067", "098", "068", "097"};

            String[] life = {"063", "093", "073"};

            String[] vodafone = {"066", "099", "050", "095"};

            for (String kievstarCode : kievstar) {
                if (code.equals(kievstarCode)) {
                    System.out.println("Пользователь имеет Киевстар номер");
                    break;
                }
            }

            for (String lifeCode : life) {
                if (code.equals(lifeCode)) {
                    System.out.println("Пользователь имеет Лайф номер");
                    break;
                }
            }

            for (String vodafoneCode : vodafone) {
                if (code.equals(vodafoneCode)) {
                    System.out.println("Пользователь имеет Водафон номер");
                    break;
                }
            }

        } else {
            System.out.println("invalid number format");
        }
    }
}
