package _013_Sliding_Window_And_Two_Pointer._03_Longest_And_Smallest_Window_Problem;

import java.util.Arrays;

public class _01_Longest_Substring_Without_Repeating_Characters {

    public static int longestNonRepeatingSubstring(String s) {
        int n = s.length();

        // Assuming ASCII characters
        int[] hash = new int[256];

        // Initially, no character is seen
        Arrays.fill(hash, -1);

        int l = 0;
        int r = 0;
        int maxLen = 0;

        while (r < n) {

            // If current character already exists in current window
            if (hash[s.charAt(r)] >= l) {
                l = Math.max(hash[s.charAt(r)] + 1, l);
            }

            // Current valid window length
            int len = r - l + 1;

            // Update answer
            maxLen = Math.max(maxLen, len);

            // Store latest index of current character
            hash[s.charAt(r)] = r;

            // Expand window
            r++;
        }

        return maxLen;
    }

    public static void main(String[] args) {
        String s = "abcddabac";

        int result = longestNonRepeatingSubstring(s);
        System.out.println("Length of longest substring without repeating characters: " + result);
    }
}