package _06_Basic_Hashing;

import java.util.*;

public class _02_Highest_Occuring_Element {

    // Method to find most frequent element
    public static int mostFrequentElement(int[] nums) {

        int n = nums.length;

        // HashMap to store frequency
        HashMap<Integer, Integer> map = new HashMap<>();

        // Step 1: Count frequency
        for (int i = 0; i < n; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }

        int maxFreq = 0;
        int maxEle = Integer.MAX_VALUE;

        // Step 2: Find element with highest frequency
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {

            int ele = entry.getKey();
            int freq = entry.getValue();

            if (freq > maxFreq) {
                maxFreq = freq;
                maxEle = ele;
            }
            else if (freq == maxFreq) {
                maxEle = Math.min(maxEle, ele);
            }
        }

        return maxEle;
    }

    public static void main(String[] args) {

        int[] nums = {4, 4, 5, 5, 6};

        int ans = mostFrequentElement(nums);

        System.out.println("Highest Occurring Element: " + ans);
    }
}