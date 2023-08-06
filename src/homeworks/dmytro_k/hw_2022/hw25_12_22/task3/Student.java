package homeworks.dmytro_k.hw_2022.hw25_12_22.task3;

/*   2. Создайте пример наследования, реализуйте класс Student и класс Aspirant, аспирант отличается
   от студента наличием некой научной работы.++

   а) Класс Student содержит переменные: String firstName, lastName, group.
   А также, double averageMark, содержащую среднюю оценку.++

   б) Создать переменную типа Student, которая ссылается на объект типа Aspirant.++

   в) Создать метод getScholarship() для класса Student, который возвращает сумму стипендии.++
   Если средняя оценка студента равна 5, то сумма 100 грн, иначе 80.++
   Переопределить этот метод в классе Aspirant.
   Если средняя оценка аспиранта равна 5, то сумма 200 грн, иначе 180.++

   г) Создать массив типа Student, содержащий объекты класса Student и Aspirant. Вызвать метод
   getScholarship() для каждого элемента массива.++*/

public class Student {

    private String firstName;
    private String lastName;
    private String group;
    protected double averageMark;

    public Student(String firstName, String lastName, String group, double averageMark) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.group = group;
        this.averageMark = averageMark;
    }

    public double getScholarship(){

        if (averageMark == 5){
             return 100.0;
        }else {
            return 80.0;
        }
    }
}
