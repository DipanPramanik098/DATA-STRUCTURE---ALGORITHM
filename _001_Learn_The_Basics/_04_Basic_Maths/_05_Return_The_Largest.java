package _04_Basic_Maths;

public class _05_Return_The_Largest {

    // Function to find the largest digit in a number
    public static int largestDigit(int n) {

        // Edge Case: If number is 0
        if (n == 0) {
            return 0;
        }

        // Variable to store the largest digit
        int largestDigit = 0;

        // Loop until all digits are processed
        while (n > 0) {

            // Extract last digit
            int lastDigit = n % 10;

            // Update largest digit if current digit is greater
            if (lastDigit > largestDigit) {
                largestDigit = lastDigit;
            }

            // Remove last digit
            n = n / 10;
        }

        return largestDigit;
    }

    public static void main(String[] args) {

        int n = 348;

        int result = largestDigit(n);

        System.out.println("Largest digit in the number: " + result);
    }
}