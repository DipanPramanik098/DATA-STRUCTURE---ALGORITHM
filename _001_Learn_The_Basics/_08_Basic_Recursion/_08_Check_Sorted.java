package _08_Basic_Recursion;

import java.util.ArrayList;
import java.util.List;

/**
 * Program to check if an array is sorted (non-decreasing order)
 * using recursion.
 *
 * Time Complexity  : O(N)
 * Space Complexity : O(N) (recursion stack)
 */

public class _08_Check_Sorted {

    // Public method
    public static boolean isSorted(ArrayList<Integer> nums) {

        // If array has 0 or 1 element
        if (nums.size() <= 1) {
            return true;
        }

        return sort(nums, 0, 1);
    }

    // Recursive helper method
    private static boolean sort(ArrayList<Integer> nums, int left, int right) {

        // Base Case: reached end of array
        if (right >= nums.size()) {
            return true;
        }

        // If current pair violates sorted condition
        if (nums.get(left) > nums.get(right)) {
            return false;
        }

        // Recursive call for next pair
        return sort(nums, left + 1, right + 1);
    }

    public static void main(String[] args) {

        ArrayList<Integer> nums1 = new ArrayList<>(List.of(1, 2, 3, 4, 5));
        ArrayList<Integer> nums2 = new ArrayList<>(List.of(1, 2, 1, 4, 5));

        System.out.println("nums1 → " + isSorted(nums1));
        System.out.println("nums2 → " + isSorted(nums2));
    }
}