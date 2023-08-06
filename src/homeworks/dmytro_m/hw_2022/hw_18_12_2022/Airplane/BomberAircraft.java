package homeworks.dmytro_m.hw_2022.hw_18_12_2022.Airplane;

public class BomberAircraft extends Airplane{

    public BomberAircraft(String brand, String model, double maxSpeed, int maxHeight) {
        super(brand, model, maxSpeed, maxHeight);
    }



    @Override
    public double returnPrice() {
        return super.returnPrice() * 2;
    }

}
