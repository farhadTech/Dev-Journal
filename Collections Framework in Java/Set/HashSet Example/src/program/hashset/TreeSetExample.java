package program.hashset;

import java.util.TreeSet;

public class TreeSetExample {
    public static void main(String[] args) {
        TreeSet<String> treeSet = new TreeSet<>();
        treeSet.add("Apple");
        treeSet.add("Banana");
        treeSet.add("Bread");
        treeSet.add("Orange");
        treeSet.add("Pineapple");
        treeSet.add("Pear");
        treeSet.add("Apple");
        treeSet.add("Banana");
        treeSet.add("Banana");
        treeSet.add("Lemon");
        treeSet.add("Apple");

        // printing in a sorted order.
        System.out.println(treeSet);

        treeSet.remove("Apple");
        System.out.println("TreeSet After removing Apple: " + treeSet);
        System.out.println("Size of TreeSet: " + treeSet.size());
        System.out.println("Is Banana Present in TreeSet: " + treeSet.contains("Banana"));
        System.out.println("First element in TreeSet: " + treeSet.first());
        System.out.println("Last element in TreeSet: " + treeSet.last());
        System.out.println("Reverse of treeSet: " + treeSet.reversed());
        System.out.println("Add first element in TreeSet: " + treeSet.add("Apple"));
        System.out.println("Add last element in TreeSet: " + treeSet.add("JackFruit"));
        System.out.println("After add first and last element in TreeSet: " + treeSet);
    }
}
