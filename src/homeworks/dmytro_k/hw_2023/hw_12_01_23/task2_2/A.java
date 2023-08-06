package homeworks.dmytro_k.hw_2023.hw_12_01_23.task2_2;

public class A extends Student implements Marks {

    public A(int mark1, int mark2, int mark3) {
        super(mark1, mark2, mark3);
    }

    @Override
    public double getPercentage() {
        return (getMark1() + getMark2() + getMark3()) / 3.0;
    }
}
