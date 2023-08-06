package homeworks.sergii_khvostov.hw_2023.hw_03_03_23.task2;

public class Service {
    public static void main(String[] args) {
        try {
            Student student1 = new Student("Jim Hook", "M12", 85);
            student1.gradeCheck();

            Student student2 = new Student("John Bon", "M13", 95);
            student2.gradeCheck();

        } catch (SyntaxStudentException e) {
            System.out.println(e.getMessage());
        }

    }
}
