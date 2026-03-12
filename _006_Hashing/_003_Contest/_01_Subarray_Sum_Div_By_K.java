package _006_Hashing._003_Contest;

import java.util.HashMap;

public class _01_Subarray_Sum_Div_By_K {

    public int subarraySumDivisbleByK(int[] nums, int k) {

        // HashMap stores:
        // key   -> remainder when prefix sum is divided by k
        // value -> frequency of that remainder
        HashMap<Integer, Integer> map = new HashMap<>();

        // Put remainder 0 with frequency 1
        // This handles subarrays starting from index 0
        map.put(0, 1);

        // Running prefix sum
        int sum = 0;

        // Final answer: total count of valid subarrays
        int count = 0;

        // Traverse the array
        for (int i = 0; i < nums.length; i++) {

            // Add current element to prefix sum
            sum += nums[i];

            // Compute remainder
            // This formula handles negative sum also
            int rem = ((sum % k) + k) % k;

            // If same remainder appeared before,
            // then those many subarrays ending here
            // have sum divisible by k
            count += map.getOrDefault(rem, 0);

            // Update frequency of current remainder
            map.put(rem, map.getOrDefault(rem, 0) + 1);
        }

        // Return final count
        return count;
    }

    public static void main(String[] args) {

        _01_Subarray_Sum_Div_By_K obj = new _01_Subarray_Sum_Div_By_K();

        int[] nums = {3, 1, 4, 1};
        int k = 3;

        int ans = obj.subarraySumDivisbleByK(nums, k);

        System.out.println("Count of subarrays with sum divisible by " + k + " is: " + ans);
    }
}