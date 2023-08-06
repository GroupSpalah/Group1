package homeworks.sergii_khvostov.hw_2022.hw_06_11_2022_string;

//@Khvostov

/*В заданной строке посчитать количество точек и запятых.*/

public class StringTask6 {
    public static void main(String[] args) {

        String str = "Hello, this is the task, for learn String class.";

        int countPoint = 0;
        int countComma = 0;

        for (int i = 0; i < str.length(); i++) {
            String charAsString = String.valueOf(str.charAt(i));

            if (charAsString.contains(",")) {
                ++countComma;
            }
            if (charAsString.contains(".")) {
                ++countPoint;
            }
        }
        System.out.println("Amount of comma: " + countComma + "\n"
                + "Amount of point: " + countPoint);
    }
}
