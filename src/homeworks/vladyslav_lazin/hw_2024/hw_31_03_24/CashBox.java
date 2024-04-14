package homeworks.vladyslav_lazin.hw_2024.hw_31_03_24;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class CashBox {
    private static final Scanner SCANNER = new Scanner(System.in);
    public static volatile Set<Passenger> passengers = new HashSet<>();
    public static volatile Set<String> boughtTickets = new HashSet<>();
    public static volatile String ticketForSale;
    static final Object lock = new Object();

    public static void main(String[] args) {
        while (true) {
            menu();
            String key = SCANNER.next();
            try {
                switch (key) {
                    case "1" -> {
                        ticketForSale = getInfoFromUser("Please, type name of ticket that you want to buy");
                        String buyerName = getInfoFromUser("Please, type name of passanger");
                        Passenger passenger = findPassenger(buyerName);
                        if (passenger != null) {
                            passenger.addTicket(ticketForSale);
                        } else {
                            passenger = new Passenger(buyerName, Role.BUYER, ticketForSale);
                            passengers.add(passenger);
                        }
                        new Thread(passenger, passenger.getName().replace(" ", "-"))
                                .start();
                    }

                    case "2" -> {
                        ticketForSale = getInfoFromUser("Please, type name of ticket that you want to sell");
                        String sellerName = getInfoFromUser("Please, type name of seller");
                        Passenger passenger = findPassenger(sellerName);
                        if (passenger == null) {
                            System.out.println("This passenger haven't bought any tickets");
                        } else {
                            passenger.setRole(Role.SELLER);
                            new Thread(passenger, sellerName.replace(" ", "-"))
                                    .start();
                        }
                    }
                    default -> {
                        return;
                    }
                }
            } catch (Exception e) {
                System.out.println("Exception" + e);
            }
        }

    }

    private static String getInfoFromUser(String message) {
        System.out.println(message);
        return new Scanner(System.in).nextLine();
    }

    private static void menu() {
        System.out.println("1) If you want to buy ticket.\n" +
                "2) If you want to sell ticket.\n" +
                "3) Exit.");
    }
    private static Passenger findPassenger(String name) {
        return passengers
                .stream().
                filter(element -> element.getName().equals(name))
                .findFirst()
                .orElse(null);
    }

}

