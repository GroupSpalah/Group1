package homeworks.dmytro_m.hw_2022.home_work_02_10_2022;

public class Student {
    private int year;
    private int age;
    private int amount;

    public Student(int year1, int age1, int amount1) {
        if (0 >= year1) {
            year = 1;
        } else {
            year = year1;
        }

        if (age1 >= 17 && age1 <= 70) {
            age = age1;
        } else {
            age = 18;
        }

        if (amount1 <= 0 || amount1 > 10000) {
            amount = 500;
        } else {
            amount = amount1;
        }
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year1) {
        if (year1 <= 0) {
            return;
        } else {
            year = year1;
        }
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age1) {
        if (age1 >= 17 && age1 <= 70) {
            age = age1;
        } else {
            return;
        }
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount1) {
        if (amount1 < 0 || amount1 > 10000) {
            return;
        } else {
            amount = amount1;
        }
    }

    public String toString() {
        return "Student{" +
                "year=" + year +
                ", age=" + age +
                ", amount=" + amount +
                '}';
    }

    public static void main(String[] args) {
        Student s1 = new Student(3, 32, 3500);
        System.out.println(s1);
        s1.setAge(24);
        int num = s1.getAge();
        System.out.println(num);
        Student s2 = new Student(0, 0, 0);
        System.out.println(s2);
    }
}

//    Создать класс Student c полями: кол-во проучившихся лет, возраст, размер стипендии.
//        Создать методы для изменения и получения полей класса, а также метод вывода в консоль полей.
//        Организовать проверку на некорректные значения полей.
//        Создать несколько объектов класса, изменить поля и вывести в консоль.