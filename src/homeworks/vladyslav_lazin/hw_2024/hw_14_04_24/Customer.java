package homeworks.vladyslav_lazin.hw_2024.hw_14_04_24;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;
import java.util.List;

public final class Customer {
    private Product product;
    private Worker worker;

    public Product getProduct() {
        return product;
    }

    public Worker getWorker() {
        return worker;
    }
    public void createOrder(String prodName, String workerName, Stage[] stages) {
        this.product = new Product(prodName, stages);
        this.worker = new Worker(workerName, product);
    }
    public String getOrderInfo() {
        String status;
        try {
            List<String> entries = Files.readAllLines(worker.getPath());
            status = entries.get(entries.size() - 1);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return status;
    }

    public void cancelOrder(String reason) {
        worker.stopProduction();
        try {
            Files.writeString(worker.getPath(), "\nInterrupted by customer. \nReason: ", StandardOpenOption.APPEND);
            Files.writeString(worker.getPath(), reason, StandardOpenOption.APPEND);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
