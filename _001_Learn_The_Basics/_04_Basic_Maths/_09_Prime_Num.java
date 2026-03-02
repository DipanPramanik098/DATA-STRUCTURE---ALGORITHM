package _04_Basic_Maths;

public class _09_Prime_Num {

    // Function to check if number is prime
    public static boolean isPrime(int n) {

        // Edge Case: Numbers less than 2 are not prime
        if (n < 2) {
            return false;
        }

        // Check divisibility up to square root of n
        for (int i = 2; i * i <= n; i++) {

            // If divisible, not prime
            if (n % i == 0) {
                return false;
            }
        }

        // If no divisors found, number is prime
        return true;
    }

    public static void main(String[] args) {

        int n = 5;

        boolean result = isPrime(n);

        if (result) {
            System.out.println(n + " is a Prime number.");
        } else {
            System.out.println(n + " is not a Prime number.");
        }
    }
}