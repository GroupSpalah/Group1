package homeworks.sergii_khvostov.hw_2024.hw_31_03_24;

public class Returned implements Runnable {
    private TicketOffice ticketOffice;
    private String ticketNameToReturn;

    public Returned(TicketOffice ticketOffice, String ticketNameToReturn) {
        this.ticketOffice = ticketOffice;
        this.ticketNameToReturn = ticketNameToReturn;
    }

    @Override
    public void run() {
        ticketOffice.returnTicket(Thread.currentThread().getName(), ticketNameToReturn);
    }
}
