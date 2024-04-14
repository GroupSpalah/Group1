package homeworks.sergii_khvostov.hw_2024.hw_31_03_24;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class TicketOffice {
    private Set<String> availableTickets;

    public TicketOffice() {
        availableTickets = new HashSet<>(15);
    }

    public synchronized void buyTicket(String buyerName, String ticketName) {
        while (!availableTickets.contains(ticketName.toLowerCase())) {
            try {
                System.out.println("Ticket " + ticketName + " sold");
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        availableTickets.remove(ticketName);
        System.out.println("Ticket " + ticketName + " purchased " + buyerName + ".");
    }

    public synchronized void returnTicket(String salesmanName, String ticketName) {
        availableTickets.add(ticketName.toLowerCase());
        System.out.println("Ticket " + ticketName + " returned " + salesmanName + ".");
        notify();
    }

    private void userInput() {
        TicketOffice ticketOffice = new TicketOffice();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Enter:");
            System.out.println("1 - Buy");
            System.out.println("2 - Return");
            System.out.println("0 - Exit");

            String userInput = scanner.nextLine();
            switch (userInput) {
                case "1" -> {
                    System.out.println("Enter the name of the ticket:");
                    String ticketNameToBuy = scanner.nextLine();
                    Thread buyerThread = new Thread(new Buyer(ticketOffice, ticketNameToBuy));
                    buyerThread.start();
                }
                case "2" -> {
                    System.out.println("Enter the name of the ticket:");
                    String ticketNameToReturn = scanner.nextLine();
                    Thread returnedThread = new Thread(new Returned(ticketOffice, ticketNameToReturn));
                    returnedThread.start();
                }
                case "0" -> {
                    System.out.println("Goodbye");
                    scanner.close();
                    return;
                }
                default -> System.out.println("Invalid input. Please try again.");
            }
        }
    }

    public void execute() {
        userInput();
    }
}

