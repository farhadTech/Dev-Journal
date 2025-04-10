package program.hashset;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class HashSetIterationDemo {
    public static void main(String[] args) {
        Set<String> superPowers = new HashSet<>();
        // super powers of super heroes.
        superPowers.add("Invisibility");
        superPowers.add("Teleportation");
        superPowers.add("Mind Reading");
        superPowers.add("Super Strength");
        superPowers.add("Time Travel");

        // villains and their mischievous powers
        superPowers.add("Laser Vision");
        superPowers.add("Weather Manipulation");
        superPowers.add("Telekinesis");
        superPowers.add("Shape-Shifting");
        superPowers.add("Chaos-Induction");

        System.out.println("All the super powers in uppercase using for each loop:");
        for (String superPower : superPowers) {
            System.out.println(superPower.toUpperCase());
        }
        System.out.println();
        System.out.println("All the super powers in lowercase using an iterator:");
        Iterator<String> iterator = superPowers.iterator();
        while (iterator.hasNext()) {
            String superPower = iterator.next();
            System.out.println(superPower.toLowerCase());
        }
    }
}
