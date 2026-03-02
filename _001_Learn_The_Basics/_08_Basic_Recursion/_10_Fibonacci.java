package _08_Basic_Recursion;

/**
 * Program to calculate Fibonacci number using recursion.
 *
 * Definition:
 * F(0) = 0
 * F(1) = 1
 * F(n) = F(n-1) + F(n-2)
 *
 * Time Complexity  : O(2^N)
 * Space Complexity : O(N) (recursion stack)
 */

public class _10_Fibonacci {

    // Recursive method
    public static int fib(int n) {

        // Base Cases
        if (n == 0) return 0;
        if (n == 1) return 1;

        // Recursive Case
        return fib(n - 1) + fib(n - 2);
    }

    public static void main(String[] args) {

        int n = 5;

        System.out.println("Fibonacci number at position " + n + " is: " + fib(n));
    }
}