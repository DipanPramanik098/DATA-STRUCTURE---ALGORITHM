package _19_Dynamic_Programming.Lession_10;

import java.util.Arrays;

public class _01_Zero_One_KnapSack {

    // =========================
    // Recursive
    // TC: O(2^N)
    // SC: O(N)
    // =========================
    public static int solve1(int n, int W, int[] val, int[] wt) {

        if (n == 0 || W == 0)
            return 0;

        if (wt[n - 1] <= W) {
            return Math.max(
                    val[n - 1] + solve1(n - 1, W - wt[n - 1], val, wt),
                    solve1(n - 1, W, val, wt));
        }

        return solve1(n - 1, W, val, wt);
    }

    // =========================
    // Top Down DP (Memoization)
    // TC: O(N*W)
    // SC: O(N*W) + O(N)
    // =========================
    public static int solve2(int n, int W, int[] val, int[] wt, int[][] dp) {

        if (n == 0 || W == 0)
            return 0;

        if (dp[n][W] != -1)
            return dp[n][W];

        if (wt[n - 1] <= W) {
            return dp[n][W] = Math.max(
                    val[n - 1] + solve2(n - 1, W - wt[n - 1], val, wt, dp),
                    solve2(n - 1, W, val, wt, dp));
        }

        return dp[n][W] = solve2(n - 1, W, val, wt, dp);
    }

    // =========================
    // Bottom Up DP (Tabulation)
    // TC: O(N*W)
    // SC: O(N*W)
    // =========================
    public static int solve3(int[] val, int[] wt, int W) {

        int n = wt.length;
        int[][] dp = new int[n + 1][W + 1];

        for (int i = 1; i <= n; i++) {
            for (int w = 1; w <= W; w++) {

                if (wt[i - 1] <= w) {
                    dp[i][w] = Math.max(
                            val[i - 1] + dp[i - 1][w - wt[i - 1]],
                            dp[i - 1][w]);
                } else {
                    dp[i][w] = dp[i - 1][w];
                }
            }
        }

        return dp[n][W];
    }

    // =========================
    // Space Optimized DP
    // TC: O(N*W)
    // SC: O(W)
    // =========================
    public static int solve4(int[] val, int[] wt, int W) {

        int n = wt.length;
        int[] dp = new int[W + 1];

        for (int i = 0; i < n; i++) {

            // Traverse backwards for 0/1 Knapsack
            for (int w = W; w >= wt[i]; w--) {
                dp[w] = Math.max(
                        dp[w],
                        val[i] + dp[w - wt[i]]);
            }
        }

        return dp[W];
    }

    // =========================
    // Driver
    // =========================
    public static void main(String[] args) {

        int[] val = {60, 100, 120};
        int[] wt = {10, 20, 30};
        int W = 50;

        int n = wt.length;

        System.out.println("Recursive : " + solve1(n, W, val, wt));

        int[][] dp = new int[n + 1][W + 1];
        for (int[] row : dp)
            Arrays.fill(row, -1);

        System.out.println("Top Down  : " + solve2(n, W, val, wt, dp));

        System.out.println("Bottom Up : " + solve3(val, wt, W));

        System.out.println("Space Opt : " + solve4(val, wt, W));
    }
}