package homeworks.dmytro_k.hw_2023.hw_03_03_23.task2;

public class Student {

    private String name;
    private int grade;

    public Student(String name, int grade) {
        this.name = name;
        this.grade = grade;
    }

    public void gradeCheck() {
        if (grade > 90) {
            try {
                throw new SyntaxStudentException("You are an exceptionally awesome student");
            } catch (SyntaxStudentException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("You are a great student");
        }
    }
}
