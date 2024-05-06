package homeworks.dmytro_k.hw_2024.hw_14_04_24;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

class Product implements Runnable {
    private final String name;
    private final String workerName;
    //использовать не ENUM. Переделать без него.
    private final List<ProductionStages> PRODUCTION_CYCLE = Arrays.asList(ProductionStages.values());
    private int currentStageIndex = 0;
    private static final int INDEX_OFFSET = 1;

    public Product(String name, String workerName) {
        this.name = name;
        this.workerName = workerName;
    }

    public String getName() {
        return name;
    }

    public ProductionStage getCurrentStage() {
        return PRODUCTION_CYCLE.get(currentStageIndex - INDEX_OFFSET).productionStage();
    }

    public void nextStage() {
        if (currentStageIndex <= PRODUCTION_CYCLE.size() - INDEX_OFFSET) {
            currentStageIndex++;
            try {
                int duration = getCurrentStage().duration();
                TimeUnit.SECONDS.sleep(duration);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            String stageInfo = "Product name: " + name +
                    "| Worker: " + workerName +
                    "| Actual current stage: " + getCurrentStage().name();
            System.out.println(stageInfo);
            FileWriter.writeToFile(stageInfo);
        }
    }

    public void actualStage() {
        String stageInfo = "Product name: " + name +
                "| Worker: " + workerName +
                "| Actual current stage: " + getCurrentStage().name();
        System.out.println("Actual stage information: ");
        System.out.println(stageInfo);
        System.out.println("--------------------------");
    }

    public void cancelOrder(String reason) {
        FileWriter.writeToFile(name + " " + workerName + "Order cancelled: " + reason);
        Thread.currentThread().interrupt();
    }

    @Override
    public void run() {
        PRODUCTION_CYCLE.forEach(stage -> nextStage());
    }
}
