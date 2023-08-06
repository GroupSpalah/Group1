package homeworks.dmytro_k.hw_2022.hw_02_10_22.student;

/* Создать класс Student c полями: кол-во проучившихся лет, возраст, размер стипендии.
Создать методы для изменения и получения полей класса, а также метод вывода в консоль полей.
Организовать проверку на некорректные значения полей.
Создать несколько объектов класса, изменить поля и вывести в консоль.*/

public class Student {

    private int trainingPeriod;
    private int age;
    private float scholarshipAmount;

    public Student(int trainingPeriod, int age, float scholarshipAmount) {

        this.trainingPeriod = trainingPeriod;
        this.age = age;
        this.scholarshipAmount = scholarshipAmount;

        checkForInvalidValues(trainingPeriod, age, scholarshipAmount);
    }

    public int getTrainingPeriod() {
        return trainingPeriod;
    }

    public void setTrainingPeriod(int trainingPeriod) {
        this.trainingPeriod = trainingPeriod;
        checkForInvalidValues(trainingPeriod, 0, 0);
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
        checkForInvalidValues(0, age, 0);
    }

    public float getScholarshipAmount() {
        return scholarshipAmount;
    }

    public void setScholarshipAmount(float scholarshipAmount) {
        this.scholarshipAmount = scholarshipAmount;
        checkForInvalidValues(0, 0, scholarshipAmount);
    }

    private void checkForInvalidValues(int trainingPeriod, int age, float scholarshipAmount) {

        if (trainingPeriod < 0 || trainingPeriod > 10) {
            this.trainingPeriod = 0;
        }
        if (age < 0 || age > 100) {
            this.age = 0;
        }
        if (scholarshipAmount < 0 || scholarshipAmount > 2000) {
            this.scholarshipAmount = 0;
        }
    }

    public void printInfo() {

        if (trainingPeriod == 0) {
            System.out.println("Incorrect training period.");
        }
        if (age == 0) {
            System.out.println("Age is incorrect.");
        }
        if (scholarshipAmount == 0) {
            System.out.println("Incorrect scholarship amount.");
        }
        System.out.println("Training period: " + trainingPeriod +
                "\nAge: " + age +
                "\nScholarship amount: " + scholarshipAmount +
                "\n-----------");
    }
}



