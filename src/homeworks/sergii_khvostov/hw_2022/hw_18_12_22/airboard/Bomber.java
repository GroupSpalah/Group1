package homeworks.sergii_khvostov.hw_2022.hw_18_12_22.airboard;

public class Bomber extends Airboard {
    public Bomber(String brand, String model, int maxSpeed, int maxHeight) {
        super(brand, model, maxSpeed, maxHeight);
    }

    @Override
    public int price() {
        return super.price() * 2;
    }
}
