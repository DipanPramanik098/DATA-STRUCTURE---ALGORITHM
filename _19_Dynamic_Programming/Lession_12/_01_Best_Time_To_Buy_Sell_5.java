package _19_Dynamic_Programming.Lession_12;

public class _01_Best_Time_To_Buy_Sell_5 {
    // https://leetcode.com/problems/best-time-to-buy-and-sell-stock-v/description/

    // ==========================================================
    // 1. RECURSION
    // ==========================================================

    public long recursion(int i, int state, int transaction, int n, int[] price) {

        // No days or no transactions left
        if (i == n || transaction == 0)
            return 0;

        // ---------------- Free State ----------------
        // state = 0
        // Can:
        // 1. Skip
        // 2. Buy
        // 3. Short Sell
        if (state == 0) {

            long skip = recursion(i + 1, 0, transaction, n, price);

            long buy = -price[i]
                    + recursion(i + 1, 1, transaction, n, price);

            long shortSell = price[i]
                    + recursion(i + 1, 2, transaction, n, price);

            return Math.max(skip, Math.max(buy, shortSell));
        }

        // ---------------- Buy State ----------------
        // state = 1
        // Holding a stock after buying
        else if (state == 1) {

            long hold = recursion(i + 1, 1, transaction, n, price);

            long sell = price[i]
                    + recursion(i + 1, 0, transaction - 1, n, price);

            return Math.max(hold, sell);
        }

        // ---------------- Short State ----------------
        // state = 2
        // Holding a short position
        else {

            long hold = recursion(i + 1, 2, transaction, n, price);

            long buyBack = -price[i]
                    + recursion(i + 1, 0, transaction - 1, n, price);

            return Math.max(hold, buyBack);
        }
    }

    // ==========================================================
    // 2. MEMOIZATION (TOP DOWN)
    // ==========================================================

    long[][][] dp;

    public long memoization(int i, int state, int transaction, int n, int[] price) {

        if (i == n || transaction == 0)
            return 0;

        if (dp[i][state][transaction] != Long.MIN_VALUE)
            return dp[i][state][transaction];

        if (state == 0) {

            long skip = memoization(i + 1, 0, transaction, n, price);

            long buy = -price[i]
                    + memoization(i + 1, 1, transaction, n, price);

            long shortSell = price[i]
                    + memoization(i + 1, 2, transaction, n, price);

            return dp[i][state][transaction] =
                    Math.max(skip, Math.max(buy, shortSell));
        }

        else if (state == 1) {

            long hold = memoization(i + 1, 1, transaction, n, price);

            long sell = price[i]
                    + memoization(i + 1, 0, transaction - 1, n, price);

            return dp[i][state][transaction] =
                    Math.max(hold, sell);
        }

        else {

            long hold = memoization(i + 1, 2, transaction, n, price);

            long buyBack = -price[i]
                    + memoization(i + 1, 0, transaction - 1, n, price);

            return dp[i][state][transaction] =
                    Math.max(hold, buyBack);
        }
    }

    // ==========================================================
    // 3. TABULATION (BOTTOM UP)
    // ==========================================================

    public long tabulation(int[] price, int k) {

        int n = price.length;

        long[][][] dp = new long[n + 1][3][k + 1];

        // dp[n][*][*] = 0
        // dp[*][*][0] = 0

        for (int i = n - 1; i >= 0; i--) {

            for (int t = 1; t <= k; t++) {

                // Free State
                dp[i][0][t] = Math.max(
                        dp[i + 1][0][t],
                        Math.max(
                                -price[i] + dp[i + 1][1][t],
                                price[i] + dp[i + 1][2][t]
                        ));

                // Buy State
                dp[i][1][t] = Math.max(
                        dp[i + 1][1][t],
                        price[i] + dp[i + 1][0][t - 1]);

                // Short State
                dp[i][2][t] = Math.max(
                        dp[i + 1][2][t],
                        -price[i] + dp[i + 1][0][t - 1]);
            }
        }

        return dp[0][0][k];
    }

    // ==========================================================
    // 4. SPACE OPTIMIZATION
    // ==========================================================

    public long spaceOptimization(int[] price, int k) {

        long[][] next = new long[3][k + 1];
        long[][] curr = new long[3][k + 1];

        for (int i = price.length - 1; i >= 0; i--) {

            for (int t = 1; t <= k; t++) {

                // Free State
                curr[0][t] = Math.max(
                        next[0][t],
                        Math.max(
                                -price[i] + next[1][t],
                                price[i] + next[2][t]
                        ));

                // Buy State
                curr[1][t] = Math.max(
                        next[1][t],
                        price[i] + next[0][t - 1]);

                // Short State
                curr[2][t] = Math.max(
                        next[2][t],
                        -price[i] + next[0][t - 1]);
            }

            next = curr;
            curr = new long[3][k + 1];
        }

        return next[0][k];
    }

    // ==========================================================
    // DRIVER METHOD
    // ==========================================================

    public long maximumProfit(int[] prices, int k) {

        int n = prices.length;

        // ---------- Recursion ----------
        // return recursion(0, 0, k, n, prices);

        // ---------- Memoization ----------
        dp = new long[n][3][k + 1];

        for (int i = 0; i < n; i++)
            for (int j = 0; j < 3; j++)
                java.util.Arrays.fill(dp[i][j], Long.MIN_VALUE);

        // return memoization(0, 0, k, n, prices);

        // ---------- Tabulation ----------
        // return tabulation(prices, k);

        // ---------- Space Optimization ----------
        return spaceOptimization(prices, k);
    }
}