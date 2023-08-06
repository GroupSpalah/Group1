package homeworks.sergii_khvostov.hw_2022.hw_27_11_22;

//@Khvostov

public class University {
    private String titleUniversity;
    private int amountGroup;
    private String foundingDate;

    public University(String titleUniversity, int amountGroup, String foundingDate) {
        this.titleUniversity = titleUniversity;
        this.amountGroup = amountGroup;
        this.foundingDate = foundingDate;
    }


    public String getTitleUniversity() {
        return titleUniversity;
    }

    public void setTitleUniversity(String titleUniversity) {
        this.titleUniversity = titleUniversity;
    }

    public int getAmountGroup() {
        return amountGroup;
    }

    public void setAmountGroup(int amountGroup) {
        this.amountGroup = amountGroup;
    }

    public String getFoundingDate() {
        return foundingDate;
    }

    public void setFoundingDate(String foundingDate) {
        this.foundingDate = foundingDate;
    }
}


