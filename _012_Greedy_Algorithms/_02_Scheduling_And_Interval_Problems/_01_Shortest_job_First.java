package _012_Greedy_Algorithms._02_Scheduling_And_Interval_Problems;

import java.util.Arrays;

public class _01_Shortest_job_First {

    // Function to calculate average waiting time
    public long solve(int[] bt) {

        // Step 1: Sort jobs
        Arrays.sort(bt);

        long totalTime = 0;
        long waitTime = 0;

        // Step 2: Calculate waiting time
        for (int i = 0; i < bt.length; i++) {

            // Add waiting time for current job
            waitTime += totalTime;

            // Update total execution time
            totalTime += bt[i];
        }

        // Step 3: Return average waiting time
        return waitTime / bt.length;
    }

    public static void main(String[] args) {

        _01_Shortest_job_First obj = new _01_Shortest_job_First();

        int[] bt1 = {4, 1, 3, 7, 2};
        int[] bt2 = {1, 2, 3, 4};
        int[] bt3 = {9, 3, 1, 8, 2};

        System.out.println("Example 1: " + obj.solve(bt1)); // 4
        System.out.println("Example 2: " + obj.solve(bt2)); // 2
        System.out.println("Test Case: " + obj.solve(bt3)); // 4
    }
}