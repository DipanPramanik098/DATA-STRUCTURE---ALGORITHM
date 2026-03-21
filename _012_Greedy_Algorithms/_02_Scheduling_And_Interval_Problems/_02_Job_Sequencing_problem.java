package _012_Greedy_Algorithms._02_Scheduling_And_Interval_Problems;

import java.util.Arrays;

public class _02_Job_Sequencing_problem {

    // Function to return [number of jobs done, maximum profit]
    public int[] JobScheduling(int[][] Jobs) {

        // Step 1: Sort jobs in descending order of profit
        Arrays.sort(Jobs, (a, b) -> b[2] - a[2]);

        // Step 2: Find maximum deadline
        int maxDeadline = 0;
        for (int[] job : Jobs) {
            maxDeadline = Math.max(maxDeadline, job[1]);
        }

        // Step 3: Create slot array
        // slot[i] = -1 means free
        int[] slot = new int[maxDeadline + 1];
        Arrays.fill(slot, -1);

        int countJobs = 0;
        int totalProfit = 0;

        // Step 4: Schedule jobs
        for (int i = 0; i < Jobs.length; i++) {

            int jobId = Jobs[i][0];
            int deadline = Jobs[i][1];
            int profit = Jobs[i][2];

            // Try to place job in latest free slot before deadline
            for (int j = deadline; j >= 1; j--) {
                if (slot[j] == -1) {
                    slot[j] = jobId;
                    countJobs++;
                    totalProfit += profit;
                    break;
                }
            }
        }

        // Step 5: Return result
        return new int[]{countJobs, totalProfit};
    }

    public static void main(String[] args) {

        _02_Job_Sequencing_problem obj = new _02_Job_Sequencing_problem();

        int[][] jobs1 = {
                {1, 4, 20},
                {2, 1, 10},
                {3, 1, 40},
                {4, 1, 30}
        };

        int[][] jobs2 = {
                {1, 2, 100},
                {2, 1, 19},
                {3, 2, 27},
                {4, 1, 25},
                {5, 1, 15}
        };

        int[][] jobs3 = {
                {1, 1, 100},
                {2, 2, 200},
                {3, 3, 300},
                {4, 4, 400}
        };

        int[] ans1 = obj.JobScheduling(jobs1);
        int[] ans2 = obj.JobScheduling(jobs2);
        int[] ans3 = obj.JobScheduling(jobs3);

        System.out.println("Example 1: Jobs = " + ans1[0] + ", Profit = " + ans1[1]);
        System.out.println("Example 2: Jobs = " + ans2[0] + ", Profit = " + ans2[1]);
        System.out.println("Test Case: Jobs = " + ans3[0] + ", Profit = " + ans3[1]);
    }
}