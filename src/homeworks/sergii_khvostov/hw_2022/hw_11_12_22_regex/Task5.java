package homeworks.sergii_khvostov.hw_2022.hw_11_12_22_regex;

/*Основная часть государственного регистрационного
  номера состоит из 6 символов: трёх букв и трёх цифр.
  Сначала идёт буква потом три цифры, а потом остальные две буквы,
  только такие символы: A, B, C, E, H, K, M, O, P, T, X, Y.
  Например P204BT - правильный номер, а X182YZ и ABC216 - нет.
  Задача выяснить какие из номеров соответствуют стандарту, а какие нет.
  Функция принимает строку - автомобильный номер. Функция возвращает 100,
  если номер правильный или количество букв в номере, если он не
  соответствует стандарту.*/

import java.util.regex.Pattern;

public class Task5 {

    private String carNumber;

    public String getCarNumber() {
        return carNumber;
    }

    public void setCarNumber(String carNumber) {
        this.carNumber = carNumber;
    }

    public static void main(String[] args) {
        Task5 number = new Task5();
        number.setCarNumber("H454YA");
        number.chekCarNumber(number.getCarNumber());

    }

    public int chekCarNumber(String carNumber) {

        String templateCarNumber = "[ABCEHKMOPTXY]{1}\\d{3}[ABCEHKMOPTXY]{2}";

        boolean compare = Pattern.matches(templateCarNumber, carNumber);

        String regexDigit = "\\d+";

        String[] words = carNumber.split(regexDigit);

        int result;
        int count = 0;
        String str;
        for (int i = 0; i < words.length; i++) {
            words = new String[]{words[0].concat(words[1])};
            str = words[i];
            for (int j = 0; j < str.length(); j++) {
                count++;
            }
        }

        if (compare) {
            result = 100;
        } else result = count;
        System.out.println(result);
        return result;
    }
}
