package _011_Bit_Manupulation._03_Contest;

import java.util.ArrayList;
import java.util.List;

public class _03_Odd_Subsets {

    // Function to return all subsets whose sum is odd
    public List<List<Integer>> setsWithOddSum(int[] nums) {

        List<List<Integer>> ans = new ArrayList<>();
        int n = nums.length;

        // Total subsets = 2^n
        int totalSubsets = 1 << n;

        // Generate all subsets using bit masking
        for (int mask = 0; mask < totalSubsets; mask++) {

            List<Integer> subset = new ArrayList<>();
            int sum = 0;

            // Check each bit
            for (int i = 0; i < n; i++) {
                if ((mask & (1 << i)) != 0) {
                    subset.add(nums[i]);
                    sum += nums[i];
                }
            }

            // Keep only odd sum subsets
            if ((sum & 1) != 0) {
                ans.add(subset);
            }
        }

        return ans;
    }

    // Main method
    public static void main(String[] args) {

        _03_Odd_Subsets obj = new _03_Odd_Subsets();

        int[] nums1 = {1, 2, 3, 4};
        int[] nums2 = {1, 3, 5, 7};

        List<List<Integer>> ans1 = obj.setsWithOddSum(nums1);
        List<List<Integer>> ans2 = obj.setsWithOddSum(nums2);

        System.out.println("Odd sum subsets for [1, 2, 3, 4]:");
        for (List<Integer> subset : ans1) {
            System.out.println(subset);
        }

        System.out.println("\nOdd sum subsets for [1, 3, 5, 7]:");
        for (List<Integer> subset : ans2) {
            System.out.println(subset);
        }
    }
}