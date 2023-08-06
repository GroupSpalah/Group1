package lessons.learn_class.man_position;

public class ManService {

    public boolean comparePositions(Man man1, Man man2) {
        Position position1 = man1.getPosition();
        Position position2 = man2.getPosition();

        String name1 = position1.getName();
        String name2 = position2.getName();

        return name1.equals(name2);
    }

    public boolean compareLastNames(Man man1, Man man2) {

        String name1 = man1.getLastName();
        String name2 = man2.getLastName();

        return name1.equals(name2);
    }
}
