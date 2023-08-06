package homeworks.sergii_khvostov.hw_2022.hw_27_11_22;

//@Khvostov

public class StudentTest {
    public static void main(String[] args) {
        DataProcessing dataProcessing = new DataProcessing();

        Student student1 = new Student("Jim", "Berry",
                "male", 25, new Group("A", 20),
                new University("Dallas", 10,
                        "10/10/99"));

        Student student2 = new Student("Bob", "Werry",
                "male", 27, new Group("B", 22),
                new University("Dallas", 15,
                        "15/11/99"));

        Student student3 = new Student("Mike", "Cook",
                "male", 27, new Group("A",
                21), new University("Dallas",
                21, "05/09/01"));

        boolean resultUniversity =
                dataProcessing.compareUniversity(student1, student2);

        boolean resultGroup =
                dataProcessing.compareGroup(student1, student3);

        boolean resultLastName =
                dataProcessing.compareLastName(student1, student2);

        dataProcessing.print(student3);

    }
}
