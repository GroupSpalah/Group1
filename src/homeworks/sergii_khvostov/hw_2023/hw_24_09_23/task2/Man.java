package homeworks.sergii_khvostov.hw_2023.hw_24_09_23.task2;

public class Man {
    private String firstName;
    private String lastName;
    private int age;
    private int countOfChildren;
    private Address address;

    public Man(String firstName, String lastName, int age, int countOfChildren, Address address) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.countOfChildren = countOfChildren;
        this.address = address;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getAge() {
        return age;
    }

    public int getCountOfChildren() {
        return countOfChildren;
    }

    public Address getAddress() {
        return address;
    }

    @Override
    public String toString() {
        return
                "firstName= " + firstName +
                " lastName= " + lastName;
                /*"age= " + age +
                "countOfChildren= " + countOfChildren +
                "address= " + address;*/
    }
}
