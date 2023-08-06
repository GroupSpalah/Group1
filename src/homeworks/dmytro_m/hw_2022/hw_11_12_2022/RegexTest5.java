package homeworks.dmytro_m.hw_2022.hw_11_12_2022;

import java.util.regex.Pattern;

public class RegexTest5 {

    public static void main(String[] args) {
//        String numberCar = "A245ZZ";
//        String template = "[ABCEHKMOPTXY]\\d{3}[ABCEHKMOPTXY]{2}";
//
//        if (Pattern.matches(template, numberCar)) {
//            System.out.println(100);
//        } else {
//            checkInvalidChars(numberCar);
//        }
        RegexTest5 regex = new RegexTest5("A245ZZ");
        regex.numberMatch(regex.getNumberCar());
    }



    private String numberCar;

    public RegexTest5(String numberCar) {
        this.numberCar = numberCar;
    }

    public String getNumberCar() {
        return numberCar;
    }

    public void setNumberCar(String numberCar) {
        this.numberCar = numberCar;
    }

    public void numberMatch(String numberCar) {
        String template = "[ABCEHKMOPTXY]\\d{3}[ABCEHKMOPTXY]{2}";

        if (Pattern.matches(template, numberCar)) {
            System.out.println(100);
        } else {
            checkInvalidChars(numberCar);
        }
    }

    public void checkInvalidChars(String numberCar) {
        int count = 3;
        String[] strArr = numberCar.split("");
        String str = "ABCEHKMOPTXY";
        String[] arr = str.split("");

        for (String s : arr) {

            if (strArr[0].equals(s)) {
                count--;
            }
            if (strArr[strArr.length - 2].equals(s)) {
                count--;
            }
            if (strArr[strArr.length - 1].equals(s)) {
                count--;
            }

        }
        System.out.println("In the number of wrong characters " + count);
    }

}
