package _013_Sliding_Window_And_Two_Pointer._03_Longest_And_Smallest_Window_Problem;

import java.util.HashMap;

public class _04_Longest_Substring_With_AtMost_k_Distinct_Character {

    public int kDistinctChar(String s, int k) {
        int n = s.length();
        int maxLen = 0;
        HashMap<Character, Integer> freq = new HashMap<>();
        int l = 0, r = 0;

        while (r < n) {
            char rightChar = s.charAt(r);
            freq.put(rightChar, freq.getOrDefault(rightChar, 0) + 1);

            // Shrink window if we exceed k distinct characters
            while (freq.size() > k) {
                char leftChar = s.charAt(l);
                freq.put(leftChar, freq.get(leftChar) - 1);
                if (freq.get(leftChar) == 0) {
                    freq.remove(leftChar);
                }
                l++;
            }

            // Now window is valid (≤ k distinct chars)
            maxLen = Math.max(maxLen, r - l + 1);
            r++;
        }
        return maxLen;
    }

    // Optional: main method for testing
    public static void main(String[] args) {
        _04_Longest_Substring_With_AtMost_k_Distinct_Character solver = new _04_Longest_Substring_With_AtMost_k_Distinct_Character();

        String s1 = "aababbcaacc";
        int k1 = 2;
        System.out.println(solver.kDistinctChar(s1, k1)); // 6

        String s2 = "abcddefg";
        int k2 = 3;
        System.out.println(solver.kDistinctChar(s2, k2)); // 4

        String s3 = "abccab";
        int k3 = 4;
        System.out.println(solver.kDistinctChar(s3, k3)); // 6
    }
}