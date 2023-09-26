package homeworks.vladyslav_lazin.hw_2023.hw_24_09_23;

public class Address {
    String country;
    String city;
    String street;
    int houseNumb;
    
    public Address(String country, String city, String street, int houseNumb) {
        this.country = country;
        this.city = city;
        this.street = street;
        this.houseNumb = houseNumb;
    }

    @Override
    public String toString() {
        return "Address [country=" + country + ", city=" + city + ", street=" + street + ", houseNumb=" + houseNumb
                + "]";
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public int getHouseNumb() {
        return houseNumb;
    }

    public void setHouseNumb(int houseNumb) {
        this.houseNumb = houseNumb;
    }

    
}
