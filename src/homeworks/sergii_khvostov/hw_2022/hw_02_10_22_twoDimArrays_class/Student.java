package homeworks.sergii_khvostov.hw_2022.hw_02_10_22_twoDimArrays_class;

//@Khvostov

/*Создать класс Student c полями: кол-во проучившихся лет, возраст, размер стипендии.
  Создать методы для изменения и получения полей класса,
  а также метод вывода в консоль полей.
  Организовать проверку на некорректные значения полей.
  Создать несколько объектов класса, изменить поля и вывести в консоль.*/

public class Student {
    private int numberYearsStudy;
    private int age;
    private double scholarshipAmount;

    public Student(int newNumberYearsStudy, int newAge, double newScholarshipAmount) {

        if (newNumberYearsStudy <= 0) {
            numberYearsStudy = 8888;
        } else {
            numberYearsStudy = newNumberYearsStudy;
        }
        if (newAge <= 0 || newAge > 99) {
            age = 8888;
        } else {
            age = newAge;
        }
        if (newScholarshipAmount < 0) {
            scholarshipAmount = 8888;
        } else {
            scholarshipAmount = newScholarshipAmount;
        }
    }

    public int getNumberYearsStudy() {
        return numberYearsStudy;
    }

    public void setNumberYearsStudy(int newNumberYearsStudy) {
        if (newNumberYearsStudy <= 0) {
            numberYearsStudy = 8888;
        } else {
            numberYearsStudy = newNumberYearsStudy;
        }
    }

    public int getAge() {
        return age;
    }

    public void setAge(int newAge) {
        if (newAge <= 0 || newAge > 99) {
            age = 8888;
        } else {
            age = newAge;
        }
    }

    public double getScholarshipAmount() {
        return scholarshipAmount;
    }

    public void setScholarshipAmount(double newScholarshipAmount) {
        if (newScholarshipAmount < 0) {
            scholarshipAmount = 8888;
        } else {
            scholarshipAmount = newScholarshipAmount;
        }
    }

    public void print() {
        System.out.println("Number of years of study: " + getNumberYearsStudy() + " | " +
                "Age: " + getAge() + " | " +
                "Scholarship Amount: " + getScholarshipAmount());
    }

    public static void main(String[] args) {

        Student jack = new Student(5, 25,
                500);
        Student jim = new Student(4, 28,
                500);
        Student bob = new Student(3, 23,
                300);

        jack.setNumberYearsStudy(6);
        jack.setAge(27);
        jack.setScholarshipAmount(600);

        jim.setNumberYearsStudy(5);
        jim.setAge(26);
        jim.setScholarshipAmount(400);

        bob.setNumberYearsStudy(4);
        bob.setAge(24);
        bob.setScholarshipAmount(200);

        System.out.print("Student Jack - ");
        jack.print();
        System.out.print("Student Jim - ");
        jim.print();
        System.out.print("Student Bob - ");
        bob.print();
    }
}

