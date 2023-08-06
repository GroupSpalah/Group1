package homeworks.dmytro_m.hw_2022.hw_27_11_2022;

public class TestStudent {

    public static void main(String[] args) {

        Group group1 = new Group("M-120", 20);
        University university1 = new University("DNU", 15, 1998);

        Student student1 = new Student("Dmytro", "Mitusov", Gender.MALE, 33,
                group1, university1);

        Student student2 = new Student("Dmytro", "Mitusov", Gender.MALE, 33,
                group1, university1);

        Student student3 = new Student("Dmytro", "Mitusov", Gender.MALE, 33,
                new Group("M-121", 26),
                new University("DNU", 15, 1998));

        Student student4 = new Student("Dmytro", "Mitusov", Gender.MALE, 33,
                new Group("M-122", 23),
                new University("DNU", 15, 1998));

        StudentService service = new StudentService();
        service.infoStudent(student1);
        System.out.println(service.compareGroup(student1, student2));


    }

}


//        Создать несколько студентов:
//        - с одинаковой группой и университетом.
//        - с разными группами в университете.