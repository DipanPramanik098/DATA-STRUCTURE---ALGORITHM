package _011_Bit_Manupulation._02_Problems;

import java.util.*;

public class _06_Power_Set {

    // Function to generate power set
    public List<List<Integer>> powerSet(int[] nums) {

        int n = nums.length;

        // Total subsets = 2^n
        int total = 1 << n;

        List<List<Integer>> ans = new ArrayList<>();

        // Loop through all numbers from 0 to 2^n - 1
        for (int mask = 0; mask < total; mask++) {

            List<Integer> subset = new ArrayList<>();

            // Check each bit
            for (int i = 0; i < n; i++) {

                // If ith bit is set → include nums[i]
                if ((mask & (1 << i)) != 0) {
                    subset.add(nums[i]);
                }
            }

            ans.add(subset);
        }

        return ans;
    }

    // MAIN METHOD
    public static void main(String[] args) {

        _06_Power_Set obj = new _06_Power_Set();

        int[] nums1 = {1, 2, 3};
        int[] nums2 = {1, 2};
        int[] nums3 = {0};

        System.out.println("Power Set of [1,2,3]:");
        print(obj.powerSet(nums1));

        System.out.println("\nPower Set of [1,2]:");
        print(obj.powerSet(nums2));

        System.out.println("\nPower Set of [0]:");
        print(obj.powerSet(nums3));
    }

    // Helper function to print result
    public static void print(List<List<Integer>> ans) {
        for (List<Integer> subset : ans) {
            System.out.println(subset);
        }
    }
}