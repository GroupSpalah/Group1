package homeworks.dmytro_k.hw_2024.hw_31_03_24.version2;

import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TicketOfficeService {
    private final TicketOffice ticketOffice = new TicketOffice();
    private final ExecutorService executorService;
    private static final Scanner SCANNER = new Scanner(System.in);

    public TicketOfficeService(int nThreads) {
        this.executorService = Executors.newFixedThreadPool(nThreads);
    }

    public void getSellOrBuy() {
        while (true) {
            try {
                Thread.sleep(1100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            System.out.println("""
                    If you want to sell a ticket, press 1
                    If you want to buy a ticket, press 2
                    To exit, press 3:""");

            String command = SCANNER.nextLine();
            if (!command.equals("1") && !command.equals("2") && !command.equals("3")) {
                System.out.println("Invalid command. Try again.\n");
                continue;
            } else if (command.equalsIgnoreCase("3")) {
                break;
            }
            System.out.println("Enter passenger name:");
            String name = SCANNER.nextLine();
            System.out.println("Enter departure city:");
            String departureCity = SCANNER.nextLine();
            System.out.println("Enter your city of arrival:");
            String arrivalCity = SCANNER.nextLine();
            if (command.equals("1")) {
                executorService.submit(new Passenger(ticketOffice, name, departureCity, arrivalCity, true));
            } else {
                executorService.submit(new Passenger(ticketOffice, name, departureCity, arrivalCity, false));
            }
        }
        executorService.shutdown();
        SCANNER.close();
    }
}
