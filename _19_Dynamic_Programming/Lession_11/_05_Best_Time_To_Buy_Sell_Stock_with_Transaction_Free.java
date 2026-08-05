package _19_Dynamic_Programming.Lession_11;

import java.util.Arrays;

public class _05_Best_Time_To_Buy_Sell_Stock_with_Transaction_Free {

    // ===================== Recursive =====================
    public static int recursive(int i, int buy, int n, int fee, int[] prices) {

        if (i == n)
            return 0;

        if (buy == 1) {
            return Math.max(
                    -prices[i] + recursive(i + 1, 0, n, fee, prices), // Buy
                    recursive(i + 1, 1, n, fee, prices) // Skip
            );
        } else {
            return Math.max(
                    prices[i] - fee + recursive(i + 1, 1, n, fee, prices), // Sell
                    recursive(i + 1, 0, n, fee, prices) // Skip
            );
        }
    }

    // ===================== Top Down DP (Rec → Memo) =====================
    public static int topDown(int i, int buy, int n, int fee,
                              int[] prices, int[][] dp) {

        if (i == n)
            return 0;

        if (dp[i][buy] != -1)
            return dp[i][buy];

        if (buy == 1) {
            return dp[i][buy] = Math.max(
                    -prices[i] + topDown(i + 1, 0, n, fee, prices, dp),
                    topDown(i + 1, 1, n, fee, prices, dp)
            );
        } else {
            return dp[i][buy] = Math.max(
                    prices[i] - fee + topDown(i + 1, 1, n, fee, prices, dp),
                    topDown(i + 1, 0, n, fee, prices, dp)
            );
        }
    }

    // ===================== Bottom Up (Memo → Tab) =====================
    public static int bottomUp(int[] prices, int fee) {

        int n = prices.length;
        int[][] dp = new int[n + 1][2];

        for (int i = n - 1; i >= 0; i--) {

            // buy = 1
            dp[i][1] = Math.max(
                    -prices[i] + dp[i + 1][0],
                    dp[i + 1][1]
            );

            // buy = 0
            dp[i][0] = Math.max(
                    prices[i] - fee + dp[i + 1][1],
                    dp[i + 1][0]
            );
        }

        return dp[0][1];
    }

    // ===================== Space Optimized (Tab → SO) =====================
    public static int spaceOptimized(int[] prices, int fee) {

        int n = prices.length;

        int[] prev = new int[2];

        for (int i = n - 1; i >= 0; i--) {

            int[] curr = new int[2];

            // buy = 1
            curr[1] = Math.max(
                    -prices[i] + prev[0],
                    prev[1]
            );

            // buy = 0
            curr[0] = Math.max(
                    prices[i] - fee + prev[1],
                    prev[0]
            );

            prev = curr;
        }

        return prev[1];
    }

    public static void main(String[] args) {

        int[] prices = {1, 3, 2, 8, 4, 9};
        int fee = 2;

        int n = prices.length;

        // Recursive
        System.out.println("Recursive       : " +
                recursive(0, 1, n, fee, prices));

        // Top Down
        int[][] dp = new int[n + 1][2];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        System.out.println("Top Down DP     : " +
                topDown(0, 1, n, fee, prices, dp));

        // Bottom Up
        System.out.println("Bottom Up       : " +
                bottomUp(prices, fee));

        // Space Optimized
        System.out.println("Space Optimized : " +
                spaceOptimized(prices, fee));
    }
}