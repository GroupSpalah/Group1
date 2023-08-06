package homeworks.dmytro_k.hw_2022.hw_27_11_22;

/*
 * @author Dmytro Koliesnik
 * @version 2.0
 * @since   2022-12-04
 */

/*Создать класс Student c полями ++имя, ++пол, ++фамилия, ++возраст,
++Group(отдельный класс), ++University(отдельный класс).*/

import lessons.learn_class.man_position.Gender;

public class Student {

    private String firstName;
    private String lastName;
    private Gender gender;
    private int age;
    public Group group;
    public University university;

    public Student(String firstName, String lastName, Gender gender, int age, Group group, University university) {
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

    public String getLastName() {
        return lastName;
    }

    public Gender getGender() {
        return gender;
    }

    public int getAge() {
        return age;
    }

    public Group getGroup() {
        return group;
    }

    public University getUniversity() {
        return university;
    }

    public void printInfo(){
        System.out.print(
                "name: " + getFirstName() + "\n"
              + "last name: " + getLastName() + "\n"
              + "gender: " + getGender() + "\n"
              + "age: " + getAge() + "\n"
              + "group: " + group.getGroupName() + "\n"
              + "university: " + university.getUniversityName());
    }
}
