package _009_Recursion._02_Subsequence_Pattern_Problems;

public class _01_Check_If_There_IS_A_Subsequence_With_Sum_K {

    // Recursive function to check subsequence sum
    public static boolean solve(int i, int n, int[] arr, int k) {

        // ✅ If target becomes 0 → subsequence found
        if (k == 0) return true;

        // ❌ If target becomes negative → invalid path
        if (k < 0) return false;

        // ❌ If all elements are used
        if (i == n) return false;

        // 👉 Choice 1: Take current element
        boolean take = solve(i + 1, n, arr, k - arr[i]);

        // 👉 Choice 2: Skip current element
        boolean notTake = solve(i + 1, n, arr, k);

        // If any path returns true → answer is true
        return take || notTake;
    }

    // Main function
    public static boolean checkSubsequenceSum(int[] nums, int target) {
        return solve(0, nums.length, nums, target);
    }

    // Driver code
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4};
        int k = 5;

        System.out.println(checkSubsequenceSum(nums, k)); // true
    }
}