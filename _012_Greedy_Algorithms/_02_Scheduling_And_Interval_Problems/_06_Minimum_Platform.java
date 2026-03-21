package _012_Greedy_Algorithms._02_Scheduling_And_Interval_Problems;

import java.util.Arrays;

public class _06_Minimum_Platform {

    // Function to find minimum number of platforms required
    public int findPlatform(int[] Arrival, int[] Departure) {

        int n = Arrival.length;

        // Step 1: Sort both arrays
        Arrays.sort(Arrival);
        Arrays.sort(Departure);

        // Step 2: Initialize pointers and counters
        int i = 1;   // arrival pointer
        int j = 0;   // departure pointer

        int count = 1;  // current platforms needed
        int ans = 1;    // maximum platforms needed

        // Step 3: Traverse both arrays
        while (i < n && j < n) {

            // If train arrives before or at same time as another departs
            if (Arrival[i] <= Departure[j]) {
                count++;
                i++;
            } else {
                // A train departs, one platform gets free
                count--;
                j++;
            }

            // Update maximum platforms needed
            ans = Math.max(ans, count);
        }

        return ans;
    }

    public static void main(String[] args) {

        _06_Minimum_Platform obj = new _06_Minimum_Platform();

        int[] arr1 = {900, 940, 950, 1100, 1500, 1800};
        int[] dep1 = {910, 1200, 1120, 1130, 1900, 2000};

        int[] arr2 = {900, 1100, 1235};
        int[] dep2 = {1000, 1200, 1240};

        int[] arr3 = {900, 1000, 1200};
        int[] dep3 = {1000, 1200, 1240};

        System.out.println("Example 1: " + obj.findPlatform(arr1, dep1)); // 3
        System.out.println("Example 2: " + obj.findPlatform(arr2, dep2)); // 1
        System.out.println("Test Case: " + obj.findPlatform(arr3, dep3)); // 2
    }
}