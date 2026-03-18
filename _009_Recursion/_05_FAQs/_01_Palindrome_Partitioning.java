package _009_Recursion._05_FAQs;

import java.util.*;

public class _01_Palindrome_Partitioning {

    // Function to check if substring s[start...end] is palindrome
    public static boolean isPalindrome(String s, int start, int end) {
        while (start < end) {
            if (s.charAt(start) != s.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

    // Recursive backtracking function
    public static void solve(int index, String s, List<String> current, List<List<String>> ans) {

        // ✅ If whole string is partitioned
        if (index == s.length()) {
            ans.add(new ArrayList<>(current));
            return;
        }

        // Try every possible substring starting from index
        for (int i = index; i < s.length(); i++) {

            // Check if current substring is palindrome
            if (isPalindrome(s, index, i)) {

                // Pick substring
                current.add(s.substring(index, i + 1));

                // Recur for remaining string
                solve(i + 1, s, current, ans);

                // Backtrack
                current.remove(current.size() - 1);
            }
        }
    }

    // Main function
    public static List<List<String>> partition(String s) {
        List<List<String>> ans = new ArrayList<>();
        solve(0, s, new ArrayList<>(), ans);
        return ans;
    }

    public static void main(String[] args) {
        String s = "aab";
        System.out.println(partition(s));
    }
}