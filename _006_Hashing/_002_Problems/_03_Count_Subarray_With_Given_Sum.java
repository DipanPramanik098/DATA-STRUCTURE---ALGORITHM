package _006_Hashing._002_Problems;

import java.util.HashMap;

public class _03_Count_Subarray_With_Given_Sum {

	public int subarraySum(int[] nums, int k) {

		// HashMap stores:
		// key   -> prefix sum
		// value -> frequency of that prefix sum
		HashMap<Integer, Integer> prefixSumMap = new HashMap<>();

		// Current running prefix sum
		int currentPrefixSum = 0;

		// Final answer: number of subarrays with sum = k
		int subarrayCount = 0;

		// Put prefix sum 0 with frequency 1.
		// This is important to count subarrays that start from index 0.
		prefixSumMap.put(0, 1);

		// Traverse the array
		for (int i = 0; i < nums.length; i++) {

			// Add current element to prefix sum
			currentPrefixSum += nums[i];

			// We need a previous prefix sum such that:
			// currentPrefixSum - previousPrefixSum = k
			// => previousPrefixSum = currentPrefixSum - k
			int sumToRemove = currentPrefixSum - k;

			// If this required prefix sum exists, then add its frequency to the answer
			subarrayCount += prefixSumMap.getOrDefault(sumToRemove, 0);

			// Store/update frequency of current prefix sum
			prefixSumMap.put(currentPrefixSum, prefixSumMap.getOrDefault(currentPrefixSum, 0) + 1);
		}

		// Return total count
		return subarrayCount;
	}

	public static void main(String[] args) {

		_03_Count_Subarray_With_Given_Sum obj = new _03_Count_Subarray_With_Given_Sum();

		int[] nums = {3, 1, 2, 4};
		int k = 6;

		int ans = obj.subarraySum(nums, k);

		System.out.println("Count of subarrays with sum " + k + " is: " + ans);
	}
}