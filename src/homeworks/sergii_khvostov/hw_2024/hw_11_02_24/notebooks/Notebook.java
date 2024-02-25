package homeworks.sergii_khvostov.hw_2024.hw_11_02_24.notebooks;

public class Notebook {
    private int id;
    private String manufacturer;
    private String notebookName;
    private int pageCount;
    private String coverType;
    private String country;
    private String pageAppearance;

    public Notebook(String manufacturer, String notebookName, int pageCount,
                    String coverType, String country, String pageAppearance) {
        this.manufacturer = manufacturer;
        this.notebookName = notebookName;
        this.pageCount = pageCount;
        this.coverType = coverType;
        this.country = country;
        this.pageAppearance = pageAppearance;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getNotebookName() {
        return notebookName;
    }

    public void setNotebookName(String notebookName) {
        this.notebookName = notebookName;
    }

    public int getPageCount() {
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public String getCoverType() {
        return coverType;
    }

    public void setCoverType(String coverType) {
        this.coverType = coverType;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getPageAppearance() {
        return pageAppearance;
    }

    public void setPageAppearance(String pageAppearance) {
        this.pageAppearance = pageAppearance;
    }

    @Override
    public String toString() {
        return "Notebook{" +
                "id= " + id +
                ", manufacturer= '" + manufacturer + '\'' +
                ", notebookName= '" + notebookName + '\'' +
                ", pageCount= " + pageCount +
                ", coverType= '" + coverType + '\'' +
                ", country= '" + country + '\'' +
                ", pageAppearance= '" + pageAppearance + '\'' +
                '}';
    }
}
