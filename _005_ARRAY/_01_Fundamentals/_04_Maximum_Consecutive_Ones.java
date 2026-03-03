package _005_ARRAY._01_Fundamentals;

public class _04_Maximum_Consecutive_Ones {

    // Method to find maximum consecutive 1s
    public static int findMaxConsecutiveOnes(int[] nums) {

        int count = 0;
        int maxCount = 0;

        // Traverse the array
        for (int i = 0; i < nums.length; i++) {

            if (nums[i] == 1) {
                count++;
                maxCount = Math.max(maxCount, count);
            } else {
                count = 0;  // Reset when 0 found
            }
        }

        return maxCount;
    }

    public static void main(String[] args) {

        int[] nums = {1, 0, 1, 1, 1, 0, 1, 1, 1};

        int result = findMaxConsecutiveOnes(nums);

        System.out.println("Maximum Consecutive 1s: " + result);
    }
}