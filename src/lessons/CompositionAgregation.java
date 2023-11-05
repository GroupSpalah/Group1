package lessons;

public class CompositionAgregation {
    public static void main(String[] args) {
        Phone phone = new Phone();

        ManAgr manAgr = new ManAgr(phone);//copy of phone

        manAgr = null;
    }
}


class ManAgr {
    private Phone phone;

    public ManAgr(Phone phone) {
        this.phone = phone;//aggregation
    }

    public ManAgr() {
        phone = new Phone();//composition
    }
}

class Phone {

}