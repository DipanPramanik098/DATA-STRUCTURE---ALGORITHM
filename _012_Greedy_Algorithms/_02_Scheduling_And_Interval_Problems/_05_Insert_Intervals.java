package _012_Greedy_Algorithms._02_Scheduling_And_Interval_Problems;

import java.util.ArrayList;
import java.util.List;

public class _05_Insert_Intervals {

    // Function to insert and merge new interval
    public int[][] insertNewInterval(int[][] intervals, int[] newInterval) {

        List<int[]> result = new ArrayList<>();
        int i = 0;
        int n = intervals.length;

        // Step 1: Add all intervals before newInterval
        while (i < n && intervals[i][1] < newInterval[0]) {
            result.add(intervals[i]);
            i++;
        }

        // Step 2: Merge overlapping intervals
        while (i < n && intervals[i][0] <= newInterval[1]) {
            newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            i++;
        }

        // Step 3: Add merged newInterval
        result.add(newInterval);

        // Step 4: Add remaining intervals
        while (i < n) {
            result.add(intervals[i]);
            i++;
        }

        // Convert list to array
        return result.toArray(new int[result.size()][]);
    }

    // Helper function to print intervals
    public static void printIntervals(int[][] intervals) {
        System.out.print("[ ");
        for (int i = 0; i < intervals.length; i++) {
            System.out.print("[" + intervals[i][0] + ", " + intervals[i][1] + "]");
            if (i != intervals.length - 1) System.out.print(", ");
        }
        System.out.println(" ]");
    }

    public static void main(String[] args) {

        _05_Insert_Intervals obj = new _05_Insert_Intervals();

        int[][] intervals1 = {{1, 3}, {6, 9}};
        int[] newInterval1 = {2, 5};

        int[][] intervals2 = {{1, 2}, {3, 5}, {6, 7}, {8, 10}};
        int[] newInterval2 = {4, 8};

        int[][] intervals3 = {{1, 2}, {3, 5}, {6, 7}, {8, 10}};
        int[] newInterval3 = {1, 8};

        System.out.println("Example 1:");
        printIntervals(obj.insertNewInterval(intervals1, newInterval1));

        System.out.println("Example 2:");
        printIntervals(obj.insertNewInterval(intervals2, newInterval2));

        System.out.println("Test Case:");
        printIntervals(obj.insertNewInterval(intervals3, newInterval3));
    }
}