package _012_Greedy_Algorithms._02_Scheduling_And_Interval_Problems;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class _03_N_meeting_In_One_Room {

    // Function to find maximum number of meetings
    public int maxMeetings(int[] start, int[] end) {

        int n = start.length;

        // Step 1: Store meetings as {start, end}
        List<int[]> meetings = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            meetings.add(new int[]{start[i], end[i]});
        }

        // Step 2: Sort by end time
        Collections.sort(meetings, new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                return Integer.compare(a[1], b[1]);
            }
        });

        // Step 3: Select first meeting
        int count = 1;
        int limit = meetings.get(0)[1];

        // Step 4: Check remaining meetings
        for (int i = 1; i < n; i++) {
            if (meetings.get(i)[0] > limit) {
                count++;
                limit = meetings.get(i)[1];
            }
        }

        return count;
    }

    public static void main(String[] args) {

        _03_N_meeting_In_One_Room obj = new _03_N_meeting_In_One_Room();

        int[] start1 = {1, 3, 0, 5, 8, 5};
        int[] end1   = {2, 4, 6, 7, 9, 9};

        int[] start2 = {10, 12, 20};
        int[] end2   = {20, 25, 30};

        int[] start3 = {1, 4, 6, 9};
        int[] end3   = {2, 5, 7, 12};

        System.out.println("Example 1: " + obj.maxMeetings(start1, end1)); // 4
        System.out.println("Example 2: " + obj.maxMeetings(start2, end2)); // 1
        System.out.println("Test Case: " + obj.maxMeetings(start3, end3)); // 4
    }
}