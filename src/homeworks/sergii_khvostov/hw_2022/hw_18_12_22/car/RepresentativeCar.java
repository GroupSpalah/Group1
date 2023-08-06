package homeworks.sergii_khvostov.hw_2022.hw_18_12_22.car;

public class RepresentativeCar extends Car {

    public RepresentativeCar(String title, int maxSpeed) {
        super(title, maxSpeed);
    }

    @Override
    public int price() {
        return getMaxSpeed() * 250;
    }

    @Override
    public void updateModel() {
        setMaxSpeed(getMaxSpeed() + 5);
    }
}
