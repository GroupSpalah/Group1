package homeworks.dmytro_k.hw_2023.hw_01_10_23.task1;

import java.util.List;

public class OilProductionTest {
    public static void main(String[] args) {
        Employee employee1 = new Employee("Sam", Post.MANAGER, 15);
        Employee employee2 = new Employee("Dan", Post.MEDIC, 13);
        Employee employee3 = new Employee("Tom", Post.WORKER, 10);

        OffshorePlatforms offshorePlatforms1 = new OffshorePlatforms(20,2);

        offshorePlatforms1.addEmployee(employee1);
        offshorePlatforms1.addEmployee(employee2);
        offshorePlatforms1.addEmployee(employee3);

        offshorePlatforms1.error();

    }
}
