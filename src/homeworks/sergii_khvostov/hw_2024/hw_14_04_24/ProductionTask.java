package homeworks.sergii_khvostov.hw_2024.hw_14_04_24;

/*Создать приложение Фабрика.
Фабрика изготавливает изделия и изготовление каждого изделия занимает определенное время и
имеет цикл с этапами(каждый этап имеет название и занимает определенное время).
Пользователь заказывает изделие и в любой момент может спросить название текущего этапа и имя рабочего.
Каждый цикл изготовления необходимо писать в файл, который называется ("Название изделия" + имя рабочего).
Заказчик может отказаться от заказанного изделия, тогда в файл необходимо добавить причину.*/

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class ProductionTask implements Runnable {
    private Product product;
    private Worker worker;
    private File logFile;
    private volatile boolean cancelled = false;
    private String cancellationReason;

    public ProductionTask(Product product, Worker worker) {
        this.product = product;
        this.worker = worker;
        this.logFile = new File(product.getName() + "_" + worker.name() + ".log");
    }

    @Override
    public void run() {
        try (FileWriter fileWriter = new FileWriter(logFile, true)) {
            for (Stage stage : product.getStages()) {
                if (cancelled) {
                    fileWriter.write("Production cancelled: " + cancellationReason + "\n");
                    return;
                }
                fileWriter.write("Working on stage: " + stage.name() + "\n");
                try {
                    Thread.sleep(stage.time());
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
            fileWriter.write("Production completed.\n");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void cancellProduction(String reason) {
        this.cancelled = true;
        this.cancellationReason = reason;
    }
}
