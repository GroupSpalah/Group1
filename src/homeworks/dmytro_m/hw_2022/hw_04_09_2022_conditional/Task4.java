package homeworks.dmytro_m.hw_2022.hw_04_09_2022_conditional;

public class Task4 {
    public static void main(String[] args) {
//        /*Switch:
//   number = 3;        number = 10;    number = 15;
//   output: "FIN".     output: "RA".   output: "FINRA".*/
        int num = 13;
        String result = switch (num) {
            case 3 -> "FIN";
            case 10 -> "RA";
            case 15 -> "FINRA";
            default -> "ERROR";
        };
        System.out.println(result);

        int num2 = 3;
        String result2;
        switch (num2) {
            case 3:
                result2 = "FIN";
                break;
            case 10:
                result2  ="RA";
                break;
            case 15:
                result2 = "FINRA";
                break;
            default:
                result2 = "ERROR";
                break;
        }
        System.out.println(result2);

    }
}
