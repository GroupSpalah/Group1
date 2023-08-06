package homeworks.sergii_khvostov.hw_2023.hw_12_01_23.task3;

public class MarkService {
    public static void main(String[] args) {

        StudentA studentA = new StudentA(5,5,5);
        System.out.println(studentA.getPercentage());

        StudentB studentB = new StudentB(5, 5, 5, 5);
        System.out.println(studentB.getPercentage());
    }
}
