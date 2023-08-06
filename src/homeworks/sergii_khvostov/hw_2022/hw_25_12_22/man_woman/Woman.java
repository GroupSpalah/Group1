package homeworks.sergii_khvostov.hw_2022.hw_25_12_22.man_woman;

import homeworks.sergii_khvostov.hw_2022.hw_25_12_22.person.Person;

public class Woman extends Person {

    private String firstName;
    private String lastName;
    private int age;
    private boolean married;
    private String partner;
    private Man man;


    public Woman(String firstName, String lastName, int age, String gender,
                 int phoneNumber, boolean married, String partner) {
        super(firstName, lastName, age, gender, phoneNumber);
        this.married = married;
        this.partner = partner;
        this.age = age;
    }


    @Override
    public int getAge() {
        return age;
    }

    public boolean isMarried() {
        return married;
    }

    public String getPartner() {
        return partner;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setPartner(String partner) {
        this.partner = partner;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }


    public void setMarried(boolean married) {
        this.married = married;
    }

    public Man getMan() {
        return man;
    }

    public boolean isRetired(int age) {
        return age > 60 ? true : false;
    }

    public void registerPartnership(Man man) {
        setLastName(man.getLastName());
        setPartner(man.getFirstName() + " " + man.getLastName());
        setMarried(true);
    }

    public void deregisterPartnership(boolean married) {
        if (!married) {
            setLastName(lastName);
            setPartner("No");
        }
    }

    public void printInfo() {
        System.out.println("Name: " + getFirstName() + "\n" + "Surname: " +
                getLastName() + "\n" + "Age: " + getAge() + "\n" +
                "Gender: " + getGender() + "\n" + "Phone: " +
                getPhoneNumber() + "\n" + "Married: " + isMarried() +
                "\n" + "Partner: " + getPartner());
    }
}
