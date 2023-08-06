package homeworks.dmytro_m.hw_2022.hw_27_11_2022;

public class Group {
    private String groupName;
    private int numberStudents;

    public Group(String groupName, int numberStudents) {
        this.groupName = groupName;
        this.numberStudents = numberStudents;
    }

    public String getGroupName() {
        return groupName;
    }

    public int getNumberStudents() {
        return numberStudents;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public void setNumberStudents(int numberStudents) {
        this.numberStudents = numberStudents;
    }

    @Override
    public String toString() {
        return "Group{" +
                "groupName='" + groupName + '\'' +
                ", numberStudents='" + numberStudents + '\'' +
                '}';
    }
}

//        Создать класс Group c полями название, кол-во студентов.