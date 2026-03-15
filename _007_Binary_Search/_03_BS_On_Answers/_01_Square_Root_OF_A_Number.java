package _007_Binary_Search._03_BS_On_Answers;

public class _01_Square_Root_OF_A_Number {

    // Function to compute floor of square root
    public int floorSqrt(int n) {

        int low = 1;
        int high = n;

        // Binary Search on answer space
        while (low <= high) {

            int mid = low + (high - low) / 2;

            // Use long to prevent overflow
            long val = (long) mid * mid;

            // If mid² <= n, move right
            if (val <= n) {
                low = mid + 1;
            }

            // If mid² > n, move left
            else {
                high = mid - 1;
            }
        }

        // high will contain the floor of sqrt(n)
        return high;
    }

    public static void main(String[] args) {

        _01_Square_Root_OF_A_Number obj =
                new _01_Square_Root_OF_A_Number();

        int n = 50;

        int result = obj.floorSqrt(n);

        System.out.println("Floor square root: " + result);
    }
}