package _04_Basic_Maths;

public class _03_Reverse_A_Num {

    // Function to reverse a number
    public static int reverseNumber(int n) {

        // Variable to store reversed number
        int revNum = 0;

        // Loop until all digits are processed
        while (n > 0) {

            // Extract last digit
            int lastDigit = n % 10;

            // Append digit to reversed number
            revNum = (revNum * 10) + lastDigit;

            // Remove last digit from original number
            n = n / 10;
        }

        return revNum;
    }

    public static void main(String[] args) {

        int n = 6678;

        // Calling function
        int result = reverseNumber(n);

        System.out.println("Reverse of number: " + result);
    }
}