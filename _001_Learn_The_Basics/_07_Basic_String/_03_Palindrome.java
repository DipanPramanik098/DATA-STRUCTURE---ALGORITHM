package _07_Basic_String;

public class _03_Palindrome {

    // ===============================
    // 1️⃣ Iterative Approach
    // ===============================
    public static boolean palindromeCheck(String s) {

        int left = 0;
        int right = s.length() - 1;

        while (left < right) {

            // If mismatch found
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }

            // Move inward
            left++;
            right--;
        }

        return true;
    }

    // ===============================
    // 2️⃣ Recursive Approach
    // ===============================
    public static boolean palindromeRecursive(String s, int left, int right) {

        // Base condition
        if (left >= right) {
            return true;
        }

        // If mismatch found
        if (s.charAt(left) != s.charAt(right)) {
            return false;
        }

        // Recursive call
        return palindromeRecursive(s, left + 1, right - 1);
    }

    // ===============================
    // Main Method
    // ===============================
    public static void main(String[] args) {

        String str1 = "hannah";
        String str2 = "aabbaaa";

        // Iterative check
        System.out.println(str1 + " -> " + palindromeCheck(str1));
        System.out.println(str2 + " -> " + palindromeCheck(str2));

        // Recursive check
        System.out.println(str1 + " (Recursive) -> " +
                palindromeRecursive(str1, 0, str1.length() - 1));
    }
}