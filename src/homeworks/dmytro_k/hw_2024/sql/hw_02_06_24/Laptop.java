package homeworks.dmytro_k.hw_2024.sql.hw_02_06_24;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@AllArgsConstructor
public class Laptop {
    @Setter
    private int id;
    @Setter
    private String model;
    @Setter
    private String manufacturer;
    private LocalDate releaseDate;
    private int RAMCapacity;
    private int SSDCapacity;
    private String processor;

    public Laptop(String model, String manufacturer, LocalDate releaseDate,
                  int RAMCapacity, int SSDCapacity, String processor) {
        this.model = model;
        this.manufacturer = manufacturer;
        this.releaseDate = releaseDate;
        this.RAMCapacity = RAMCapacity;
        this.SSDCapacity = SSDCapacity;
        this.processor = processor;
    }

    @Override
    public String toString() {
        return
                "| id=" + id +
                " | model='" + model + '\'' +
                " | manufacturer='" + manufacturer + '\'' +
                " | releaseDate='" + releaseDate + '\'' +
                " | RAMCapacity=" + RAMCapacity +
                " | SSDCapacity=" + SSDCapacity +
                " | processor='" + processor + '\'' +
                " |" +
                "\n------------------------------------------------------------------------------------------------" +
                "------------------------------------------------------------";
    }
}
