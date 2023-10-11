package homeworks.vladyslav_lazin.hw_2023.hw_24_09_23.entity;

import homeworks.vladyslav_lazin.hw_2023.hw_24_09_23.entity.Address;

public class Man {
    private String name;
    private String surname;
    private int age;
    private int childrenNumber;
    private Address address;
    
    public Man(String name, String surname, int age, int childrenNumber, Address address) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.childrenNumber = childrenNumber;
        this.address = address;
    }

    @Override
    public String toString() {
        return name + " " + surname + ", age: " + age + ", children number: " + childrenNumber
                + ", address: " + address;
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

    public int getChildrenNumber() {
        return childrenNumber;
    }

    public void setChildrenNumber(int childrenNumber) {
        this.childrenNumber = childrenNumber;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    

    
}
