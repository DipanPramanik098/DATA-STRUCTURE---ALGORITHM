package _19_Dynamic_Programming._01_Introduction;

import java.util.Arrays;

public class _02_Climbing_Stairs {

    // 1. Recursion
    public static int recursion(int n) {
        if (n <= 1) {
            return 1;
        }

        return recursion(n - 1) + recursion(n - 2);
    }


    // 2. Top-Down DP (Memoization)
    public static int topDown(int n, int[] dp) {

        if (n <= 1) {
            return 1;
        }

        if (dp[n] != -1) {
            return dp[n];
        }

        dp[n] = topDown(n - 1, dp) + topDown(n - 2, dp);

        return dp[n];
    }


    // 3. Bottom-Up DP (Tabulation)
    public static int bottomUp(int n) {

        if (n <= 1) {
            return 1;
        }

        int[] dp = new int[n + 1];

        dp[0] = 1;
        dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        return dp[n];
    }


    // 4. Space Optimization
    public static int spaceOptimized(int n) {

        if (n <= 1) {
            return 1;
        }

        int prev2 = 1;
        int prev1 = 1;

        for (int i = 2; i <= n; i++) {

            int curr = prev1 + prev2;

            prev2 = prev1;
            prev1 = curr;
        }

        return prev1;
    }


    public static void main(String[] args) {

        int n = 5;

        System.out.println("Recursion: " + recursion(n));

        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);
        System.out.println("Top Down: " + topDown(n, dp));

        System.out.println("Bottom Up: " + bottomUp(n));

        System.out.println("Space Optimized: " + spaceOptimized(n));
    }
}