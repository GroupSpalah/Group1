package homeworks.dmytro_m.hw_2022.hw_27_11_2022;

public class University {
    private String universityName;
    private int numberGroups;
    private int foundingDate;

    public University(String universityName, int numberGroups, int foundingDate) {
        this.universityName = universityName;
        this.numberGroups = numberGroups;
        this.foundingDate = foundingDate;
    }

    public String getUniversityName() {
        return universityName;
    }

    public int getNumberGroups() {
        return numberGroups;
    }

    public int getFoundingDate() {
        return foundingDate;
    }

    public void setUniversityName(String universityName) {
        this.universityName = universityName;
    }

    public void setNumberGroups(int numberGroups) {
        this.numberGroups = numberGroups;
    }

    public void setFoundingDate(int foundingDate) {
        this.foundingDate = foundingDate;
    }

    @Override
    public String toString() {
        return "University{" +
                "universityName='" + universityName + '\'' +
                ", numberGroups=" + numberGroups +
                ", foundingDate='" + foundingDate + '\'' +
                '}';
    }
}

//Создать класс University c полями название, кол-во групп, дата основания.