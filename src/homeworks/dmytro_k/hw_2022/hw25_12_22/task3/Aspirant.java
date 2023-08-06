package homeworks.dmytro_k.hw_2022.hw25_12_22.task3;

public class Aspirant extends Student {

    boolean scientificWork;

    public Aspirant(String firstName, String lastName, String group, double averageMark, boolean scientificWork) {
        super(firstName, lastName, group, averageMark);
        this.scientificWork = scientificWork;
    }

    @Override
    public double getScholarship() {

        if (averageMark == 5) {
            return 200.0;
        } else {
            return 180.0;
        }
    }
}
