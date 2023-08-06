package homeworks.dmytro_m.hw_2022.hw_18_12_2022;

import java.io.*;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Regex1 {
    public static void main(String[] args) {

        String text = "sf  spgdk kn las 5 ksmf 4e fk92 wd ak mw4 tkoi";
        findSumString(text);

    }

    public static void findSumString (String str) {
        Pattern pattern = Pattern.compile("[0-9]+");
        Matcher matcher = pattern.matcher(str);

        int sum = 0;
        while(matcher.find()) {
            sum += Integer.parseInt(matcher.group());
        }
        System.out.println(sum);
    }
}
//1) В строке содержутся слова и числа. Необходмо выделить числа и посчитать их сумму.

