package homeworks.dmytro_k.hw_2024.hw_31_03_24.version2;

record Passenger(TicketOffice ticketOffice, String name, String departureCity,
                 String arrivalCity, boolean isReturning) implements Runnable {
    @Override
    public void run() {
        if (isReturning) {
            ticketOffice.returnTicket(departureCity, arrivalCity, name);
        } else {
            ticketOffice.buyTicket(departureCity, arrivalCity, name);
        }
    }
}
