package _007_Binary_Search._03_BS_On_Answers;

public class _02_Find_Nth_Root_OF_A_Num {

    // Helper function:
    // Returns:
    // 1 -> if mid^n == m
    // 0 -> if mid^n < m
    // 2 -> if mid^n > m
    private int helperFunc(int mid, int n, int m) {
        long ans = 1;
        long base = mid;

        while (n > 0) {

            // If n is odd, multiply ans by base once
            if (n % 2 == 1) {
                ans *= base;

                // Early stopping if ans becomes greater than m
                if (ans > m) return 2;

                n--;
            } 
            // If n is even, square the base and reduce n by half
            else {
                n /= 2;
                base *= base;

                // Early stopping if base becomes greater than m
                if (base > m) return 2;
            }
        }

        // Final comparison
        if (ans == m) return 1;
        return 0;
    }

    // Function to find the Nth root of M
    public int NthRoot(int N, int M) {
        int low = 1;
        int high = M;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            int result = helperFunc(mid, N, M);

            if (result == 1) {
                return mid; // Exact root found
            } else if (result == 0) {
                low = mid + 1; // Need bigger value
            } else {
                high = mid - 1; // Need smaller value
            }
        }

        return -1; // No integer root exists
    }

    public static void main(String[] args) {
        _02_Find_Nth_Root_OF_A_Num obj = new _02_Find_Nth_Root_OF_A_Num();

        int N = 3, M = 27;
        System.out.println("Nth Root = " + obj.NthRoot(N, M)); // Output: 3

        N = 4;
        M = 69;
        System.out.println("Nth Root = " + obj.NthRoot(N, M)); // Output: -1

        N = 4;
        M = 81;
        System.out.println("Nth Root = " + obj.NthRoot(N, M)); // Output: 3
    }
}