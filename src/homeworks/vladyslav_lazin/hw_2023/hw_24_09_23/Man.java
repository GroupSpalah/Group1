package homeworks.vladyslav_lazin.hw_2023.hw_24_09_23;

public class Man {
    private String name;
    private String surname;
    private int age;
    int childrenCount;
    Address address;
    
    public Man(String name, String surname, int age, int childrenCount, Address address) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.childrenCount = childrenCount;
        this.address = address;
    }

    @Override
    public String toString() {
        return "Man [name=" + name + ", surname=" + surname + ", age=" + age + ", childrenCount=" + childrenCount
                + ", address=" + address + "]";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getChildrenCount() {
        return childrenCount;
    }

    public void setChildrenCount(int childrenCount) {
        this.childrenCount = childrenCount;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    

    
}
