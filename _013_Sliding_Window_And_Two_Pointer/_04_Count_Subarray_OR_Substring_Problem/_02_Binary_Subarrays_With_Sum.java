package _013_Sliding_Window_And_Two_Pointer._04_Count_Subarray_OR_Substring_Problem;

public class _02_Binary_Subarrays_With_Sum {

    public int numSubarraysWithSum(int[] nums, int goal) {
        // Number of subarrays with sum ≤ goal minus number with sum ≤ goal-1
        return countSubarraysWithSumLessEqualTo(nums, goal) - countSubarraysWithSumLessEqualTo(nums, goal - 1);
    }

    private int countSubarraysWithSumLessEqualTo(int[] nums, int goal) {
        if (goal < 0) return 0; // No subarray can have negative sum

        int l = 0, sum = 0, count = 0;
        for (int r = 0; r < nums.length; r++) {
            sum += nums[r];
            // Shrink window from left if sum exceeds goal
            while (sum > goal) {
                sum -= nums[l];
                l++;
            }
            // All subarrays ending at r with start in [l, r] are valid
            count += (r - l + 1);
        }
        return count;
    }

    // Optional: main method for testing
    public static void main(String[] args) {
        _02_Binary_Subarrays_With_Sum solver = new _02_Binary_Subarrays_With_Sum();

        int[] nums1 = {1, 1, 0, 1, 0, 0, 1};
        int goal1 = 3;
        System.out.println(solver.numSubarraysWithSum(nums1, goal1)); // 4

        int[] nums2 = {0, 0, 0, 0, 1};
        int goal2 = 0;
        System.out.println(solver.numSubarraysWithSum(nums2, goal2)); // 10

        int[] nums3 = {1, 0, 0, 1, 1, 0};
        int goal3 = 2;
        System.out.println(solver.numSubarraysWithSum(nums3, goal3)); // 3
    }
}