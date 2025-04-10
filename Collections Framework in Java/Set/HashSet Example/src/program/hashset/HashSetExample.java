package program.hashset;

import com.sun.source.doctree.SeeTree;

import java.util.HashSet;
import java.util.Set;

public class HashSetExample {
    public static void main(String[] args) {
        Set<String> countries = new HashSet<>();
        countries.add("India");
        countries.add("USA");
        countries.add("UK");
        countries.add("France");
        countries.add("India");
        countries.add("USA");

        System.out.println("Size of the countries: " + countries.size());
        /** Hashset: doesn't allow duplicates and no order of insertion maintained in HashSet. **/
        System.out.println("countries are: " + countries);
        for(String country : countries) {
            System.out.println(country + " ");
        }
        System.out.println("\n\n");
        // contains method
        System.out.println("Is France contains in the set? " + countries.contains("France"));
        System.out.println("Is France Germany in the set? " + countries.contains("Germany"));
        System.out.println("\n\n");
        // remove method
        System.out.println("Is india remove from the set? " + countries.remove("India"));
        System.out.println(countries);
        System.out.println("\n\n");
    }
}
