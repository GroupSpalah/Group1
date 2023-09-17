package lessons.streams.medicines;

import java.util.List;
import java.util.stream.Stream;

/**
 * Imagine You have a few sources where You can buy medicines, they're online pharmacy and local pharmacies.
 * Each source have some list of medicines that are available at the moment.
 * First, You have medicines online:
 * List<String>medicinesOnline = List.of("Askorbinka", "Nazonex", "Dekatylen", "Strepsils", "Zelenka");
 * Second, You have a list of local pharmacies with lists of medicines:
 * List<Pharmacy> pharmacies = List.of(new Pharmacy("3i", List.of("Nazonex", "Vitamin C", "Zn Supplements")),
 * new Pharmacy("DS", List.of("Vitamin C", "Advil", "DoppelHerz")),
 * new Pharmacy("Kopiiochka", List.of("Ibuprofen", "Vitamin C")));
 * Your tasks are:
 * - use given code snippets without modifications;
 * - create needed POJO class using Java best practices;
 * - print out all unique medicines from all sources (only medicines, You should collect them into one collection),
 * final collection should be sorted by medicine name.
 */
public class UseFlatMap {
    public static void main(String[] args) {
        List<Pharmacy> pharmacies = List.of(
                new Pharmacy("3i", List.of("Nazonex", "Vitamin C", "Zn Supplements")),
                new Pharmacy("DS", List.of("Vitamin C", "Advil", "DoppelHerz")),
                new Pharmacy("Kopiiochka", List.of("Ibuprofen", "Vitamin C")));

        List<String> medicinesOnline = List.of("Askorbinka", "Nazonex", "Dekatylen", "Strepsils", "Zelenka");


        Stream<List<String>> listStream = pharmacies
                .stream()//Stream<Pharmacy>
                .map(pharmacy -> pharmacy.medicines());

    }
}

record Pharmacy(String name, List<String> medicines) {
}


