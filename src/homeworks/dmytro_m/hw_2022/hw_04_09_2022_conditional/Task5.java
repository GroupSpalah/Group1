package homeworks.dmytro_m.hw_2022.hw_04_09_2022_conditional;

public class Task5 {
    public static void main(String[] args) {
        //        5) Switch      'A': excellent
//        'B': great job
//        'C': good
//        'D': passed
//        'F': failed
//        other wise: invalid
//        Java 12 and older;
        char c = 'C';
        switch (c) {
            case 'A':
                System.out.println("excellent");
                break;
            case 'B':
                System.out.println("great job");
                break;
            case 'C':
                System.out.println("good");
                break;
            case 'D':
                System.out.println("passed");
                break;
            case 'F':
                System.out.println("failed");
            default:
                System.out.println("invalid");
                break;
        }
        String result = switch (c) {
            case 'A' -> "excellent";
            case 'B' -> "great job";
            case 'C' -> "good";
            case 'D'-> "passed";
            case 'F' -> "failed";
            default -> "invalid";
        };
        System.out.println(result);
    }
}
