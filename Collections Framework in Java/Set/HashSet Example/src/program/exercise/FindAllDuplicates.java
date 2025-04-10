package program.exercise;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FindAllDuplicates {
    public static List<Integer> findDuplicates(int[] nums) {
        List<Integer> result = new ArrayList<>();
        Set<Integer> seen = new HashSet<>();

        for (int num : nums) {
            // If the element cannot be added, it has already been seen.
            // seen.add(num) tries to add num to the set.
            // If num was already in the set, add() returns false.
            // So, !seen.add(num) is true if the number is a duplicate,
            // and then it is added to result.
            if (!seen.add(num)) {
                result.add(num);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 2, 3, 3, 4};
        List<Integer> result = findDuplicates(nums);
        System.out.println(result);
    }
}
