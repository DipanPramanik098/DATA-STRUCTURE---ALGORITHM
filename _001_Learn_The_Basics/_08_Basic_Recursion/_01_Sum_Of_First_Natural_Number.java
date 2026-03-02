package _08_Basic_Recursion;

/**
 * Program to find the sum of first N natural numbers using recursion.
 * 
 * Formula:
 * sum(N) = N + sum(N - 1)
 * 
 * Base Case:
 * sum(0) = 0
 * 
 * Time Complexity  : O(N)
 * Space Complexity : O(N) (due to recursion stack)
 */
public class _01_Sum_Of_First_Natural_Number {

    // Recursive function to calculate sum of first N natural numbers
    public static int NnumbersSum(int N) {

        // Base Case
        if (N == 0) {
            return 0;
        }

        // Recursive Case
        return N + NnumbersSum(N - 1);
    }

    public static void main(String[] args) {

        int N = 10;

        int result = NnumbersSum(N);

        System.out.println("Sum of first " + N + " natural numbers is: " + result);
    }
}