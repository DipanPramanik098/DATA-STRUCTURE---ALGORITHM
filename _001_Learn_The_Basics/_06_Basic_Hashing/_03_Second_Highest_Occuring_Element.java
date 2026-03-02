package _06_Basic_Hashing;

import java.util.*;

public class _03_Second_Highest_Occuring_Element {

    public static int secondMostFrequentElement(int[] nums) {

        int n = nums.length;

        if (n == 0) return -1;

        HashMap<Integer, Integer> map = new HashMap<>();

        // Step 1: Count frequencies
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        int maxFreq = 0, secMaxFreq = 0;
        int maxEle = -1, secEle = -1;

        // Step 2: Find highest & second highest frequency
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {

            int ele = entry.getKey();
            int freq = entry.getValue();

            if (freq > maxFreq) {

                secMaxFreq = maxFreq;
                secEle = maxEle;

                maxFreq = freq;
                maxEle = ele;
            }

            else if (freq == maxFreq) {
                maxEle = Math.min(maxEle, ele);
            }

            else if (freq > secMaxFreq) {
                secMaxFreq = freq;
                secEle = ele;
            }

            else if (freq == secMaxFreq) {
                secEle = Math.min(secEle, ele);
            }
        }

        if (secMaxFreq == 0) return -1;

        return secEle;
    }

    public static void main(String[] args) {

        int[] nums = {4, 4, 5, 5, 6, 7};

        int ans = secondMostFrequentElement(nums);

        System.out.println("Second Highest Occurring Element: " + ans);
    }
}