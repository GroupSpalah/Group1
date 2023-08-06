package homeworks.sergii_khvostov.hw_2023.hw_12_01_23.task3;

/*We have to calculate the average of marks
obtained in three subjects by student A and by
student B. Create class 'Marks' with an abstract
method 'getPercentage' that will be returning
the average percentage of marks. Provide
implementation of abstract method in classes
'A' and 'B'. The constructor of student A takes the
marks in three subjects as its parameters and
the marks in four subjects as its parameters for
student B. Test your code*/

public abstract class Marks {
    abstract double getPercentage(double... mark);

}
