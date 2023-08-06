package homeworks.sergii_khvostov.hw_2023.hw_12_01_23.task3;

public class StudentB extends Marks {

    double mark1;
    double mark2;
    double mark3;
    double mark4;

    public StudentB(double mark1, double mark2, double mark3, double mark4) {
        this.mark1 = mark1;
        this.mark2 = mark2;
        this.mark3 = mark3;
        this.mark4 = mark4;
    }

    @Override
    double getPercentage(double... mark) {
        return (mark1 + mark2 + mark3 + mark4) / 4;
    }
}
