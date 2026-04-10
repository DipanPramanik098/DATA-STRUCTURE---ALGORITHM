package _013_Sliding_Window_And_Two_Pointer._03_Longest_And_Smallest_Window_Problem;

public class _02_Maximum_Consecutive_Ones3 {

    public static int longestOnes(int[] nums, int k) {

        int n = nums.length;

        int l = 0;
        int r = 0;

        int zeros = 0;
        int maxLen = 0;

        while (r < n) {

            // If current element is 0, include it in zero count
            if (nums[r] == 0) {
                zeros++;
            }

            // If zeros exceed k, shrink window from left
            while (zeros > k) {
                if (nums[l] == 0) {
                    zeros--;
                }
                l++;
            }

            // Current valid window length
            int len = r - l + 1;

            // Update maximum length
            maxLen = Math.max(maxLen, len);

            r++;
        }

        return maxLen;
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0};
        int k = 2;

        int result = longestOnes(nums, k);

        System.out.println("Maximum consecutive ones after flipping at most " + k + " zeros: " + result);
    }
}