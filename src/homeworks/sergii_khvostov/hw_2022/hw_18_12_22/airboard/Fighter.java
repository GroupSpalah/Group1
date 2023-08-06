package homeworks.sergii_khvostov.hw_2022.hw_18_12_22.airboard;

public class Fighter extends Airboard {
    public Fighter(String brand, String model, int maxSpeed, int maxHeight) {
        super(brand, model, maxSpeed, maxHeight);
    }

    @Override
    public int price() {
        return super.price() * 3;
    }
}
