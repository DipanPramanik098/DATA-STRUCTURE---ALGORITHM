package _009_Recursion._02_Subsequence_Pattern_Problems;

public class _02_Count_All_Subsequence_With_Sum_K {

    // Recursive function to count subsequences
    public static int solve(int index, int[] nums, int target) {

        // ✅ If target becomes 0 → one valid subsequence found
        if (target == 0) return 1;

        // ❌ If target becomes negative → invalid path
        if (target < 0) return 0;

        // ❌ If all elements are processed
        if (index == nums.length) return 0;

        // 👉 Choice 1: Take current element
        int take = solve(index + 1, nums, target - nums[index]);

        // 👉 Choice 2: Skip current element
        int notTake = solve(index + 1, nums, target);

        // Total ways = take + notTake
        return take + notTake;
    }

    // Main function
    public static int countSubsequenceWithTargetSum(int[] nums, int target) {
        return solve(0, nums, target);
    }

    public static void main(String[] args) {
        int[] nums = {4, 9, 2, 5, 1};
        int target = 10;

        System.out.println(countSubsequenceWithTargetSum(nums, target)); // 2
    }
}