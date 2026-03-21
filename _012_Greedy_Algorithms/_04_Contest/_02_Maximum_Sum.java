package _012_Greedy_Algorithms._04_Contest;

import java.util.Arrays;
import java.util.List;

public class _02_Maximum_Sum {

    // Function to find maximum sum after one prefix flip and one suffix flip
    public int maxSum(List<Integer> nums) {

        long totalSum = 0;

        // Kadane variables
        long currentSum = 0;
        long maxSubarraySum = 0; // allow empty subarray

        for (int num : nums) {
            totalSum += num;

            // Standard Kadane with empty subarray allowed
            currentSum = Math.max(0, currentSum + num);
            maxSubarraySum = Math.max(maxSubarraySum, currentSum);
        }

        long answer = 2 * maxSubarraySum - totalSum;

        return (int) answer;
    }

    public static void main(String[] args) {

        _02_Maximum_Sum obj = new _02_Maximum_Sum();

        List<Integer> nums1 = Arrays.asList(-1, 2, -3);
        List<Integer> nums2 = Arrays.asList(-1, 10, -5, 10, -2);
        List<Integer> nums3 = Arrays.asList(-5, -2, -3);

        System.out.println("Example 1: " + obj.maxSum(nums1)); // 6
        System.out.println("Example 2: " + obj.maxSum(nums2)); // 18
        System.out.println("Example 3: " + obj.maxSum(nums3)); // 10
    }
}