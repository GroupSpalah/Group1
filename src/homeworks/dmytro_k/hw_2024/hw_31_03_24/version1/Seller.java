package homeworks.dmytro_k.hw_2024.hw_31_03_24.version1;

import java.util.Random;
import java.util.Set;

public class Seller implements Runnable {

    private final Set<String> ticketsSet;
    private final Random RANDOM = new Random();
    private static final int MAX_TICKETS_SET_SIZE = 15;

    public Seller(Set<String> ticketsSet) {
        this.ticketsSet = ticketsSet;
    }

    private void sellTicket() throws InterruptedException {

        String elementToAdd = generateRandomTicket();

        synchronized (ticketsSet) {

            while (ticketsSet.size() >= MAX_TICKETS_SET_SIZE) {
                System.out.println("Нет свободных мест для билетов " +
                        Thread.currentThread().getName() + " is waiting.");
                ticketsSet.wait();
            }

            Thread.sleep(1000);
            ticketsSet.add(elementToAdd);
            System.out.println("Билет (" + elementToAdd + ") добавлен " + Thread.currentThread().getName());
            ticketsSet.notifyAll();
        }
    }

    private String generateRandomTicket() {
        String[] cities = {"Lviv", "Odessa", "Kharkiv", "Dnipro", "Zaporizhzhia", "Ivano-Frankivsk",
                "Chernivtsi", "Uzhgorod", "Vinnytsia", "Poltava", "Kropyvnytskyi", "Mariupol", "Lutsk",
                "Ternopil", "Rivne", "Kremenchuk", "Bila Tserkva", "Nikopol", "Sloviansk"};

        String city1;
        String city2;

        do {
            city1 = cities[RANDOM.nextInt(cities.length)];
            city2 = cities[RANDOM.nextInt(cities.length)];
        } while (city1.equals(city2));

        return city1 + "-" + city2;//исключил повторение
    }

    @Override
    public void run() {
        while (true) {
            try {
                sellTicket();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
