package homeworks.dmytro_k.hw_2022.hw_02_10_22.student;

public class StudentsList {

    public static void main(String[] args) {

        Student student1 = new Student(1, 19, 1500);

        Student student2 = new Student(3, 22, 5000);

        Student student3 = new Student(5, 110, 2000);

        Student student4 = new Student(2, 23, 3000);

        student1.setAge(21);

        System.out.println("Student 1.");
        student1.printInfo();

        student2.setTrainingPeriod(-4);

        System.out.println("Student 2.");
        student2.printInfo();

        student3.setScholarshipAmount(1750);

        System.out.println("Student 3.");
        student3.printInfo();

        System.out.println("Student 4.");
        student4.printInfo();

/*        student4.setScholarshipAmount(1500);
        student4.checkForInvalidValues(student4.getTrainingPeriod(),
                student4.getAge(), student4.getScholarshipAmount());
        student4.printInfo();*/
    }
}
