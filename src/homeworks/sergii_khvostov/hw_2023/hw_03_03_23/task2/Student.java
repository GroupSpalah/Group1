package homeworks.sergii_khvostov.hw_2023.hw_03_03_23.task2;

/*Create a custom Exception class
 In main class create a method that will check students grade
 if students grade is >90 then exception should be thrown
 if students grade is below 90 print "You are a great student"
 In main method calls method gradeCheck and handle an Exception
 **Expected Output:**
   ```
 SyntaxStudentException: You are an exceptionally awesome student
   ```*/

public class Student {

    private String name;
    private String group;
    private int grade;

    public Student(String name, String group, int grade) {
        this.name = name;
        this.group = group;
        this.grade = grade;
    }

    public void gradeCheck() throws SyntaxStudentException {
        if (grade > 90) {
            throw new SyntaxStudentException("You are a wonderful student");
        } else {
            System.out.println("You are great student");
        }
    }
}
