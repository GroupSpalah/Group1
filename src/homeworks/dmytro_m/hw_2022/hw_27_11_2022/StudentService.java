package homeworks.dmytro_m.hw_2022.hw_27_11_2022;

public class StudentService {

    public void infoStudent(Student student1) {
        String infoStudent1 = student1.getUniversity().toString() + student1.getGroup().toString();
        System.out.println(student1.getFirstName() + " " + student1.getLastName() + ": " + infoStudent1);
    }

    public boolean compareGroup(Student student1, Student student2) {
        boolean compareName = student1.getGroup().getGroupName().equals(student2.getGroup().getGroupName());
        boolean compareNumber = student1.getGroup().getNumberStudents() == student2.getGroup().getNumberStudents();
        return compareNumber && compareName;
    }

    public boolean compareUniversity(Student student1, Student student2) {
        boolean compareName = student1.getUniversity().getUniversityName().equals(student2.getUniversity().getUniversityName());
        boolean compareGroups = student1.getUniversity().getNumberGroups() == student2.getUniversity().getNumberGroups();
        boolean compareDate = student1.getUniversity().getFoundingDate() == student2.getUniversity().getFoundingDate() ;
        return compareName && compareGroups && compareDate;
    }

    public boolean compareLastName (Student student1, Student student2) {
        return student1.getLastName().equals(student2.getFirstName());
    }
}

//        Создать методы позволяющие:
//        - вывести данные о студенте с учетом данных об университете и группе.
//        - проверять группы на одинаковость у двух студентов.
//        - проверять университеты на одинаковость у двух студентов.
//        - проверять однофамильцев у двух студентов.