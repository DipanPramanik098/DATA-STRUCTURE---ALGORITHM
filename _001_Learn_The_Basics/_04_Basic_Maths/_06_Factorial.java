package _04_Basic_Maths;

public class _06_Factorial {

    // Function to calculate factorial
    public static int factorial(int n) {

        // Edge Case: 0! = 1
        if (n == 0) {
            return 1;
        }

        // Variable to store factorial value
        int fact = 1;

        // Loop from 1 to n
        for (int i = 1; i <= n; i++) {

            // Multiply fact with current number
            fact = fact * i;
        }

        return fact;
    }

    public static void main(String[] args) {

        int n = 4;

        int result = factorial(n);

        System.out.println("Factorial of the number: " + result);
    }
}