package homeworks.dmytro_k.hw_2024.hw_31_03_24.version1;

import java.util.*;

public class Buyer implements Runnable {

    private final Set<String> ticketsSet;
    private final Random RANDOM = new Random();

    public Buyer(Set<String> ticketsSet) {
        this.ticketsSet = ticketsSet;
    }

    private void buyTicket() throws InterruptedException {

        String elementToRemove = getRandomTicket();

        Thread.sleep(1000);

        synchronized (ticketsSet) {
            while (!ticketsSet.contains(elementToRemove)) {
                System.out.println("The ticket is not available " +
                        Thread.currentThread().getName() + " is waiting: " + "Билет (" + elementToRemove + ") продан");
                ticketsSet.wait();
            }

            Thread.sleep(1000);
            ticketsSet.remove(elementToRemove);
            System.out.println("Билет (" + elementToRemove + ") куплен " + Thread.currentThread().getName());
            ticketsSet.notifyAll();
        }
    }

    private String getRandomTicket() {
        synchronized (ticketsSet) {
            List<String> elementsList = ticketsSet.stream().toList();
            String randomTicket;
            do {
                int randomIndex = RANDOM.nextInt(ticketsSet.size());
                randomTicket = elementsList.get(randomIndex);
            } while (randomTicket == null);

            return randomTicket;
        }
    }

    @Override
    public void run() {
        while (true) {
            try {
                buyTicket();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

