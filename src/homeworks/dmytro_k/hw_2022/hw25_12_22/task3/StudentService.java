package homeworks.dmytro_k.hw_2022.hw25_12_22.task3;

/* б) Создать переменную типа Student, которая ссылается на объект типа Aspirant.
   г) Создать массив типа Student, содержащий объекты класса Student и Aspirant.
   Вызвать метод getScholarship() для каждого элемента массива.*/

public class StudentService {

    public static void main(String[] args) {

        Student aspirant1 = new Aspirant("FN", "LN", "123", 5, true);

        Student student1 = new Student("FN1", "LN1", "123", 5);
        Student student2 = new Student("FN2", "LN2", "123", 3);
        Student student3 = new Student("FN3", "LN3", "123", 4);
        Aspirant aspirant2 = new Aspirant("FN4", "LN4", "123", 5, true);
        Student[] studentList = new Student[]{aspirant1, student1, student2, student3, aspirant2};

        for (Student student : studentList) {
            System.out.println(student.getScholarship() + " грн.");
        }
    }
}

