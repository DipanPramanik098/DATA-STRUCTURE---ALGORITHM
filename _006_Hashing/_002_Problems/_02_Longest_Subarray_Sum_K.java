package _006_Hashing._002_Problems;

import java.util.HashMap;

public class _02_Longest_Subarray_Sum_K {

    public int longestSubarray(int[] nums, int k) {

        // HashMap stores:
        // key   -> prefix sum
        // value -> first index where this prefix sum appeared
        HashMap<Long, Integer> preSumMap = new HashMap<>();

        // Running prefix sum
        long sum = 0;

        // Stores maximum length of subarray having sum = k
        int maxLen = 0;

        // Traverse the array
        for (int i = 0; i < nums.length; i++) {

            // Add current element to prefix sum
            sum += nums[i];

            // Case 1:
            // If prefix sum itself becomes k,
            // then subarray from index 0 to i has sum k
            if (sum == k) {
                maxLen = Math.max(maxLen, i + 1);
            }

            // We need to find whether there exists
            // a previous prefix sum = sum - k
            long rem = sum - k;

            // If found, then subarray between
            // previous index + 1 to current index has sum k
            if (preSumMap.containsKey(rem)) {
                int len = i - preSumMap.get(rem);
                maxLen = Math.max(maxLen, len);
            }

            // Store the prefix sum only if it is appearing
            // for the first time
            // This is important because earliest occurrence
            // gives maximum subarray length
            if (!preSumMap.containsKey(sum)) {
                preSumMap.put(sum, i);
            }
        }

        // Return answer
        return maxLen;
    }

    public static void main(String[] args) {

        _02_Longest_Subarray_Sum_K obj = new _02_Longest_Subarray_Sum_K();

        int[] nums = {10, 5, 2, 7, 1, 9};
        int k = 15;

        int ans = obj.longestSubarray(nums, k);

        System.out.println("Length of the longest subarray with sum " + k + " is: " + ans);
    }
}