package homeworks.vladyslav_lazin.hw_2024.hw_31_03_24;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Passenger implements Runnable {
    private final Set<String> tickets = new HashSet<>();
    private final String name;
    private Role role;

    public Passenger(String name, Role role, String ticket) {
        this.name = name;
        this.role = role;
        tickets.add(ticket);
    }

    public String getName() {
        return name;
    }

    public Set<String> getTickets() {
        return tickets;
    }

    public void addTicket(String ticket) {
        tickets.add(ticket);
    }

    public void setRole(Role role) {
        this.role = role;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Passenger passanger)) return false;
        return Objects.equals(getName(), passanger.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName());
    }

    @Override
    public void run() {
        switch (this.role) {
            case BUYER -> buyTicket();
            case SELLER -> sellTicket();
            default -> {
            }
        }
    }

    private void buyTicket() {
        synchronized (CashBox.lock) {
            while (true) {
                if (CashBox.boughtTickets.contains(CashBox.ticketForSale)) {
                    System.out.printf("The ticket %s is unavalible. Please wait.%n", CashBox.ticketForSale);
                    try {
                        CashBox.lock.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                } else {
                    CashBox.boughtTickets.add(CashBox.ticketForSale);
                    tickets.add(CashBox.ticketForSale);
                    System.out.printf("Passanger %s has bought the ticket %s%n", this.name, CashBox.ticketForSale);
                    break;
                }
            }
        }
    }

    private void sellTicket() {
        synchronized (CashBox.lock) {
            if (tickets.contains(CashBox.ticketForSale)) {
                CashBox.boughtTickets.remove(CashBox.ticketForSale);
                tickets.remove(CashBox.ticketForSale);
                System.out.printf("Passanger %s has returned the ticket %s%n", this.name, CashBox.ticketForSale);
                CashBox.lock.notify();
            } else {
                System.out.println("You can't sell this ticket");
            }
        }
    }
}

