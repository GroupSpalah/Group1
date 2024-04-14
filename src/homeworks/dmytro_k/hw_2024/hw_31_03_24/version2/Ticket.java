package homeworks.dmytro_k.hw_2024.hw_31_03_24.version2;

record Ticket(String departureCity, String arrivalCity) {
    public String getName() {
        return departureCity + "-" + arrivalCity;
    }
}
