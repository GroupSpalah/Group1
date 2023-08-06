package homeworks.dmytro_k.hw_2022.hw_27_11_22;

/*
 * @author Dmytro Koliesnik
 * @version 2.0
 * @since   2022-12-04
 */

/*Создать класс University c полями название, кол-во групп, дата основания.*/

public class University {

    private String name;
    private int groupsAmount;
    private int foundingDate;

    public University(String name, int foundingDate) {
        this.name = name;
        this.groupsAmount = getGroupsAmount();
        this.foundingDate = foundingDate;
    }

    public String getUniversityName() {
        return name;
    }

    public int getGroupsAmount() {
        return groupsAmount;
    }
}