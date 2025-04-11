package program.exercise;

import java.util.*;

public class RemoveDuplicates {
    public int removeDuplicates(int[] nums) {
        // Use LinkedHashSet to maintain the order
        Set<Integer> set = new LinkedHashSet<>();

        // Add elements to the set (removes duplicates)
        for (int num : nums) {
            set.add(num);
        }
        // The problem only cares about the first k elements of the array,
        // where k is the   number of unique elements.
        // So if you return k = 3,
        // the array is considered correct as long as the first 3 elements are [1, 2, 3].
        // The rest of the array doesn't matter. LeetCode will only check nums[0] to nums[k - 1].
        // Copy unique elements back to the array
        int i = 0;
        for (int num : set) {
            nums[i++] = num;
        }

        // Return the number of unique elements
        return set.size();
    }

    public static void main(String[] args) {
        int[] nums = new int[20];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = i + 1;
        }
        System.out.println("Size of unique elements: " + nums.length);

    }
}
