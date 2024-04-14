package homeworks.dmytro_k.hw_2024.hw_31_03_24.version2;

public class TicketOfficeTest {
    public static void main(String[] args) {
        TicketOfficeService ticketOfficeService = new TicketOfficeService(10);
        ticketOfficeService.getSellOrBuy();
    }
}
