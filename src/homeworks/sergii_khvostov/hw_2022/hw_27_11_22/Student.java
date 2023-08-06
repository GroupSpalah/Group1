package homeworks.sergii_khvostov.hw_2022.hw_27_11_22;

//@Khvostov

/*Создать класс Student c полями имя, пол, фамилия, возраст,
Group(отдельный класс), University(отдельный класс).
Создать класс Group c полями название, кол-во студентов.
Создать класс University c полями название, кол-во групп, дата основания.

Создать несколько студентов:
- с одинаковой группой и университетом.
- с разными группами в университете.
Создать методы позволяющие:
 - вывести данные о студенте с учетом данных об университете и группе.
 - проверять группы на одинаковость у двух студентов.
 - проверять университеты на одинаковость у двух студентов.
 - проверять однофамильцев у двух студентов.*/

public class Student {
    private String firstName;
    private String lastName;
    private String gender;
    private int age;
    private Group group;
    private University university;

    public Student(String firstName, String lastName, String gender,
                   int age, Group group, University university) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.age = age;
        this.group = group;
        this.university = university;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public University getUniversity() {
        return university;
    }

    public void setUniversity(University university) {
        this.university = university;
    }
}
