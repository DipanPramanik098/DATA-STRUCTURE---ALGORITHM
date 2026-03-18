package _009_Recursion._04_Hard;

import java.util.*;

public class _01_Letter_Combination_Of_A_Phone_Number {

    // Phone keypad mapping
    static String[] map = {
            "", "", "abc", "def", "ghi",
            "jkl", "mno", "pqrs", "tuv", "wxyz"
    };

    // Recursive function
    public static void solve(int index, String digits, String current, List<String> ans) {

        // ✅ Base case: complete combination formed
        if (index == digits.length()) {
            ans.add(current);
            return;
        }

        // Get letters for current digit
        String letters = map[digits.charAt(index) - '0'];

        // Try every letter
        for (int i = 0; i < letters.length(); i++) {
            solve(index + 1, digits, current + letters.charAt(i), ans);
        }
    }

    // Main function
    public static List<String> letterCombinations(String digits) {

        List<String> ans = new ArrayList<>();

        // Edge case: empty input
        if (digits.length() == 0) return ans;

        solve(0, digits, "", ans);

        return ans;
    }

    public static void main(String[] args) {
        String digits = "23";
        System.out.println(letterCombinations(digits));
    }
}