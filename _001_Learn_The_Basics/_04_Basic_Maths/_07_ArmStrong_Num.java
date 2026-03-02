package _04_Basic_Maths;

public class _07_ArmStrong_Num {

    // Function to count digits
    public static int countDigit(int n) {

        if (n == 0) {
            return 1;
        }

        int count = 0;

        while (n > 0) {
            count++;
            n = n / 10;
        }

        return count;
    }

    // Function to check Armstrong number
    public static boolean isArmstrong(int n) {

        int copy = n;               // Store original number
        int count = countDigit(n);  // Count digits
        int sum = 0;

        while (n > 0) {

            int lastDigit = n % 10;

            // Add digit^count to sum
            sum += Math.pow(lastDigit, count);

            n = n / 10;
        }

        return sum == copy;
    }

    public static void main(String[] args) {

        int n = 153;

        boolean result = isArmstrong(n);

        if (result) {
            System.out.println(n + " is an Armstrong number.");
        } else {
            System.out.println(n + " is not an Armstrong number.");
        }
    }
}