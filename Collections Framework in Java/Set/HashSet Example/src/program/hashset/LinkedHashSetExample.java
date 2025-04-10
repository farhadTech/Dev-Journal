package program.hashset;

import java.util.LinkedHashSet;
import java.util.SequencedSet;

public class LinkedHashSetExample {
    public static void main(String[] args) {
        var countries = new LinkedHashSet<String>();
        countries.add("China");
        countries.add("France");
        countries.add("Germany");
        countries.add("Italy");
        countries.add("United States");
        countries.add("India");
        countries.add("Japan");
        countries.add("Canada");
        countries.add("Germany");
        countries.add("Italy");
        countries.add("United States");
        countries.add("India");
        countries.add("Japan");
        countries.add("Canada");

        for(var country : countries) {
            System.out.println(country);
        }

        System.out.println("In reverse order of LinkedHashSet: ");
        SequencedSet<String> reversedCountries = countries.reversed();
        System.out.println(reversedCountries);

        System.out.println("Remove last element in LinkedHashSet: " + countries.removeLast());
        System.out.println("Remove first element in LinkedHashSet: " + countries.removeFirst());
        System.out.println("After remove first and last element in LinkedHashSet: " + countries);
        System.out.println("Is Japan present in LinkedHashSet: " + countries.contains("Japan"));
        countries.addFirst("South Africa");
        countries.addLast("Afghanistan");
        countries.addLast("Albania");
        System.out.println("After add first and last element in LinkedHashSet: " + countries);
        System.out.println("Size of LinkedHashSet: " + countries.size());
    }
}
