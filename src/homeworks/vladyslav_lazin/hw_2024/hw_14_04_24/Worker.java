package homeworks.vladyslav_lazin.hw_2024.hw_14_04_24;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.concurrent.TimeUnit;

public final class Worker implements Runnable {
    public static final Path PATH = Paths.get("./src/homeworks/vladyslav_lazin/hw_2024/hw_14_04_24/");
    private final String name;
    private final Product product;
    private boolean isInterrupted = false;

    public Worker(String name, Product product) {
        this.name = name;
        this.product = product;
        new Thread(this).start();
    }

    public void stopProduction() {
        isInterrupted = true;
    }

    public String getName() {
        return name;
    }

    @Override
    public void run() {
        String fileName = product.prodName() + "-" + name + ".txt";
        Path path = PATH.resolve(fileName);
        if (!Files.exists(path)) {
            try {
                Files.createFile(path);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        for (Stage stage : product.stages()) {
            try {
                Files.writeString(path, stage.stageName(), StandardOpenOption.APPEND);
                Files.writeString(path, "\n", StandardOpenOption.APPEND);
                TimeUnit.SECONDS.sleep(5);
                if (isInterrupted) {
                    Thread.currentThread().interrupt();
                    return;
                }
            } catch (IOException | InterruptedException e) {
                return;
            }
        }
        try {
            Files.writeString(path, "Production has been finished", StandardOpenOption.APPEND);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

