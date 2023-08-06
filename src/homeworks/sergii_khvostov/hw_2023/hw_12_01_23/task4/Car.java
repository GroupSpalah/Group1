package homeworks.sergii_khvostov.hw_2023.hw_12_01_23.task4;

/*Create a Class Car that would have the
following fields: carPrice and color and method
calculateSalePrice() which should be returning
a price of the car.
Create 2 sub classes: Sedan and Truck. The Truck
class has a field as weight and has its own
implementation of calculateSalePrice() method
in which returned price is calculated as
following: if weight>2000 then returned price
car should include 10% discount, otherwise 20%
discount.
The Sedan class has field as length and also
does it is own implementation of
calculateSalePrice(): if length of sedan is >20
feet then returned car price should include 5%
discount, otherwise 10% discount*/

public abstract class Car {
    public  double carPrice;
    public  String color;

    public Car(double carPrice, String color) {
        this.carPrice = carPrice;
        this.color = color;
    }

    public void setCarPrice(double carPrice) {
        this.carPrice = carPrice;
    }

    abstract double calculateSalePrice();
}
