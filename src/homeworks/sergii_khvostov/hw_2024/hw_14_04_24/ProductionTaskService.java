package homeworks.sergii_khvostov.hw_2024.hw_14_04_24;

import java.util.Arrays;
import java.util.List;

public class ProductionTaskService {
    public static void main(String[] args) {
        Worker worker = new Worker("John");

        Stage stage1 = new Stage("Cutting", 2000);
        Stage stage2 = new Stage("Assembly", 3000);
        Stage stage3 = new Stage("Painting", 4000);

        List<Stage> stages = Arrays.asList(stage1, stage2, stage3);
        Product product = new Product("Table", stages);

        ProductionTask task = new ProductionTask(product, worker);
        Thread thread = new Thread(task);
        thread.start();

        try {
            Thread.sleep(5000);
            task.cancellProduction("Customer request cancellation");
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
