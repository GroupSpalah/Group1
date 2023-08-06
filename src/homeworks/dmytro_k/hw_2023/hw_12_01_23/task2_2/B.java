package homeworks.dmytro_k.hw_2023.hw_12_01_23.task2_2;

public class B extends Student implements Marks{

    public B(int mark1, int mark2, int mark3, int mark4) {
        super(mark1, mark2, mark3, mark4);
    }

    @Override
    public double getPercentage() {
        return (getMark1() + getMark2() + getMark3() + getMark4()) / 4.0;
    }
}
