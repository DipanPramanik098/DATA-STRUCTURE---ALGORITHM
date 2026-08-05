package _19_Dynamic_Programming.Lession_11;

import java.util.Arrays;

public class _03_Best_Time_To_Buy_Sell_Stock_3 {

    // ===================== Recursive =====================
    public static int maxProfit(int i, int n, int buy, int transactions, int[] prices) {
        if (i == n || transactions == 0)
            return 0;

        if (buy == 1) {
            return Math.max(
                    -prices[i] + maxProfit(i + 1, n, 0, transactions, prices), // Buy
                    maxProfit(i + 1, n, 1, transactions, prices) // Skip
            );
        } else {
            return Math.max(
                    prices[i] + maxProfit(i + 1, n, 1, transactions - 1, prices), // Sell
                    maxProfit(i + 1, n, 0, transactions, prices) // Skip
            );
        }
    }

    // ===================== Top Down DP =====================
    public static int maxProfit1(int i, int n, int buy, int transactions,
                                 int[] prices, int[][][] dp) {

        if (i == n || transactions == 0)
            return 0;

        if (dp[i][buy][transactions] != -1)
            return dp[i][buy][transactions];

        if (buy == 1) {
            return dp[i][buy][transactions] = Math.max(
                    -prices[i] + maxProfit1(i + 1, n, 0, transactions, prices, dp),
                    maxProfit1(i + 1, n, 1, transactions, prices, dp));
        } else {
            return dp[i][buy][transactions] = Math.max(
                    prices[i] + maxProfit1(i + 1, n, 1, transactions - 1, prices, dp),
                    maxProfit1(i + 1, n, 0, transactions, prices, dp));
        }
    }

    // ===================== Bottom Up =====================
    public static int bottomUp(int[] prices) {

        int n = prices.length;
        int buy = 1;
        int transactions = 2;

        int[][][] dp = new int[n + 1][2][3];

        for (int[][] td : dp) {
            for (int[] row : td) {
                Arrays.fill(row, 0);
            }
        }

        for (int i = n - 1; i >= 0; i--) {
            for (int j = 0; j <= buy; j++) {
                for (int k = 1; k <= transactions; k++) {

                    if (j == 1) {
                        dp[i][j][k] = Math.max(
                                -prices[i] + dp[i + 1][0][k],
                                dp[i + 1][1][k]);
                    } else {
                        dp[i][j][k] = Math.max(
                                prices[i] + dp[i + 1][1][k - 1],
                                dp[i + 1][0][k]);
                    }
                }
            }
        }

        return dp[0][1][2];
    }

    // ===================== Space Optimized =====================
    public static int spaceOptimized(int[] prices) {

        int n = prices.length;
        int buy = 1;
        int transactions = 2;

        int[][] prev = new int[2][3];

        for (int i = n - 1; i >= 0; i--) {

            int[][] curr = new int[2][3];

            for (int[] row : curr) {
                Arrays.fill(row, 0);
            }

            for (int j = 0; j <= buy; j++) {
                for (int k = 1; k <= transactions; k++) {

                    if (j == 1) {
                        curr[j][k] = Math.max(
                                -prices[i] + prev[0][k],
                                prev[1][k]);
                    } else {
                        curr[j][k] = Math.max(
                                prices[i] + prev[1][k - 1],
                                prev[0][k]);
                    }
                }
            }

            prev = curr;
        }

        return prev[1][2];
    }

    public static void main(String[] args) {

        int[] prices1 = {3, 3, 5, 0, 0, 3, 1, 4};
        int[] prices2 = {1, 2, 3, 4, 5};
        int[] prices3 = {7, 6, 4, 3, 1};

        int n = prices1.length;
        int[][][] dp = new int[n + 1][2][3];

        for (int[][] td : dp) {
            for (int[] row : td) {
                Arrays.fill(row, -1);
            }
        }

        System.out.println("Recursive        : " + maxProfit(0, n, 1, 2, prices1));
        System.out.println("Top Down DP      : " + maxProfit1(0, n, 1, 2, prices1, dp));
        System.out.println("Bottom Up        : " + bottomUp(prices1));
        System.out.println("Space Optimized  : " + spaceOptimized(prices1));

        System.out.println();

        System.out.println("Example 2: " + spaceOptimized(prices2)); // 4
        System.out.println("Example 3: " + spaceOptimized(prices3)); // 0
    }
}