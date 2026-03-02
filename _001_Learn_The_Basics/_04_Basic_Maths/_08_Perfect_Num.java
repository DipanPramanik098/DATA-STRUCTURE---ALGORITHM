package _04_Basic_Maths;

public class _08_Perfect_Num {

    // Function to check perfect number
    public static boolean isPerfect(int n) {

        // Edge Case: 1 is not a perfect number
        if (n == 1) {
            return false;
        }

        // Variable to store sum of proper divisors
        int sum = 0;

        // Loop from 1 to sqrt(n)
        for (int i = 1; i <= Math.sqrt(n); i++) {

            // Check if i is divisor
            if (n % i == 0) {

                // Add divisor
                sum += i;

                // Find counterpart divisor
                int counterpart = n / i;

                // Add counterpart if:
                // 1. Not equal to n
                // 2. Not equal to i (avoid duplicate for perfect square)
                if (counterpart != n && counterpart != i) {
                    sum += counterpart;
                }
            }
        }

        return sum == n;
    }

    public static void main(String[] args) {

        int n = 6;

        boolean result = isPerfect(n);

        if (result) {
            System.out.println(n + " is a Perfect number.");
        } else {
            System.out.println(n + " is not a Perfect number.");
        }
    }
}