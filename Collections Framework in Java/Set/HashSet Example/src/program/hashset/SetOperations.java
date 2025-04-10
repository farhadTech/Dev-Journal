package program.hashset;

import java.util.HashSet;
import java.util.Set;

public class SetOperations {
    public static void main(String[] args) {
        Set<Integer> hashSet1 = new HashSet<>();
        hashSet1.add(7);
        hashSet1.add(4);
        hashSet1.add(5);
        hashSet1.add(6);
        hashSet1.add(8);

        Set<Integer> hashSet2 = new HashSet<>();
        hashSet2.add(1);
        hashSet2.add(6);

        // union
//        hashSet1.addAll(hashSet2);
        System.out.println(hashSet1);
        System.out.println(hashSet2);

        // intersection
//        hashSet1.retainAll(hashSet2);
        System.out.println(hashSet1);

        // difference
        hashSet1.removeAll(hashSet2);
        System.out.println(hashSet1);

        // subset
        boolean isSubset = hashSet1.containsAll(hashSet2);
        System.out.println(isSubset);
    }
}

