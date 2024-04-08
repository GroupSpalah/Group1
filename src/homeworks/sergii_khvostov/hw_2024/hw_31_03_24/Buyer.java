package homeworks.sergii_khvostov.hw_2024.hw_31_03_24;

import java.util.List;
import java.util.Set;

public class Buyer implements Runnable {
    private TicketOffice ticketOffice;
    private String ticketNameToBuy;

    public Buyer(TicketOffice ticketOffice, String ticketNameToBuy) {
        this.ticketOffice = ticketOffice;
        this.ticketNameToBuy = ticketNameToBuy;
    }

    @Override
    public void run() {
        ticketOffice.buyTicket(Thread.currentThread().getName(), ticketNameToBuy);
    }
}
