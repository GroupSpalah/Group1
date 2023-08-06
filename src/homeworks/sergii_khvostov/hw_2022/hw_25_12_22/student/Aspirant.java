package homeworks.sergii_khvostov.hw_2022.hw_25_12_22.student;

public class Aspirant extends Student {
    private String scientificWork;

    public Aspirant(String firstName, String lastName, String group,
                    double averageMark, String scientificWork) {
        super(firstName, lastName, group, averageMark);
        this.scientificWork = scientificWork;
    }

    @Override
    public double getScholarship(double averageMark) {
        double result;
        if (getAverageMark() == 5) {
            result = 200;
        } else {
            result = 180;
        }
        return result;
    }
}
