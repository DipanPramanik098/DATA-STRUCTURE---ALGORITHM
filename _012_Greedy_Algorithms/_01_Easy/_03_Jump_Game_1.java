package _012_Greedy_Algorithms._01_Easy;

public class _03_Jump_Game_1 {

    // Function to check if last index is reachable
    public boolean canJump(int[] nums) {

        int maxReach = 0;

        for (int i = 0; i < nums.length; i++) {

            // If current index is not reachable
            if (i > maxReach) {
                return false;
            }

            // Update farthest reachable index
            maxReach = Math.max(maxReach, i + nums[i]);
        }

        return true;
    }

    public static void main(String[] args) {

        _03_Jump_Game_1 obj = new _03_Jump_Game_1();

        int[] nums1 = {2, 3, 1, 1, 4};
        int[] nums2 = {3, 2, 1, 0, 4};
        int[] nums3 = {5, 3, 2, 1, 0};

        System.out.println("Example 1: " + obj.canJump(nums1)); // true
        System.out.println("Example 2: " + obj.canJump(nums2)); // false
        System.out.println("Test Case: " + obj.canJump(nums3)); // true
    }
}