package homeworks.sergii_khvostov.hw_2022.hw_25_12_22.student;

public class StudentService {
    public static void main(String[] args) {
        Student student = new Student();

        Student student1 =
                new Student("Alex", "Koh",
                        "M1", 4.8);
        Aspirant aspirant =
                new Aspirant("Jim", "Beh",
                        "C2", 4, "FGH");
        Student student2 =
                new Aspirant("John", "Nok",
                        "C3", 5, "KLJ");

        Student[] arr = new Student[]{student1, aspirant, student2};

        for (int i = 0; i < arr.length; i++) {
            String res = String.valueOf(arr[i].
                    getScholarship(student.getAverageMark()));
            System.out.println(res);
        }
    }
}
