package _013_Sliding_Window_And_Two_Pointer._05_Contest;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class _02_Maximum_Good_Subarray_Length {

    public int maxGoodSubarray(int[] nums, int[] badNumbers) {
        Set<Integer> badSet = new HashSet<>();
        for (int num : badNumbers) {
            badSet.add(num);
        }

        Map<Integer, Integer> freq = new HashMap<>();
        int start = 0;
        int maxLen = 0;
        int badCount = 0; // number of distinct bad numbers in current window

        for (int end = 0; end < nums.length; end++) {
            int cur = nums[end];
            if (badSet.contains(cur)) {
                freq.put(cur, freq.getOrDefault(cur, 0) + 1);
                if (freq.get(cur) == 1) {
                    badCount++; // new distinct bad number
                }
            }

            // Shrink while window contains all bad numbers
            while (badCount == badSet.size()) {
                int left = nums[start];
                if (badSet.contains(left)) {
                    freq.put(left, freq.get(left) - 1);
                    if (freq.get(left) == 0) {
                        badCount--;
                    }
                }
                start++;
            }

            // Window [start, end] is good
            maxLen = Math.max(maxLen, end - start + 1);
        }
        return maxLen;
    }

    // Optional: main method for testing
    public static void main(String[] args) {
        _02_Maximum_Good_Subarray_Length solver = new _02_Maximum_Good_Subarray_Length();

        int[] nums1 = {2, 7, 3, 4, 5, 3};
        int[] bad1 = {7, 5};
        System.out.println(solver.maxGoodSubarray(nums1, bad1)); // 4

        int[] nums2 = {8, 7, 3, 0, 2, 3, 6};
        int[] bad2 = {3, 7};
        System.out.println(solver.maxGoodSubarray(nums2, bad2)); // 5

        int[] nums3 = {1, 2, 3, 4, 5, 6, 7};
        int[] bad3 = {3, 5, 7};
        System.out.println(solver.maxGoodSubarray(nums3, bad3)); // 5? Let's see: window [1,2,3,4,5,6] contains 3,5 but not 7 -> length 6. Actually check: The longest missing at least one bad number is the whole array except maybe shrink to exclude 7. Whole array length 7 contains all bad numbers → bad. So we need to shrink from left until one bad is missing. For [2,3,4,5,6] length 5 missing 7? Actually 2,3,4,5,6 contains 3 and 5 (still all bad numbers? bad are 3,5,7; missing 7, so good). So max length 5. Yes.
    }
}