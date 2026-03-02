package _08_Basic_Recursion;

/**
 * Program to check if a string is palindrome using recursion.
 *
 * Approach:
 * 1. Compare first and last characters.
 * 2. If equal → move inward.
 * 3. If mismatch → return false.
 *
 * Time Complexity  : O(N)
 * Space Complexity : O(N) (recursion stack)
 */

public class _05_CheckPalindrome {

    // Public method to start recursion
    public static boolean palindromeCheck(String s) {
        return isPalindrome(s, 0, s.length() - 1);
    }

    // Recursive helper function
    private static boolean isPalindrome(String s, int left, int right) {

        // Base Case
        if (left >= right) {
            return true;
        }

        // If characters don't match
        if (s.charAt(left) != s.charAt(right)) {
            return false;
        }

        // Recursive Call
        return isPalindrome(s, left + 1, right - 1);
    }

    public static void main(String[] args) {

        System.out.println("hannah → " + palindromeCheck("hannah"));
        System.out.println("aabbaA → " + palindromeCheck("aabbaA"));
        System.out.println("aba → " + palindromeCheck("aba"));
    }
}