package homeworks.vladyslav_lazin.hw_2024.hw_14_04_24;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.List;

public final class Customer {
    private Product product;
    private Worker worker;

    private Path getPath() {
        String fileName = product.prodName() + "-" + worker.getName() + ".txt";
        return Worker.PATH.resolve(fileName);
    }
    public void createOrder(String prodName, String workerName, Stage[] stages) {
        this.product = new Product(prodName, stages);
        this.worker = new Worker(workerName, product);
    }
    public String getOraderInfo() {
        String status;
        try {
            List<String> enties = Files.readAllLines(getPath());
            status = enties.get(enties.size() - 1);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return status;
    }

    public void cancelOrder(String reason) {
        worker.stopProduction();
        try {
            Files.writeString(getPath(), reason, StandardOpenOption.APPEND);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
