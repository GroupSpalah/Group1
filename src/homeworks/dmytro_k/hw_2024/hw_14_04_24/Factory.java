package homeworks.dmytro_k.hw_2024.hw_14_04_24;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

/**
 * Создать приложение Фабрика. время изготовления цикл производства
 * Фабрика изготавливает изделия и изготовление каждого изделия занимает определенное время и
 * имеет цикл с этапами(каждый этап имеет название и занимает определенное время) (Мапа?).
 * Пользователь заказывает изделие и в любой момент может спросить название текущего этапа и имя рабочего.
 * Каждый цикл изготовления необходимо писать в файл, который называется ("Название изделия" + имя рабочего).
 * Заказчик может отказаться от заказанного изделия, тогда в файл необходимо добавить причину.
 */

public class Factory {

    private final CopyOnWriteArrayList<Product> products;

    private final List<Worker> workers;

    private final Random RANDOM = new Random();

    private static final int INDEX_OFFSET = 1;

    public Factory() {
        products = new CopyOnWriteArrayList<>();
        workers = new ArrayList<>(Set.of(new Worker("Jack"), new Worker("Sam"),
                new Worker("John"), new Worker("Dan")));
    }

    public void startProduction(String name, int amount) {

        Worker rundomWorker = workers.get(RANDOM.nextInt(workers.size()));

        while ((products.size() + INDEX_OFFSET) <= amount) {
            Product product = new Product(name, rundomWorker.name());
            products.add(product);
            product.run();
            String readySignal = "Product " + (products.indexOf(product) + INDEX_OFFSET) + " ready";
            System.out.println(readySignal);
            FileWriter.writeToFile(readySignal);
        }
    }

    public void getActualInfo(int repeatCounter, int timeUntilRequest, int timeBetweenRequests) {
        try {
            TimeUnit.SECONDS.sleep(timeUntilRequest);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        IntStream.range(0, repeatCounter).forEach(i -> {
            Product actualProduct = products.getLast();
            try {
                System.out.println(actualProduct.getName() + " " + (products.indexOf(actualProduct) + INDEX_OFFSET));
                actualProduct.actualStage();
                TimeUnit.SECONDS.sleep(timeBetweenRequests);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
    }
}