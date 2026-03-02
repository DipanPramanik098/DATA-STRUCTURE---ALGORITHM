package _04_Basic_Maths;

public class _01_Count_Digit {

    // Function to count digits
    public static int countDigit(int n) {

        // Edge Case: If number is 0
        if (n == 0) {
            return 1;
        }

        // Counter to store number of digits
        int cnt = 0;

        // Loop until number becomes 0
        while (n > 0) {

            // Increase digit count
            cnt++;

            // Remove last digit
            n = n / 10;
        }

        // Return total digits
        return cnt;
    }

    public static void main(String[] args) {

        int n = 6678;

        // Calling function
        int result = countDigit(n);

        System.out.println("Number of digits: " + result);
    }
}