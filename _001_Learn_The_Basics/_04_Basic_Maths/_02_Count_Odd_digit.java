package _04_Basic_Maths;

public class _02_Count_Odd_digit {

    // Function to count number of odd digits
    public static int countOddDigit(int n) {

        // Counter to store number of odd digits
        int oddDigits = 0;

        // Edge Case: If number is 0
        if (n == 0) {
            return 0; // 0 is even, so no odd digit
        }

        // Loop until number becomes 0
        while (n > 0) {

            // Extract last digit
            int lastDigit = n % 10;

            // Check if the digit is odd
            if (lastDigit % 2 != 0) {

                // Increment counter
                oddDigits++;
            }

            // Remove last digit
            n = n / 10;
        }

        return oddDigits;
    }

    public static void main(String[] args) {

        int n = 6678;

        // Calling function
        int result = countOddDigit(n);

        System.out.println("Number of odd digits: " + result);
    }
}