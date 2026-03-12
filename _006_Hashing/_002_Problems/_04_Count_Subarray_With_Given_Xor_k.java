package _006_Hashing._002_Problems;

import java.util.HashMap;

public class _04_Count_Subarray_With_Given_Xor_k {

	public int subarraysWithXorK(int[] nums, int k) {

		// HashMap stores:
		// key   -> prefix XOR
		// value -> frequency of that prefix XOR
		HashMap<Integer, Integer> prefixXorMap = new HashMap<>();

		// Current prefix XOR
		int xr = 0;

		// Final answer: number of subarrays having XOR = k
		int count = 0;

		// Put 0 in the map with frequency 1.
		// This is important for subarrays starting from index 0.
		prefixXorMap.put(0, 1);

		// Traverse the array
		for (int i = 0; i < nums.length; i++) {

			// Update prefix XOR till current index
			xr = xr ^ nums[i];

			// Required previous prefix XOR because:
			// previousXor ^ currentXor = k
			// => previousXor = currentXor ^ k
			int requiredXor = xr ^ k;

			// Add frequency of requiredXor to answer
			count += prefixXorMap.getOrDefault(requiredXor, 0);

			// Store/update current prefix XOR in the map
			prefixXorMap.put(xr, prefixXorMap.getOrDefault(xr, 0) + 1);
		}

		// Return total count
		return count;
	}

	public static void main(String[] args) {

		_04_Count_Subarray_With_Given_Xor_k obj = new _04_Count_Subarray_With_Given_Xor_k();

		int[] nums = {4, 2, 2, 6, 4};
		int k = 6;

		int ans = obj.subarraysWithXorK(nums, k);

		System.out.println("Count of subarrays with XOR " + k + " is: " + ans);
	}
}