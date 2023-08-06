package homeworks.dmytro_k.hw_2022.hw_27_11_22;

/*
 * @author Dmytro Koliesnik
 * @version 2.0
 * @since   2022-12-04
 */

/*Создать несколько студентов:
- с одинаковой группой и университетом.++
- с разными группами в университете.++*/

import lessons.learn_class.man_position.Gender;

public class StudentTest {

    public static void main(String[] args) {

         StudentService studentService = new StudentService();

         Group group1 = new Group("1",15);
         Group group2 = new Group("2",25);
         Group group3 = new Group("3",36);
         Group group4 = new Group("4",10);

         University UIPA = new University("UIPA", 1958);
         University KPI = new University("KPI",1885);

         Student student1 = new Student(
                "Dmytro",
                "Koliesnik",
                Gender.MALE,
                22,
                group1,
                UIPA);

         Student student2 = new Student(
                "Vasyl",
                "Bogun",
                Gender.MALE,
                21,
                group1,
                UIPA);

         Student student3 = new Student(
                "Vladyslav",
                "Bogun",
                Gender.MALE,
                22,
                group2,
                KPI);

         Student student4 = new Student(
                "Dmytro",
                "Derevianko",
                Gender.MALE,
                23,
                group3,
                UIPA);

         Student student5 = new Student(
                "Svetlana",
                "Parhomenko",
                Gender.FEMALE,
                21,
                group4,
                UIPA);

         student1.printInfo();

         System.out.println();

         studentService.output(studentService.compareLastNames(student2,student3));

         studentService.output(studentService.compareGroup(student4,student5));

         studentService.output(studentService.compareUniversity(student1,student3));
    }
}