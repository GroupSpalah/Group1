package homeworks.sergii_khvostov.hw_2022.hw_27_11_22;

//@Khvostov

public class DataProcessing {
    public void print(Student student) {
        System.out.println("Name: " + student.getFirstName() + "\n" +
                "Surname: " + student.getLastName() + "\n" +
                "Gender: " + student.getGender() + "\n" +
                "Age: " + student.getAge() + "\n" +
                "Group: " + student.getGroup().getTitleGroup() + "\n" +
                "University: " + student.getUniversity().getTitleUniversity());
    }

    public boolean compareGroup(Student student1, Student student2) {
        String group1 = student1.getGroup().getTitleGroup();
        String group2 = student2.getGroup().getTitleGroup();

        return group1.equals(group2);
    }

    public boolean compareUniversity(Student student1, Student student2) {
        String university1 = student1.getUniversity().getTitleUniversity();
        String university2 = student2.getUniversity().getTitleUniversity();

        return university1.equals(university2);
    }

    public boolean compareLastName(Student student1, Student student2) {
        String lastName1 = student1.getLastName();
        String lastName2 = student2.getLastName();

        return lastName1.equals(lastName2);
    }
}
