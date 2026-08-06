package _19_Dynamic_Programming.Lession_12;

public class _01_Best_Time_To_Buy_Sell_5 {
    // https://leetcode.com/problems/best-time-to-buy-and-sell-stock-v/description/

    /*
     * DP State:
     *
     * dp[i][t][state]
     *
     * i     -> Current Day
     * t     -> Maximum completed transactions allowed
     *
     * state:
     * 0 -> No active transaction
     * 1 -> Holding a stock (Normal Buy)
     * 2 -> Holding a Short Position (Short Sell)
     *
     *
     * Transition:
     *
     * Neutral State
     * dp[i][t][0] =
     * max(
     *      dp[i-1][t][0],                 // Do Nothing
     *      dp[i-1][t][1] + price[i],      // Sell
     *      dp[i-1][t][2] - price[i]       // Buy Back
     * )
     *
     *
     * Buy State
     * dp[i][t][1] =
     * max(
     *      dp[i-1][t][1],                 // Hold
     *      dp[i-1][t-1][0] - price[i]     // Buy Today
     * )
     *
     *
     * Short State
     * dp[i][t][2] =
     * max(
     *      dp[i-1][t][2],                 // Hold Short
     *      dp[i-1][t-1][0] + price[i]     // Short Sell Today
     * )
     *
     *
     * Time Complexity  : O(n * k)
     * Space Complexity : O(n * k)
     */

    // ============================================================
    // 1. TABULATION (Bottom-Up)
    // ============================================================

    public long tabulation(int[] prices, int k) {

        int n = prices.length;

        long[][][] dp = new long[n][k + 1][3];

        // Day 0 initialization
        for (int t = 1; t <= k; t++) {
            dp[0][t][1] = -prices[0]; // Buy
            dp[0][t][2] = prices[0];  // Short Sell
        }

        for (int i = 1; i < n; i++) {

            for (int t = 1; t <= k; t++) {

                // Neutral State
                dp[i][t][0] = Math.max(
                        dp[i - 1][t][0],
                        Math.max(
                                dp[i - 1][t][1] + prices[i],
                                dp[i - 1][t][2] - prices[i]
                        )
                );

                // Holding Bought Stock
                dp[i][t][1] = Math.max(
                        dp[i - 1][t][1],
                        dp[i - 1][t - 1][0] - prices[i]
                );

                // Holding Short Position
                dp[i][t][2] = Math.max(
                        dp[i - 1][t][2],
                        dp[i - 1][t - 1][0] + prices[i]
                );
            }
        }

        long ans = 0;

        for (int t = 0; t <= k; t++)
            ans = Math.max(ans, dp[n - 1][t][0]);

        return ans;
    }

    // ============================================================
    // 2. SPACE OPTIMIZATION
    // ============================================================

    public long spaceOptimization(int[] prices, int k) {

        long[][] prev = new long[k + 1][3];
        long[][] curr = new long[k + 1][3];

        // Day 0 initialization
        for (int t = 1; t <= k; t++) {
            prev[t][1] = -prices[0];
            prev[t][2] = prices[0];
        }

        for (int i = 1; i < prices.length; i++) {

            for (int t = 1; t <= k; t++) {

                // Neutral State
                curr[t][0] = Math.max(
                        prev[t][0],
                        Math.max(
                                prev[t][1] + prices[i],
                                prev[t][2] - prices[i]
                        )
                );

                // Buy State
                curr[t][1] = Math.max(
                        prev[t][1],
                        prev[t - 1][0] - prices[i]
                );

                // Short State
                curr[t][2] = Math.max(
                        prev[t][2],
                        prev[t - 1][0] + prices[i]
                );
            }

            long[][] temp = prev;
            prev = curr;
            curr = temp;
        }

        long ans = 0;

        for (int t = 0; t <= k; t++)
            ans = Math.max(ans, prev[t][0]);

        return ans;
    }

    // ============================================================
    // DRIVER
    // ============================================================

    public long maximumProfit(int[] prices, int k) {

        // return tabulation(prices, k);

        return spaceOptimization(prices, k);
    }
}