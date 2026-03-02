package _08_Basic_Recursion;

/**
 * Program to check if a number is prime using recursion.
 *
 * Approach:
 * 1. Check divisibility from 2 to sqrt(num)
 * 2. If divisor found → not prime
 * 3. If no divisor found till sqrt(num) → prime
 *
 * Time Complexity  : O(√N)
 * Space Complexity : O(√N) (recursion stack)
 */

public class _06_Check_Prime {

    // Public method to start prime checking
    public static boolean checkPrime(int num) {

        // Base Case: 0 and 1 are not prime
        if (num <= 1) {
            return false;
        }

        return prime(num, 2);
    }

    // Recursive helper method
    private static boolean prime(int num, int divisor) {

        // If divisor exceeds square root, number is prime
        if (divisor > Math.sqrt(num)) {
            return true;
        }

        // If divisible, not prime
        if (num % divisor == 0) {
            return false;
        }

        // Recursive call with next divisor
        return prime(num, divisor + 1);
    }

    public static void main(String[] args) {

        System.out.println("5 → " + checkPrime(5));
        System.out.println("15 → " + checkPrime(15));
        System.out.println("7 → " + checkPrime(7));
    }
}