package _006_Hashing._001_Theory;

import java.util.HashMap;

public class _04_Sum_Of_high_and_Low_Frequency {
    public static int sumHighestAndLowestFrequency(int[] nums) {

        int n = nums.length;

        if (n == 0) return 0;

        HashMap<Integer, Integer> map = new HashMap<>();

        // Step 1: Count frequencies
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        int maxFreq = 0;
        int minFreq = n;   // initialize with maximum possible value

        // Step 2: Find max and min frequency
        for (int freq : map.values()) {

            maxFreq = Math.max(maxFreq, freq);
            minFreq = Math.min(minFreq, freq);
        }

        return maxFreq + minFreq;
    }

    public static void main(String[] args) {

        int[] nums = {1, 2, 2, 3, 3, 3};

        int ans = sumHighestAndLowestFrequency(nums);

        System.out.println("Sum of Highest and Lowest Frequency: " + ans);
    }
}
