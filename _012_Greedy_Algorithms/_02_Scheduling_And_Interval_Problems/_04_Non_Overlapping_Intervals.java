package _012_Greedy_Algorithms._02_Scheduling_And_Interval_Problems;

import java.util.Arrays;

public class _04_Non_Overlapping_Intervals {

    // Function to return minimum number of intervals to remove
    public int eraseOverlapIntervals(int[][] intervals) {

        // Edge case
        if (intervals.length == 0) return 0;

        // Step 1: Sort by end time
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[1], b[1]));

        // Step 2: Select first interval
        int count = 1;
        int lastEnd = intervals[0][1];

        // Step 3: Check remaining intervals
        for (int i = 1; i < intervals.length; i++) {

            // Non-overlapping condition
            if (intervals[i][0] >= lastEnd) {
                count++;
                lastEnd = intervals[i][1];
            }
        }

        // Step 4: intervals to remove
        return intervals.length - count;
    }

    public static void main(String[] args) {

        _04_Non_Overlapping_Intervals obj = new _04_Non_Overlapping_Intervals();

        int[][] intervals1 = {
                {1, 2}, {2, 3}, {3, 4}, {1, 3}
        };

        int[][] intervals2 = {
                {1, 3}, {1, 4}, {3, 5}, {3, 4}, {4, 5}
        };

        int[][] intervals3 = {
                {1, 10}, {1, 4}, {3, 8}, {3, 4}, {4, 5}
        };

        System.out.println("Example 1: " + obj.eraseOverlapIntervals(intervals1)); // 1
        System.out.println("Example 2: " + obj.eraseOverlapIntervals(intervals2)); // 2
        System.out.println("Test Case: " + obj.eraseOverlapIntervals(intervals3)); // 3
    }
}