package homeworks.dmytro_m.hw_2023.hw_03_03_2023.task2;

public class Student {
    private String name;
    private int grade;

    public Student(String name, int grade) {
        this.name = name;
        this.grade = grade;
    }

    public String getName() {
        return name;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public String gradeCheck() {
        if (this.grade >= 90) {
            try {
                throw new MyException();
            } catch (MyException e) {
                return "You are a wonderful student";
            }
        } else if (this.grade < 90) {
            return "You are great student";
        } else {
            return "Error";
        }
    }
}
//
//        2) Создайте собственный класс исключений
//
//        В основном классе создайте метод, который будет проверять оценки учащихся.
//
//        если оценка учащегося> 90, тогда должно быть выбрано исключение
//
//        если оценка ученика ниже 90, напечатайте «Вы отличный ученик»
//
//        В основном методе вызывается методgradeCheck и обрабатывается исключение
//
//        **Ожидаемый результат:**
//
//        ```
//        SyntaxStudentException: Вы исключительно замечательный ученик
//        ```
//