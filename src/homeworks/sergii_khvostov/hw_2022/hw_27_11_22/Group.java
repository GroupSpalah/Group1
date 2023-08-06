package homeworks.sergii_khvostov.hw_2022.hw_27_11_22;

//@Khvostov

public class Group {
    private String titleGroup;
    private int amountStudents;

    public Group(String titleGroup, int amountStudents) {
        this.titleGroup = titleGroup;
        this.amountStudents = amountStudents;
    }

    public String getTitleGroup() {
        return titleGroup;
    }

    public void setTitleGroup(String titleGroup) {
        this.titleGroup = titleGroup;
    }

    public int getAmountStudents() {
        return amountStudents;
    }

    public void setAmountStudents(int amountStudents) {
        this.amountStudents = amountStudents;
    }
}




