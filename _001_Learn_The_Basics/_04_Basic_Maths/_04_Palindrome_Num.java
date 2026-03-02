package _04_Basic_Maths;

public class _04_Palindrome_Num {

    // Function to check palindrome number
    public static boolean isPalindrome(int n) {

        // Negative numbers are not palindrome
        if (n < 0) {
            return false;
        }

        int original = n;   // Store original number
        int revNum = 0;     // Variable to store reversed number

        // Reverse the number
        while (n > 0) {

            int lastDigit = n % 10;       // Extract last digit
            revNum = (revNum * 10) + lastDigit; // Build reversed number
            n = n / 10;                  // Remove last digit
        }

        // Compare original and reversed number
        return original == revNum;
    }

    public static void main(String[] args) {

        int n = 101;

        boolean result = isPalindrome(n);

        System.out.println("Is Palindrome? " + result);
    }
}