package lessons.learn_class;

public class LearnEnum {
    public static void main(String[] args) {
        Country usa = Country.USA;

        print(Country.UKRAINE);

        System.out.println(usa.getShortName());
    }

    public static void print(String country) {//Ukraine, USA, Canada
        //complex logic
        if (country.equals("Ukraine") || country.equals("USA")) {

        }
    }

    public static void print(Country country) {
    }
}

enum Country {
    CANADA("Canada"),
    USA("Usa"),
    UKRAINE("Ukraine");

    private String shortName;

    Country(String shortName) {
        this.shortName = shortName;
    }

    public String getShortName() {
        return shortName;
    }
}
