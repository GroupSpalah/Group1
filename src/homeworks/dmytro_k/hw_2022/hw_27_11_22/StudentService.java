package homeworks.dmytro_k.hw_2022.hw_27_11_22;

/*
 * @author Dmytro Koliesnik
 * @version 2.0
 * @since   2022-12-04
 */

/* - проверять группы на одинаковость у двух студентов.++
 - проверять университеты на одинаковость у двух студентов.++
 - проверять однофамильцев у двух студентов.++*/

public class StudentService {

    public boolean compareGroup(Student student1, Student student2) {

        String group1 = student1.getGroup().getGroupName();
        String group2 = student2.getGroup().getGroupName();

        return group1.equals(group2);
    }

    public boolean compareUniversity(Student student1, Student student2) {

        String university1 = student1.getUniversity().getUniversityName();
        String university2 = student2.getUniversity().getUniversityName();

        return university1.equals(university2);
    }

    public boolean compareLastNames(Student student1, Student student2) {

        String name1 = student1.getLastName();
        String name2 = student2.getLastName();

        return name1.equals(name2);
    }

    public void output(boolean x) {
        System.out.println(x ? "the same" : "not the same");
    }
}
