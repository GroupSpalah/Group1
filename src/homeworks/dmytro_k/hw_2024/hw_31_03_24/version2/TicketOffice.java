package homeworks.dmytro_k.hw_2024.hw_31_03_24.version2;

import java.util.Comparator;
import java.util.Set;
import java.util.concurrent.ConcurrentSkipListSet;

class TicketOffice {
    private static final int MAX_TICKETS_SET_SIZE = 15;

    //private final Set<Ticket> tickets = new BoundedConcurrentSkipListSet<>(2, Comparator.comparing(Ticket::getName));
    private final Set<Ticket> tickets = new BoundedHashSet<>(MAX_TICKETS_SET_SIZE);


    public void buyTicket(String departureCity, String arrivalCity, String buyerName) {

        String name = departureCity + "-" + arrivalCity;

        synchronized (tickets) {
            while (tickets.stream().noneMatch(ticket -> ticket.getName().equals(name))) {
                try {
                    System.out.println("Ticket " + name + " not available");
                    System.out.println("Passenger " + buyerName + " waiting for ticket " + name);
                    tickets.wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            tickets.removeIf(ticket -> ticket.getName().equals(name));
            System.out.println("Ticket " + name + " purchased " + buyerName);
            System.out.println("Ticket " + name + " sold");
            tickets.notifyAll();
        }
    }

    public void returnTicket(String departureCity, String arrivalCity, String returnerName) {

        synchronized (tickets) {
            if (tickets.size() >= MAX_TICKETS_SET_SIZE) {
                System.out.println("There are no available seats for tickets " + returnerName + " is waiting.");
                try {
                    tickets.wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            tickets.add(new Ticket(departureCity, arrivalCity));
            System.out.println("Ticket " + departureCity + "-" + arrivalCity + " was passed " + returnerName);
            tickets.notifyAll();
        }
    }
}
