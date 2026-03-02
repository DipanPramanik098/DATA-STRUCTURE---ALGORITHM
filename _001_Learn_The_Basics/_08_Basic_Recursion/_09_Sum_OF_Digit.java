package _08_Basic_Recursion;

/**
 * Program to repeatedly sum digits of a number
 * until a single digit remains.
 *
 * Time Complexity  : O(log N)
 * Space Complexity : O(log N) (recursion stack)
 */

public class _09_Sum_OF_Digit {

    // Public method
    public static int addDigits(int num) {

        // Base Case: single digit
        if (num < 10) {
            return num;
        }

        // Find sum of digits
        int sum = sumDigits(num);

        // Recursive call until single digit
        return addDigits(sum);
    }

    // Helper method to calculate sum of digits
    private static int sumDigits(int num) {

        // Base Case
        if (num == 0) {
            return 0;
        }

        // Recursive Case
        return sumDigits(num / 10) + (num % 10);
    }

    public static void main(String[] args) {

        int num1 = 529;
        int num2 = 101;

        System.out.println("Result for 529 → " + addDigits(num1));
        System.out.println("Result for 101 → " + addDigits(num2));
    }
}