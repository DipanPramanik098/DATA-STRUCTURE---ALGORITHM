package _08_Basic_Recursion;

/**
 * Program to calculate factorial of a number using recursion.
 * 
 * Factorial Definition:
 * n! = n × (n - 1)!
 * 
 * Base Case:
 * factorial(0) = 1
 * factorial(1) = 1
 * 
 * Time Complexity  : O(N)
 * Space Complexity : O(N) (due to recursion stack)
 */
public class _02_Factorial {

    // Recursive function to calculate factorial
    public static long factorial(int n) {

        // Base Case
        if (n <= 1) {
            return 1;
        }

        // Recursive Case
        return n * factorial(n - 1);
    }

    public static void main(String[] args) {

        int N = 5;

        long result = factorial(N);

        System.out.println("Factorial of " + N + " is: " + result);
    }
}