package _009_Recursion._01_Implementation_Problems;

public class _01_Power_Of_x_n {

    // Recursive helper function to calculate x^n
    private double power(double x, long n) {

        // Base case: any number power 0 = 1
        if (n == 0)
            return 1.0;

        // Base case: power 1 = number itself
        if (n == 1)
            return x;

        // If exponent is EVEN
        if (n % 2 == 0) {

            // Square the base and reduce exponent by half
            return power(x * x, n / 2);
        }

        // If exponent is ODD
        // Multiply one x and reduce exponent by 1
        return x * power(x, n - 1);
    }

    // Main function
    public double myPow(double x, int n) {

        // Convert to long to avoid overflow
        long num = n;

        // If exponent is negative
        if (num < 0) {

            // compute positive power and take reciprocal
            return 1.0 / power(x, -num);
        }

        // If exponent is positive
        return power(x, num);
    }

    public static void main(String[] args) {

        _01_Power_Of_x_n obj = new _01_Power_Of_x_n();

        double result = obj.myPow(2.0, 10);

        System.out.printf("%.4f", result);
    }
}