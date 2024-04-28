package homeworks.sergii_khvostov.hw_2024.hw_14_04_24;

import java.util.List;

public class Product {
    private String name;
    private List<Stage> stages;
    private int totalProductionsTime;

    public Product(String name, List<Stage> stages) {
        this.name = name;
        this.stages = stages;
        this.totalProductionsTime = stages.stream().mapToInt(Stage::time).sum();
    }

    public String getName() {
        return this.name;
    }

    public List<Stage> getStages() {
        return this.stages;
    }
}


