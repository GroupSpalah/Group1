package homeworks.dmytro_k.hw_2022.hw_27_11_22;

/*
 * @author Dmytro Koliesnik
 * @version 2.0
 * @since   2022-12-04
 */

/*Создать класс Group c полями название, кол-во студентов.*/

public class Group {

    private String groupName;
    private int studentAmount;

    public Group(String groupName, int studentAmount) {
        this.groupName = groupName;
        this.studentAmount = studentAmount;
    }

    public String getGroupName() {
        return groupName;
    }
}
